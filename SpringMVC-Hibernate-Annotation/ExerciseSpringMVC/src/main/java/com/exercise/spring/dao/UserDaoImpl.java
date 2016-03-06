package com.exercise.spring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.spring.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	public Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean checkUser(User user) {
		// TODO Auto-generated method stub
		boolean check = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			String hql = "from User where username = :username and password = :password"; 
			Query query = session.createQuery(hql);
			query.setParameter("username", user.getUsername());
			query.setParameter("password", user.getPassword());
			List results = query.list();
			if(results.size() == 0) {
				check = false;
			} else {
				check = true;
			}

			transaction.commit();
		} catch (RuntimeException re) {
			try {
				transaction.rollback();
			} catch (RuntimeException e) {
				logger.error("Couldn't roll back transaction", e);
			}
			throw re;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return check;
	}

	@Override
	public void saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			session.saveOrUpdate(user);

			transaction.commit();
		} catch (RuntimeException re) {
			try {
				transaction.rollback();
			} catch (RuntimeException e) {
				logger.error("Couldn't roll back transaction", e);
			}
			throw re;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			User user = getUserById(userId);
			session.delete(user);

			transaction.commit();
		} catch (RuntimeException re) {
			try {
				transaction.rollback();
			} catch (RuntimeException e) {
				logger.error("Couldn't roll back transaction", e);
			}
			throw re;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListUser() {
		// TODO Auto-generated method stub
		List<User> users = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			users = session.createCriteria(User.class).list();
			
			transaction.commit();
		} catch (RuntimeException re) {
			try {
				transaction.rollback();
			} catch (RuntimeException e) {
				logger.error("Couldn't roll back transaction", e);
			}
			throw re;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return users;
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		User user = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			user = (User) session.get(User.class, userId);

			transaction.commit();
		} catch (RuntimeException re) {
			try {
				transaction.rollback();
			} catch (RuntimeException e) {
				logger.error("Couldn't roll back transaction", e);
			}
			throw re;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return user;
	}

}

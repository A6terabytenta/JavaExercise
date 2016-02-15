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

import com.exercise.spring.model.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
	public Logger logger = Logger.getLogger(StudentDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void saveOrUpdateStudent(Student student) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			session.saveOrUpdate(student);

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
	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			Student student = getStudentById(studentId);
			session.delete(student);

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
	public List<Student> getListStudent() {
		// TODO Auto-generated method stub
		List<Student> students = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			students = session.createCriteria(Student.class).list();

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
		return students;
	}

	@Override
	public Student getStudentById(int studentId) {
		// TODO Auto-generated method stub
		Student student = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			student = (Student) session.get(Student.class, studentId);

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
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> search(String element, String value) {
		// TODO Auto-generated method stub
		List<Student> students = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			String hql = "from Student where " + element + " like '%" + value
					+ "%'";
			Query query = session.createQuery(hql);
			students = query.list();
			System.out.println(students);
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
		return students;
	}

}

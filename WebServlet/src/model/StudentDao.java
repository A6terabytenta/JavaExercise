package model;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDao implements StudentInterface {
	public static Logger logger;
	public Session session;
	public Transaction transaction;

	public StudentDao() {
		super();
	}

	public Session getSession() {
		// Configurating hibernate
		Configuration configuration = new Configuration().configure();

		// Create SessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Create Session
		if (sessionFactory.getCurrentSession() != null) {
			session = sessionFactory.getCurrentSession();
		} else {
			session = sessionFactory.openSession();
		}
		return session;
	}

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		getSession();
		transaction = session.beginTransaction();
		try {
			transaction.begin();
			session.saveOrUpdate(student);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		getSession();
		transaction = session.beginTransaction();
		try {
			transaction.begin();
			session.delete(student);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		getSession();
		transaction = session.beginTransaction();
		Student student;
		try {
			transaction.begin();
			student = (Student) session.get(Student.class, id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getListStudent(int first, int maxValue) {
		// TODO Auto-generated method stub
		getSession();
		transaction = session.beginTransaction();
		List<Student> list = null;
		try {
			transaction.begin();
			String sql = "FROM Student";
			Query query = session.createQuery(sql);
			query.setFirstResult(first);
			query.setMaxResults(maxValue);
			list = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getListStudent() {
		// TODO Auto-generated method stub
		getSession();
		transaction = session.beginTransaction();
		List<Student> list = null;
		try {
			transaction.begin();
			String sql = "FROM Student";
			Query query = session.createQuery(sql);
			list = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> search(String name) {
		// TODO Auto-generated method stub
		getSession();
		transaction = session.beginTransaction();
		List<Student> list = null;
		try {
			transaction.begin();
			String sql = "FROM Student WHERE name LIKE :name";
			Query query = session.createQuery(sql);
			query.setParameter("name", "%" + name + "%");
			list = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}
}

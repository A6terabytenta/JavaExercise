package com.exercise.spring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.spring.model.StudentInfo;

@Repository
@Transactional
public class StudentInfoImpl implements StudentInfoDao {
	public Logger logger = Logger.getLogger(StudentInfoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void saveOrUpdateStudentInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			session.saveOrUpdate(studentInfo);

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
	public void deleteStudentInfo(int studentInfoId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			StudentInfo studentInfo = getStudentInfoById(studentInfoId);
			session.delete(studentInfo);

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
	public List<StudentInfo> getListStudentInfo() {
		// TODO Auto-generated method stub
		List<StudentInfo> studentInfos = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			studentInfos = session.createCriteria(StudentInfo.class).list();
			
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
		return studentInfos;
	}

	@Override
	public StudentInfo getStudentInfoById(int studentInfoId) {
		// TODO Auto-generated method stub
		StudentInfo studentInfo = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			studentInfo = (StudentInfo) session.get(StudentInfo.class, studentInfoId);

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
		return studentInfo;
	}

}

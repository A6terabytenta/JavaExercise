package com.exercise.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class StudentAspect {

	@Before("execution(* com.exercise.spring.dao.StudentDao.saveOrUpdateStudent(..))")
	public void logBeforeSaveOfUpdateStudent(JoinPoint joinPoint) {
		System.out.println("logBeforeSaveOfUpdateStudent() is running!");
		System.out.println("Method : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@After("execution(* com.exercise.spring.dao.StudentDao.saveOrUpdateStudent(..))")
	public void logAfterSaveOfUpdateStudent(JoinPoint joinPoint) {
		System.out.println("logAfterSaveOfUpdateStudent() is running!");
		System.out.println("Method : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@Before("execution(* com.exercise.spring.dao.StudentDao.deleteStudent(..))")
	public void logBeforeDeleteStudent(JoinPoint joinPoint) {
		System.out.println("logBeforeDeleteStudent() is running!");
		System.out.println("Method : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@After("execution(* com.exercise.spring.dao.StudentDao.deleteStudent(..))")
	public void logAfterDeleteStudent(JoinPoint joinPoint) {
		System.out.println("logBeforeDeleteStudent() is running!");
		System.out.println("Method : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@Before("execution(* com.exercise.spring.dao.StudentDao.getListStudent(..))")
	public void logBeforeGetListStudent(JoinPoint joinPoint) {
		System.out.println("logBeforeGetListStudent() is running!");
		System.out.println("Method : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@AfterReturning(pointcut = "execution(* com.exercise.spring.dao.StudentDao.getListStudent(..))", returning = "results")
	public void logAfterReturningGetListStudent(JoinPoint joinPoint,
			Object results) {
		System.out.println("logAfterReturningGetListStudent() is running!");
		System.out.println("Method : " + joinPoint.getSignature().getName());
		System.out.println("Return : " + results);
		System.out.println("******");
	}

	@Before("execution(* com.exercise.spring.dao.StudentDao.getStudentById(..))")
	public void logBeforeGetStudentById(JoinPoint joinPoint) {
		System.out.println("logBeforeGetStudentById() is running!");
		System.out.println("Method : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@AfterReturning(pointcut = "execution(* com.exercise.spring.dao.StudentDao.getStudentById(..))", returning = "results")
	public void logAfterReturningGetStudentById(JoinPoint joinPoint,
			Object results) {
		System.out.println("logBeforeGetStudentById() is running!");
		System.out.println("Method : " + joinPoint.getSignature().getName());
		System.out.println("Return : " + results);
		System.out.println("******");
	}

	@Before("execution(* com.exercise.spring.dao.StudentDao.search(..))")
	public void logBeforeSearch(JoinPoint joinPoint) {
		System.out.println("logBeforeSearch() is running!");
		System.out.println("Method : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@AfterReturning(pointcut = "execution(* com.exercise.spring.dao.StudentDao.search(..))", returning = "results")
	public void logAfterReturningSearch(JoinPoint joinPoint, Object results) {
		System.out.println("logAfterReturningSearch() is running!");
		System.out.println("Method : " + joinPoint.getSignature().getName());
		System.out.println("Return : " + results);
		System.out.println("******");
	}

}

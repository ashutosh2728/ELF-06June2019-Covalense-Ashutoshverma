package com.covalense.hibernateapp.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.covalense.hibernateapp.manytoone.EmployeeInfoBean;

public class HibernateImpl {

	private Configuration configuration = new Configuration();
	private SessionFactory factory = configuration.configure().buildSessionFactory();

	public void createTraining(TrainingInfoBean trainingInfoBean) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(trainingInfoBean);
		transaction.commit();
		session.close();
	}

	public EmployeeInfoBean getEmployeeInfoBean(int id) {
		Session session = factory.openSession();
		EmployeeInfoBean bean = session.get(EmployeeInfoBean.class, id);
		session.close();
		return bean;
	}
}

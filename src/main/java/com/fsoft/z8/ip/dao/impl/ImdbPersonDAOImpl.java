package com.fsoft.z8.ip.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fsoft.z8.ip.common.ImdbHibernateUtil;
import com.fsoft.z8.ip.dao.ImdbPersonDAO;
import com.fsoft.z8.ip.entity.ImdbPerson;

public final class ImdbPersonDAOImpl implements ImdbPersonDAO {

    private Session currentSession;
    
    @Override
    public void saveOrUpdate(ImdbPerson person) {
	if (person == null) {
	    System.out.println("Input person is null");
	    return; // TODO logging and message
	}
	try {
	    currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = currentSession.beginTransaction();
	    currentSession.saveOrUpdate(person);
	    transaction.commit();
	} catch (HibernateException hex) {
	    System.out.println(hex.getMessage()); // TODO logging
	} finally {
	    if (currentSession != null) {
		currentSession.close();
	    }
	}
    }

    @Override
    public List<ImdbPerson> getAll() {
	try {
	    currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
	    return currentSession.createQuery("from com.fsoft.z8.ip.entity.ImdbPerson").list();
	} catch (HibernateException hex) {
	    System.out.println(hex.getMessage()); // TODO logging
	} finally {
	    if (currentSession != null) {
		currentSession.close();
	    }
	}
	return new ArrayList<ImdbPerson>();
    }

    @Override
    public void delete(ImdbPerson person) {
	if (person == null) {
	    return; // TODO logging & message
	}
	try {
	    currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = currentSession.beginTransaction();
	    currentSession.delete(person);
	    transaction.commit();
	} catch (HibernateException hex) {
	    System.out.println(hex.getMessage()); // TODO logging
	} finally {
	    if (currentSession != null) {
		currentSession.close();
	    }
	}
    }

}

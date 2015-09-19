package com.fsoft.z8.ip.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fsoft.z8.ip.common.ImdbHibernateUtil;
import com.fsoft.z8.ip.dao.ImdbVideoDAO;
import com.fsoft.z8.ip.entity.ImdbVideo;

public final class ImdbVideoDAOImpl implements ImdbVideoDAO {

    private Session currentSession;
    
    @Override
    public void saveOrUpdate(ImdbVideo video) {
	// TODO logging & message
	if (video == null) {
	    return;
	}
	try {
	    currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = currentSession.beginTransaction();
	    currentSession.saveOrUpdate(video);
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
    public List<ImdbVideo> getAll() {
	try {
	    currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
	    return currentSession.createQuery("from com.fsoft.z8.ip.entity.ImdbVideo").list();
	} catch (HibernateException hex) {
	    System.out.println(hex.getMessage()); // TODO logging
	} finally {
	    if (currentSession != null) {
		currentSession.close();
	    }
	}
	return new ArrayList<ImdbVideo>();
    }

    @Override
    public void delete(ImdbVideo video) {
	if (video == null) {
	    return; // TODO: logging
	}
	try {
	    currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = currentSession.beginTransaction();
	    currentSession.delete(video);
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

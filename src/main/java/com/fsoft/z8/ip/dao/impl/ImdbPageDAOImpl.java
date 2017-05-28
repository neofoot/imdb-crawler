package com.fsoft.z8.ip.dao.impl;

import com.fsoft.z8.ip.common.ImdbHibernateUtil;
import com.fsoft.z8.ip.dao.ImdbPageDAO;
import com.fsoft.z8.ip.entity.ImdbPage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public final class ImdbPageDAOImpl implements ImdbPageDAO {

    private Session currentSession;

    @Override
    public void saveOrUpdate(ImdbPage page) {
        try {
            currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
            Transaction transaction = currentSession.beginTransaction();
            currentSession.saveOrUpdate(page);
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
    public List<ImdbPage> getAll() {
        try {
            currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
            return currentSession.createQuery("from com.fsoft.z8.ip.entity.ImdbPage").list();
        } catch (HibernateException hex) {
            System.out.println(hex.getMessage()); // TODO logging
        } finally {
            if (currentSession != null) {
                currentSession.close();
            }
        }
        return new ArrayList<ImdbPage>();
    }

    @Override
    public void delete(ImdbPage page) {
        try {
            currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
            Transaction transaction = currentSession.beginTransaction();
            currentSession.delete(page);
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
    public ImdbPage getPageById(int id) {
        try {
            currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
            Transaction transaction = currentSession.beginTransaction();
        } catch (HibernateException hex) {
            System.out.println(hex.getMessage()); // TODO logging
        } finally {
            if (currentSession != null) {
                currentSession.close();
            }
        }
        return null;
    }

}

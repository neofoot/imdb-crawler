package com.fsoft.z8.ip.dao.impl;

import com.fsoft.z8.ip.common.ImdbHibernateUtil;
import com.fsoft.z8.ip.dao.ImdbContentRatingDAO;
import com.fsoft.z8.ip.entity.ImdbContentRating;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public final class ImdbContentRatingDAOImpl implements ImdbContentRatingDAO {

    private static ImdbContentRatingDAOImpl INSTANCE = new ImdbContentRatingDAOImpl();

    private ImdbContentRatingDAOImpl() {
    }

    public static ImdbContentRatingDAOImpl getInstance() {
        return ImdbContentRatingDAOImpl.INSTANCE;
    }

    private Session currentSession;

    @Override
    public void saveOrUpdate(ImdbContentRating object) {
        try {
            currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
            Transaction transaction = currentSession.beginTransaction();
            currentSession.saveOrUpdate(object);
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
    public List<ImdbContentRating> getAll() {
        try {
            currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
            return currentSession.createQuery("from com.fsoft.z8.ip.entity.ImdbContentRating").list();
        } catch (HibernateException hex) {
            System.out.println(hex.getMessage()); // TODO logging
        } finally {
            if (currentSession != null) {
                currentSession.close();
            }
        }
        return new ArrayList<ImdbContentRating>();
    }

    @Override
    public void delete(ImdbContentRating object) {
        try {
            currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
            Transaction transaction = currentSession.beginTransaction();
            currentSession.delete(object);
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

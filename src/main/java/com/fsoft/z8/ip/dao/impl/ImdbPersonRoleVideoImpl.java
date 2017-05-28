package com.fsoft.z8.ip.dao.impl;

import com.fsoft.z8.ip.common.ImdbHibernateUtil;
import com.fsoft.z8.ip.dao.ImdbPersonRoleVideoDAO;
import com.fsoft.z8.ip.entity.ImdbPersonRoleVideo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public final class ImdbPersonRoleVideoImpl implements ImdbPersonRoleVideoDAO {

    private Session currentSession;

    @Override
    public void saveOrUpdate(ImdbPersonRoleVideo object) {

        // TODO logging & message
        if (object == null) {
            return;
        }

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
    public List<ImdbPersonRoleVideo> getAll() {
        try {
            currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
            return currentSession.createQuery("from com.fsoft.z8.ip.entity.ImdbPersonRoleVideo").list();
        } catch (HibernateException hex) {
            System.out.println(hex.getMessage()); // TODO logging
        } finally {
            if (currentSession != null) {
                currentSession.close();
            }
        }
        return new ArrayList<ImdbPersonRoleVideo>();
    }

    @Override
    public void delete(ImdbPersonRoleVideo object) {

        if (object == null) {
            return; // TODO logging & message
        }

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

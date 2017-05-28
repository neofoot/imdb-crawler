package com.fsoft.z8.ip.dao.impl;

import com.fsoft.z8.ip.common.ImdbHibernateUtil;
import com.fsoft.z8.ip.dao.ImdbRoleDAO;
import com.fsoft.z8.ip.entity.ImdbRole;
import com.fsoft.z8.ip.entity.RoleEnum;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public final class ImdbRoleDAOImpl implements ImdbRoleDAO {

    private Session currentSession;

    @Override
    public void saveOrUpdate(ImdbRole role) {

        if (role == null || role.getName() == null || role.getName().isEmpty()) {
            // TODO: logging & show message
            return;
        }

        RoleEnum roleType = RoleEnum.parse(role.getName());
        if (RoleEnum.UNKNOWN == roleType) {
            // TODO: logging & show message
            return;
        }

        try {
            currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
            Transaction transaction = currentSession.beginTransaction();
            currentSession.saveOrUpdate(role);
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
    public List<ImdbRole> getAll() {
        try {
            currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
            return currentSession.createQuery("from com.fsoft.z8.ip.entity.ImdbRole").list();
        } catch (HibernateException hex) {
            System.out.println(hex.getMessage()); // TODO logging
        } finally {
            if (currentSession != null) {
                currentSession.close();
            }
        }
        return new ArrayList<ImdbRole>();
    }

    @Override
    public void delete(ImdbRole role) {
        try {
            currentSession = ImdbHibernateUtil.getSessionFactory().openSession();
            Transaction transaction = currentSession.beginTransaction();
            currentSession.delete(role);
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

package com.fsoft.z8.ip;

import com.fsoft.z8.ip.common.ImdbInitializer;
import com.fsoft.z8.ip.dao.*;
import com.fsoft.z8.ip.dao.impl.*;
import org.junit.Before;
import org.junit.Test;

public abstract class TestUnit {

    private ImdbPageDAO pageDAO;
    private ImdbPersonDAO personDAO;
    private ImdbVideoDAO videoDAO;
    private ImdbRoleDAO roleDAO;
    private ImdbPersonRoleVideoDAO personRoleVideoDAO;

    @Before
    public void setUp() {
        this.pageDAO = new ImdbPageDAOImpl();
        this.personDAO = new ImdbPersonDAOImpl();
        this.videoDAO = new ImdbVideoDAOImpl();
        this.roleDAO = new ImdbRoleDAOImpl();
        this.personRoleVideoDAO = new ImdbPersonRoleVideoImpl();

        ImdbInitializer.getInstance().init();
    }

    @Test
    public abstract void test();

    /**
     * @return the pageDAO
     */
    public ImdbPageDAO getPageDAO() {
        return pageDAO;
    }

    /**
     * @return the personDAO
     */
    public ImdbPersonDAO getPersonDAO() {
        return personDAO;
    }

    /**
     * @return the videoDAO
     */
    public ImdbVideoDAO getVideoDAO() {
        return videoDAO;
    }

    /**
     * @return the roleDAO
     */
    public ImdbRoleDAO getRoleDAO() {
        return roleDAO;
    }

    /**
     * @return the personRoleVideoDAO
     */
    public ImdbPersonRoleVideoDAO getPersonRoleVideoDAO() {
        return personRoleVideoDAO;
    }
}

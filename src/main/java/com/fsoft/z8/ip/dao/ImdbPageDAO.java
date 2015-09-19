package com.fsoft.z8.ip.dao;

import com.fsoft.z8.ip.entity.ImdbPage;

public interface ImdbPageDAO extends ImdbGenericDAO<ImdbPage> {
    public ImdbPage getPageById(int id);
}

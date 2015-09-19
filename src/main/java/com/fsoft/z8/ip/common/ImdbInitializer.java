package com.fsoft.z8.ip.common;

import com.fsoft.z8.ip.dao.ImdbRoleDAO;
import com.fsoft.z8.ip.dao.impl.ImdbContentRatingDAOImpl;
import com.fsoft.z8.ip.dao.impl.ImdbRoleDAOImpl;
import com.fsoft.z8.ip.entity.ContentRatingEnum;
import com.fsoft.z8.ip.entity.ImdbContentRating;
import com.fsoft.z8.ip.entity.ImdbRole;
import com.fsoft.z8.ip.entity.RoleEnum;

/**
 * This class is to initialize all DAO objects.
 * 
 * @author hieunt
 *
 */
public final class ImdbInitializer {
    
    private static ImdbInitializer INSTANCE = new ImdbInitializer();

    private ImdbInitializer() {
    }
    
    public static ImdbInitializer getInstance() {
	return ImdbInitializer.INSTANCE;
    }
    
    public void init() {
	// Insert predefined roles 
	ImdbRoleDAO roleDAO = new ImdbRoleDAOImpl();
	roleDAO.saveOrUpdate(new ImdbRole(RoleEnum.ACTOR.getValue()));
	roleDAO.saveOrUpdate(new ImdbRole(RoleEnum.ACTRESS.getValue()));
	roleDAO.saveOrUpdate(new ImdbRole(RoleEnum.DIRECTOR.getValue()));
	roleDAO.saveOrUpdate(new ImdbRole(RoleEnum.PRODUCER.getValue()));
	roleDAO.saveOrUpdate(new ImdbRole(RoleEnum.WRITER.getValue()));
	
	// Insert predefined content rating
	ImdbContentRatingDAOImpl.getInstance().saveOrUpdate(new ImdbContentRating(ContentRatingEnum.G.getCode(), ContentRatingEnum.G.getName()));
	ImdbContentRatingDAOImpl.getInstance().saveOrUpdate(new ImdbContentRating(ContentRatingEnum.NC_17.getCode(), ContentRatingEnum.NC_17.getName()));
	ImdbContentRatingDAOImpl.getInstance().saveOrUpdate(new ImdbContentRating(ContentRatingEnum.PG.getCode(), ContentRatingEnum.PG.getName()));
	ImdbContentRatingDAOImpl.getInstance().saveOrUpdate(new ImdbContentRating(ContentRatingEnum.R.getCode(), ContentRatingEnum.R.getName()));
	ImdbContentRatingDAOImpl.getInstance().saveOrUpdate(new ImdbContentRating(ContentRatingEnum.PG_13.getCode(), ContentRatingEnum.PG_13.getName()));
    }
}

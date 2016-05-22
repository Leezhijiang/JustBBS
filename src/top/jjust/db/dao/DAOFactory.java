package top.jjust.db.dao;

import top.jjust.db.daoimp.CommitPostDAOIMP;
import top.jjust.db.daoimp.PostDAOIMP;
import top.jjust.db.daoimp.TitlePostDAOIMP;
import top.jjust.db.daoimp.UserDAOIMP;

public class DAOFactory {
	public static BasePostDAO getCommitPostDAO(){
		return new CommitPostDAOIMP();
	}
	public static BasePostDAO getPostDAO(){
		return new PostDAOIMP();
	}	
	public static BasePostDAO getTitlePostDAO(){
		return new TitlePostDAOIMP();
	}
	public static UserDAO getUserDAO(){
		return new UserDAOIMP();
	}
}

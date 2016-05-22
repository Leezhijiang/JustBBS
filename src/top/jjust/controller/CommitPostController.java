package top.jjust.controller;

import top.jjust.bean.post.CommitPostBean;
import top.jjust.db.dao.DAOFactory;
import top.jjust.db.daoimp.CommitPostDAOIMP;

public class CommitPostController{
	/**
	 * 不对外开放使用的删除方法
	 * @param parentPostID
	 * @return
	 */
	public static boolean deletePostByParentPostID(long parentPostID){
		return ((CommitPostDAOIMP)DAOFactory.getCommitPostDAO()).deletePostByParentPostID(parentPostID);
	}
	public static boolean deletePostByPostID(long postID) {
		// TODO Auto-generated method stub
		return DAOFactory.getCommitPostDAO().deletePostByPostID(postID);
	}

	public static boolean modifyContentByPostID(long postID,String content) {
		// TODO Auto-generated method stub
		return DAOFactory.getCommitPostDAO().updateContent(postID, content);
	}

	public static boolean publish(CommitPostBean post) {
		// TODO Auto-generated method stub
		return create(post);
	}

	private static boolean create(CommitPostBean post) {
		// TODO Auto-generated method stub
		return DAOFactory.getCommitPostDAO().create(post);
	}
	
}

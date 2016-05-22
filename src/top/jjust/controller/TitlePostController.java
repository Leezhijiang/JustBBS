package top.jjust.controller;

import java.util.ArrayList;
import java.util.List;

import top.jjust.bean.post.BasePostBean;
import top.jjust.bean.post.PostBean;
import top.jjust.bean.post.TitlePostBean;
import top.jjust.common.StaticValue;
import top.jjust.db.dao.DAOFactory;
import top.jjust.db.daoimp.TitlePostDAOIMP;

public class TitlePostController {
//	/**
//	 * 添加一个子贴id
//	 * @param postID
//	 * @param childPostID
//	 * @return
//	 */
//	public static boolean addChild(long postID,long childPostID){
//		TitlePostDAOIMP titlePostDAO = (TitlePostDAOIMP) DAOFactory.getTitlePostDAO();
//		TitlePostBean post = (TitlePostBean) titlePostDAO.queryByWhat("postID", ""+postID).get(0);
//		post.setChildPostID(childPostID+"");
//		return titlePostDAO.updateChildPost(post.getPostID(),post.getAllChildPostID());
//	}
//	public static boolean deleteChildByChildPostID(long postID,long childPostID){
//		TitlePostDAOIMP titlePostDAO = (TitlePostDAOIMP) DAOFactory.getTitlePostDAO();
//		//去除String中的childpostid
//		TitlePostBean post = (TitlePostBean) titlePostDAO.queryByWhat("postID", ""+postID).get(0);
//		String childPostIDs = post.getAllChildPostID();
//		//所删除的数字在开头
//		if(childPostIDs.startsWith(String.valueOf(childPostID))){
//			if(childPostIDs.split(StaticValue.SPLIT_FOR_CHILDPOST).length==1){
//				return titlePostDAO.updateChildPost(postID, childPostIDs.replace(String.valueOf(childPostID), ""));
//			}else {
//				return titlePostDAO.updateChildPost(postID, childPostIDs.replace(String.valueOf(childPostID)+",", ""));
//			}
//
//		}else {
//			return titlePostDAO.updateChildPost(postID,childPostIDs.replace(","+String.valueOf(childPostID), ""));
//		}
//	}
	/**
	 * 得到目标主题的所有子贴(效率更高)
	 * @param postID
	 * @return
	 */
	public static List<PostBean> getAllChild(long postID,String orderByWhat,boolean isDesc){
		return PostController.getPostByParentPostIDAndOrder(postID, orderByWhat, isDesc);
	}
	/**
	 * 新建一个主题贴
	 * @param post
	 * @return
	 */
	public static boolean create(BasePostBean post) {
		return DAOFactory.getTitlePostDAO().create(post);
	}
	/**
	 * 删除本数据以及子类数据
	 * @param postID
	 * @return
	 */
	public static boolean deletePostByPostID(long postID) {
		//出了删除本数据库之外还需要删除子数据库
		TitlePostDAOIMP titlePostDAO = (TitlePostDAOIMP)DAOFactory.getTitlePostDAO();
		//删除子贴
//		TitlePostBean post = (TitlePostBean)titlePostDAO.queryByWhat("postID",""+postID).get(0);
//		String[] childPostIDs = post.getAllChildPostID().split(StaticValue.SPLIT_FOR_CHILDPOST);
//		for(String childPostID:childPostIDs){
//			if(!PostController.deletePostAndChild(Integer.parseInt(childPostID))){//如果子贴删除出错，本帖也出错
//				return false;
//			}
//		}
		List<PostBean> posts = PostController.getPostByParentPostIDAndOrder(postID, "postID", true);
		for(PostBean post : posts){
			PostController.deletePostAndChild(post.getPostID());
		}
		//删除本帖
		titlePostDAO.deletePostByPostID(postID);
		return true;
	}

	public static boolean modifyByPostID(long postID,String content) {
		return DAOFactory.getTitlePostDAO().updateContent(postID, content);

	}
	public static List<?extends BasePostBean>  getPostByTitle(String title){
		return DAOFactory.getTitlePostDAO().queryByWhat("title", title);
	}

	public static List<?extends BasePostBean>  getAllPost(){
		return DAOFactory.getTitlePostDAO().queryAll();
	}
}

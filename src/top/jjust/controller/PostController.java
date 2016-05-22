package top.jjust.controller;

import java.util.List;

import top.jjust.bean.post.BasePostBean;
import top.jjust.bean.post.PostBean;
import top.jjust.bean.post.TitlePostBean;
import top.jjust.common.StaticValue;
import top.jjust.db.dao.DAOFactory;
import top.jjust.db.daoimp.PostDAOIMP;
import top.jjust.db.daoimp.TitlePostDAOIMP;

public class PostController{
//	/**
//	 * 新添加一个子贴
//	 * @param postID
//	 * @param childPostID
//	 * @return
//	 */
//	public static boolean addChild(long postID,long childPostID){
//		PostDAOIMP postDAO = (PostDAOIMP) DAOFactory.getPostDAO();
//		PostBean post = (PostBean) postDAO.queryByWhat("postID", ""+postID).get(0);
//		post.setChildPostID(childPostID+"");
//		return postDAO.updateChildPost(post.getPostID(),post.getChildPostID());
//	}
//	/**
//	 * 删除一个子贴
//	 * @param postID
//	 * @param childPostID
//	 * @return
//	 */
//	public static boolean deleteChildByChildPostID(long postID,long childPostID){
//		PostDAOIMP postDAO = (PostDAOIMP) DAOFactory.getPostDAO();
//		//去除String中的childpostid
//		PostBean post = (PostBean) postDAO.queryByWhat("postID", ""+postID).get(0);
//		String childPostIDs = post.getChildPostID();
//		//所删除的数字在开头
//		if(childPostIDs.startsWith(String.valueOf(childPostID))){
//			if(childPostIDs.split(StaticValue.SPLIT_FOR_CHILDPOST).length==1){
//				return postDAO.updateChildPost(postID, childPostIDs.replace(String.valueOf(childPostID), ""));
//			}else {
//				return postDAO.updateChildPost(postID, childPostIDs.replace(String.valueOf(childPostID)+",", ""));
//			}
//			
//		}else {
//			return postDAO.updateChildPost(postID,childPostIDs.replace(","+String.valueOf(childPostID), ""));
//		}
////	}
//	public void getChild(){
//		//等完成commit类之后续写
//	}
	/**
	 * 根据bean新建一个数据
	 * @param post
	 * @return
	 */
	private static boolean create(BasePostBean post) {
		// TODO Auto-generated method stub
		return DAOFactory.getPostDAO().create(post);
	}
	
//	/**
//	 * 仅仅删除这条数据库的数据
//	 * @param PostID
//	 * @return
//	 */
//	public static boolean deleteByPostID(int PostID) {
//		// TODO Auto-generated method stub
//		return 
//	}
	/**
	 * 删除本数据库所有数据，并且向下删除
	 * @param PostID
	 * @return
	 */
	public static boolean deletePostAndChild(long PostID) {
		// TODO Auto-generated method stub
		PostDAOIMP postDAO = (PostDAOIMP) DAOFactory.getPostDAO();
		//删除子类数据
		
		//删除数据
		return CommitPostController.deletePostByParentPostID(PostID)&&postDAO.deletePostByPostID(PostID);
		 
	}
	/**
	 * 根据id得到数据中的bean
	 * @param postID
	 * @return
	 */
	public static PostBean getPostByPostID(long postID){
		return (PostBean) DAOFactory.getPostDAO().queryByWhat("postID", ""+postID).get(0);
	}
	/**
	 * 根据父帖子的id查找出本数据中所有帖子
	 * @param parentPostID 父帖子id
	 * @param order 按照什么排序
	 * @param desc 生序or降序
	 * @return
	 */
	public static List<PostBean> getPostByParentPostIDAndOrder(long parentPostID,String order,boolean desc){
		return (List<PostBean>) DAOFactory.getPostDAO().queryByWhatAndOrder("parentPostID", ""+parentPostID, order, desc);
	}
	/**
	 * 修改post中的内容
	 * @param postID
	 * @param content
	 * @return
	 */
	public static boolean modifyByPostID(long postID,String content) {
		return DAOFactory.getPostDAO().updateContent(postID, content);

	}
	/**
	 * 先使用create方法新建数据，然后添加索引到父帖子
	 */
	public static boolean publish(PostBean post) {
		// TODO Auto-generated method stub
		//利用create方法写入数据库，查找父类的childpost插入数据
		
		return create(post);

	}
	public static List<?extends BasePostBean>  getAllPost(){
		return DAOFactory.getPostDAO().queryAll();
	}
}

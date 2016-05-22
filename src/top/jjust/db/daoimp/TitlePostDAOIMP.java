package top.jjust.db.daoimp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import top.jjust.bean.post.BasePostBean;
import top.jjust.bean.post.PostBean;
import top.jjust.bean.post.TitlePostBean;
import top.jjust.bean.user.BaseUserBean;
import top.jjust.db.BasePostDBConn;
import top.jjust.db.dao.BasePostDAO;

public class TitlePostDAOIMP implements BasePostDAO {

	@Override
	public boolean create(BasePostBean basepost){
		// TODO Auto-generated method stub
		//		private long postID;//帖子标示附-自动设置
		//		private BaseUserBean user;//所属用户(数据库中为userName)
		//		private long time;//发表时间
		//		private String content;//发表内容
		//		private String title;//标题
		//		private int agree;//赞同票数
		//		private int disagree;//反对票数
		//		private ArrayList<BasePostBean>  childPost;//子贴(数据库中使用String表示，存储子类的id，用“，”分割)
		//		private int size;//子贴数量
		TitlePostBean post = (TitlePostBean)basepost;
		String sql = "INSERT INTO titlepost(userName,time,content,title,agree,disagree,size) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null ;   
		BasePostDBConn dbc = null ;   
		// 下面是针对数据库的具体操作   
		try{
			// 连接数据库   
			dbc = new BasePostDBConn() ;   
			pstmt = dbc.getConnection().prepareStatement(sql) ;  
			pstmt.setString(1, post.getUserName());
			pstmt.setLong(2,post.getTime());
			pstmt.setString(3,post.getContent());
			pstmt.setString(4, post.getTitle());
			pstmt.setInt(5,post.getAgree());
			pstmt.setInt(6,post.getDisagree());
			//pstmt.setString(7,post.getAllChildPostID());
			pstmt.setInt(7,post.getSize());
			// 进行数据库更新操作   
			if(1==pstmt.executeUpdate()){
				return true;
			}   
			pstmt.close() ;   
		}catch (Exception e){   
			e.printStackTrace();
			return false;
		}   
		finally{   
			// 关闭数据库连接   
			dbc.close() ;   
		}   
		return true;
	}

	@Override
	public boolean updateContent(long postID,String content){
		// TODO Auto-generated method stub
		String sql="update titlepost set content=? where postID=?";
		PreparedStatement pstmt = null ;   
		BasePostDBConn dbc = null ;   
		// 下面是针对数据库的具体操作   
		try{
			// 连接数据库   
			dbc = new BasePostDBConn() ;   
			pstmt = dbc.getConnection().prepareStatement(sql) ;  
			pstmt.setString(1, content);
			pstmt.setLong(2,postID);
			// 进行数据库更新操作   
			if(1==pstmt.executeUpdate()){
				return true;
			}   
			pstmt.close() ;   
		}catch (Exception e){   
			e.printStackTrace();
			return false;
		}   
		finally{   
			// 关闭数据库连接   
			dbc.close() ;   
		}   
		return true;
	}

	@Override
	public boolean deletePostByPostID(long postID){
		// TODO Auto-generated method stub
		String sql="delete from titlepost where postID=?";
		PreparedStatement pstmt = null ;   
		BasePostDBConn dbc = null ;   
		// 下面是针对数据库的具体操作   
		try{
			// 连接数据库   
			dbc = new BasePostDBConn() ;   
			pstmt = dbc.getConnection().prepareStatement(sql) ;  
			pstmt.setLong(1, postID);   
			// 进行数据库更新操作   
			if(0==pstmt.executeUpdate()){
				return false;
			}   
			pstmt.close() ;  

		}catch (Exception e){   
			e.printStackTrace(); 
			return false;
		}   
		finally{   
			// 关闭数据库连接   
			dbc.close() ;   

		}   
		return true;
	}

	@Override
	public List<? extends BasePostBean> queryByPage(int page,int size,String order,boolean desc){
		// TODO Auto-generated method stub
		ArrayList<TitlePostBean> postList = new ArrayList<TitlePostBean>();
		String sql = "";
		if(desc)
			sql = "select * from titlepost order by "+order+" desc limit "+(page-1)*size+","+size;
		else
			sql="select * from titlepost order by "+order+" asc limit "+(page-1)*size+","+size;
		System.out.println(sql);
		//String sql = "INSERT INTO titlepost(userName,time,content,title,agree,disagree,childPost,size) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null ;   
		BasePostDBConn dbc = null ;   
		// 下面是针对数据库的具体操作   
		try{
			// 连接数据库   
			dbc = new BasePostDBConn() ;   
			pstmt = dbc.getConnection().prepareStatement(sql) ;  
			// 进行数据库更新操作   
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				TitlePostBean bean = new TitlePostBean();
				bean.setUserName(rs.getString("userName"));
				bean.setPostID(rs.getInt("postID"));
				bean.setTime(rs.getLong("time"));
				bean.setContent(rs.getString("content"));
				bean.setTitle(rs.getString("title"));
				bean.setAgree(rs.getInt("agree"));
				bean.setDisagree(rs.getInt("disagree"));
				//bean.setChildPostID(rs.getString("childPost"));
				bean.setSize(rs.getInt("size"));
				postList.add(bean);
			}
			pstmt.close() ;   
		}catch (Exception e){   
			e.printStackTrace();
			return null;
		}   
		finally{   
			// 关闭数据库连接   
			dbc.close() ;   
		}   
		if(postList.size()==0){
			return null;
		}
		return postList;
	}

	@Override
	public List<? extends BasePostBean> queryAll(){
		// TODO Auto-generated method stub
		ArrayList<TitlePostBean> postList = new ArrayList<TitlePostBean>();
		String sql = "select * from titlepost";
		//String sql = "INSERT INTO titlepost(userName,time,content,title,agree,disagree,childPost,size) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null ;   
		BasePostDBConn dbc = null ;   
		// 下面是针对数据库的具体操作   
		try{
			// 连接数据库   
			dbc = new BasePostDBConn() ;   
			pstmt = dbc.getConnection().prepareStatement(sql) ;  
			// 进行数据库更新操作   
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				TitlePostBean bean = new TitlePostBean();
				bean.setUserName(rs.getString("userName"));
				bean.setPostID(rs.getInt("postID"));
				bean.setTime(rs.getLong("time"));
				bean.setContent(rs.getString("content"));
				bean.setTitle(rs.getString("title"));
				bean.setAgree(rs.getInt("agree"));
				bean.setDisagree(rs.getInt("disagree"));
				//bean.setChildPostID(rs.getString("childPost"));
				bean.setSize(rs.getInt("size"));
				postList.add(bean);
			}
			pstmt.close() ;   
		}catch (Exception e){   
			e.printStackTrace();
			return null;
		}   
		finally{   
			// 关闭数据库连接   
			dbc.close() ;   
		}   
		if(postList.size()==0){
			return null;
		}
		return postList;
	}

	@Override
	public List<? extends BasePostBean> queryByWhat(String what,String value){
		// TODO Auto-generated method stub
		ArrayList<TitlePostBean> postList = new ArrayList<TitlePostBean>();
		String sql = "select * from titlepost where "+what+" =?";
		//String sql = "INSERT INTO titlepost(userName,time,content,title,agree,disagree,childPost,size) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null ;   
		BasePostDBConn dbc = null ;   
		// 下面是针对数据库的具体操作   
		try{
			// 连接数据库   
			dbc = new BasePostDBConn() ;   
			pstmt = dbc.getConnection().prepareStatement(sql) ;  
			pstmt.setString(1, value);
			// 进行数据库更新操作   
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				TitlePostBean bean = new TitlePostBean();
				bean.setUserName(rs.getString("userName"));
				bean.setPostID(rs.getInt("postID"));
				bean.setTime(rs.getLong("time"));
				bean.setContent(rs.getString("content"));
				bean.setTitle(rs.getString("title"));
				bean.setAgree(rs.getInt("agree"));
				bean.setDisagree(rs.getInt("disagree"));
				//bean.setChildPostID(rs.getString("childPost"));
				bean.setSize(rs.getInt("size"));
				postList.add(bean);
			}
			pstmt.close() ;   
		}catch (Exception e){   
			e.printStackTrace();
			return null;
		}   
		finally{   
			// 关闭数据库连接   
			dbc.close() ;   
		}   
		if(postList.size()==0){
			return null;
		}
		return postList;
	}

	@Override
	public boolean updateChildPost(long postID, String childPost) {
		// TODO Auto-generated method stub
		String sql="update titlepost set childPost=? where postID=?";
		PreparedStatement pstmt = null ;   
		BasePostDBConn dbc = null ;   
		// 下面是针对数据库的具体操作   
		try{
			// 连接数据库   
			dbc = new BasePostDBConn() ;   
			pstmt = dbc.getConnection().prepareStatement(sql) ;  
			pstmt.setString(1, childPost);
			pstmt.setLong(2,postID);
			// 进行数据库更新操作   
			if(1==pstmt.executeUpdate()){
				return true;
			}   
			pstmt.close() ;   
		}catch (Exception e){   
			e.printStackTrace();
			return false;
		}   
		finally{   
			// 关闭数据库连接   
			dbc.close() ;   
		}   
		return true;
	}

	@Override
	public List<? extends BasePostBean> queryByWhatAndOrder(String what, String value, String order, boolean desc) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<TitlePostBean> postList = new ArrayList<TitlePostBean>();
		//String sql = "select * from post where "+what+" =?";
		String sql = "";
		if(desc)
			sql = "select * from titlepost where "+what+" =? order by "+order+" desc";
		else
			sql = "select * from titlepost where "+what+" =? order by "+order+" asc";
		//String sql = "INSERT INTO titlepost(userName,time,content,title,agree,disagree,childPost,size) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null ;   
		BasePostDBConn dbc = null ;   
		// 下面是针对数据库的具体操作   
		try{
			// 连接数据库   
			dbc = new BasePostDBConn() ;   
			pstmt = dbc.getConnection().prepareStatement(sql) ;  
			pstmt.setString(1, value);
			// 进行数据库更新操作   
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				TitlePostBean bean = new TitlePostBean();
				bean.setUserName(rs.getString("userName"));
				bean.setPostID(rs.getInt("postID"));
				bean.setTime(rs.getLong("time"));
				bean.setContent(rs.getString("content"));
				bean.setTitle(rs.getString("title"));
				bean.setAgree(rs.getInt("agree"));
				bean.setDisagree(rs.getInt("disagree"));
				//bean.setChildPostID(rs.getString("childPost"));
				bean.setSize(rs.getInt("size"));
				postList.add(bean);
			}
			pstmt.close() ;   
		}catch (Exception e){   
			e.printStackTrace();
			return null;
		}   
		finally{   
			// 关闭数据库连接   
			dbc.close() ;   
		}   
		if(postList.size()==0){
			return null;
		}
		return postList;
	}

}



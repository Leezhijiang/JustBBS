package top.jjust.db.daoimp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import top.jjust.bean.post.BasePostBean;
import top.jjust.bean.post.PostBean;
import top.jjust.db.BasePostDBConn;
import top.jjust.db.dao.BasePostDAO;

public class PostDAOIMP implements BasePostDAO {

	@Override
	public boolean create(BasePostBean mpost) {
		// TODO Auto-generated method stub
		PostBean post = (PostBean)mpost;
		String sql = "INSERT INTO post(userName,parentPostID,time,content) VALUES(?,?,?,?)";
		PreparedStatement pstmt = null ;   
		BasePostDBConn dbc = null ;   
		// 下面是针对数据库的具体操作   
		try{
			// 连接数据库   
			dbc = new BasePostDBConn() ;   
			pstmt = dbc.getConnection().prepareStatement(sql) ;  
			pstmt.setString(1, post.getUserName());
			pstmt.setLong(2,post.getParentPostID());
			pstmt.setLong(3,post.getTime());
			pstmt.setString(4,post.getContent());
			//pstmt.setString(5, post.getChildPostID());
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
	public boolean updateContent(long postID, String content) {
		// TODO Auto-generated method stub
		String sql="update post set content=? where postID=?";
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
	public boolean updateChildPost(long postID, String childPost) {
		// TODO Auto-generated method stub
		String sql="update post set childPost=? where postID=?";
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
	public boolean deletePostByPostID(long postID) {
		// TODO Auto-generated method stub
		String sql="delete from post where postID=?";
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
	public boolean deletePostByParentPostID(long parentPostID) {
		// TODO Auto-generated method stub
		String sql="delete from post where parentPostID=?";
		 PreparedStatement pstmt = null ;   
	      BasePostDBConn dbc = null ;   
	      // 下面是针对数据库的具体操作   
	      try{
	          // 连接数据库   
	          dbc = new BasePostDBConn() ;   
	          pstmt = dbc.getConnection().prepareStatement(sql) ;  
	          pstmt.setLong(1, parentPostID);   
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
	public List<? extends BasePostBean> queryByPage(int page, int size, String order, boolean desc) {
		// TODO Auto-generated method stub
		ArrayList<PostBean> postList = new ArrayList<PostBean>();
		String sql = "";
		if(desc)
			sql = "select * from post order by "+order+" desc limit "+(page-1)*size+","+size;
		else
			sql="select * from post order by "+order+" asc limit "+(page-1)*size+","+size;
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
				PostBean bean = new PostBean();
				bean.setUserName(rs.getString("userName"));
				bean.setPostID(rs.getInt("postID"));
				bean.setTime(rs.getLong("time"));
				bean.setContent(rs.getString("content"));
				//bean.setChildPostID(rs.getString("childPost"));
				bean.setParentPostID(rs.getLong("parentPostID"));
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
	public List<? extends BasePostBean> queryAll() {
		// TODO Auto-generated method stub
		ArrayList<PostBean> postList = new ArrayList<PostBean>();
		String sql = "select * from post";
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
				PostBean bean = new PostBean();
				bean.setUserName(rs.getString("userName"));
				bean.setPostID(rs.getInt("postID"));
				bean.setTime(rs.getLong("time"));
				bean.setContent(rs.getString("content"));
				//bean.setChildPostID(rs.getString("childPost"));
				bean.setParentPostID(rs.getLong("parentPostID"));
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
	public List<? extends BasePostBean> queryByWhat(String what, String value) {
		// TODO Auto-generated method stub
		ArrayList<PostBean> postList = new ArrayList<PostBean>();
		String sql = "select * from post where "+what+" =?";
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
				PostBean bean = new PostBean();
				bean.setUserName(rs.getString("userName"));
				bean.setPostID(rs.getInt("postID"));
				bean.setTime(rs.getLong("time"));
				bean.setContent(rs.getString("content"));
				//bean.setChildPostID(rs.getString("childPost"));
				bean.setParentPostID(rs.getLong("parentPostID"));
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
	public List<? extends BasePostBean> queryByWhatAndOrder(String what, String value,String order,boolean desc) {
		// TODO Auto-generated method stub
		ArrayList<PostBean> postList = new ArrayList<PostBean>();
		//String sql = "select * from post where "+what+" =?";
		String sql = "";
		if(desc)
			sql = "select * from post where "+what+" =? order by "+order+" desc";
		else
			sql = "select * from post where "+what+" =? order by "+order+" asc";
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
				PostBean bean = new PostBean();
				bean.setUserName(rs.getString("userName"));
				bean.setPostID(rs.getInt("postID"));
				bean.setTime(rs.getLong("time"));
				bean.setContent(rs.getString("content"));
				//bean.setChildPostID(rs.getString("childPost"));
				bean.setParentPostID(rs.getLong("parentPostID"));
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

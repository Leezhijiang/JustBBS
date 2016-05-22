package top.jjust.db.daoimp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Blob;

import top.jjust.bean.user.UserBean;
import top.jjust.db.BasePostDBConn;
import top.jjust.db.dao.UserDAO;

public class UserDAOIMP implements UserDAO{

	@Override
	public boolean addUser(UserBean user){
		// TODO Auto-generated method stub
		String sql = "INSERT INTO user(name,password,realName,studentID,icon,phone,email,flag,level,registTime,banTime) VALUES(?,?,?,?,?,?,?,?,?,?,?)" ;   
      PreparedStatement pstmt = null ;   
      BasePostDBConn dbc = null ;   
      // 下面是针对数据库的具体操作   
      try{
          // 连接数据库   
          dbc = new BasePostDBConn() ;   
          pstmt = dbc.getConnection().prepareStatement(sql) ;  
//  		1private String name;//用户名
          pstmt.setString(1, user.getName());   
//		2private String password;//密码
          pstmt.setString(2, user.getPassword());
//		3private String realName;//真实姓名
          pstmt.setString(3,user.getRealName());
//		4private int studentID;//学号
          pstmt.setString(4,user.getStudentID());
//  		5private String icon;//头像
          pstmt.setBlob(5, user.getIcon());
//			6private int phone;//手机号
          pstmt.setString(6,user.getPhone());
//			7private String email;//邮箱
          pstmt.setString(7,user.getEmail());
//  		8private int flag;//标记－0
          pstmt.setInt(8,user.getFlag());
//		9private int level;//等级－0
          pstmt.setInt(9,user.getLevel());
//  		10private long registTime;//注册时间-data
          pstmt.setLong(10,user.getRegistTime());
//  		11private long banTime;//封号时长-0
          pstmt.setLong(11,user.getBanTime());
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
	public boolean update(UserBean user) {
		// TODO Auto-generated method stub
		 String sql="update user set password =?,realName =?,studentID =?,icon =?,phone =?,email =?,flag =?,level =?,registTime =?,banTime =? where name=?";
		 PreparedStatement pstmt = null ;   
	      BasePostDBConn dbc = null ;   
	      // 下面是针对数据库的具体操作   
	      try{
	          // 连接数据库   
	          dbc = new BasePostDBConn() ;   
	          pstmt = dbc.getConnection().prepareStatement(sql) ;  
//			2private String password;//密码
	          pstmt.setString(1, user.getPassword());
//			3private String realName;//真实姓名
	          pstmt.setString(2,user.getRealName());
//			4private int studentID;//学号
	          pstmt.setString(3,user.getStudentID());
//	  		5private String icon;//头像
	          pstmt.setBlob(4, user.getIcon());
//				6private int phone;//手机号
	          pstmt.setString(5,user.getPhone());
//				7private String email;//邮箱
	          pstmt.setString(6,user.getEmail());
//	  		8private int flag;//标记－0
	          pstmt.setInt(7,user.getFlag());
//			9private int level;//等级－0
	          pstmt.setInt(8,user.getLevel());
//	  		10private long registTime;//注册时间-data
	          pstmt.setLong(9,user.getRegistTime());
//	  		11private long banTime;//封号时长-0
	          pstmt.setLong(10,user.getBanTime());
//		  		1private String name;//用户名
	          pstmt.setString(11, user.getName());   
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
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		String sql="delete from user where name=?";
		 PreparedStatement pstmt = null ;   
	      BasePostDBConn dbc = null ;   
	      // 下面是针对数据库的具体操作   
	      try{
	          // 连接数据库   
	          dbc = new BasePostDBConn() ;   
	          pstmt = dbc.getConnection().prepareStatement(sql) ;  
	          pstmt.setString(1, name);   
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
	public UserBean getUserByName(String name){
		// TODO Auto-generated method stub
		String sql="select * from user where name =?";
		ResultSet rs = null;
		PreparedStatement pstmt = null ;   
	    BasePostDBConn dbc = null ; 
	    UserBean user= null;
        try {
        	dbc = new BasePostDBConn() ;   
	        pstmt = dbc.getConnection().prepareStatement(sql) ;  
	        pstmt.setString(1, name);   
            rs=pstmt.executeQuery();
            while(rs.next()){
               user= new UserBean();
               //name,password,realName,studentID,icon,phone,email,flag,level,registTime,banTime
               user.setName(rs.getString("name"));
               user.setPassword(rs.getString("password"));
               user.setRealName(rs.getString("realName"));
               user.setStudentID(rs.getString("studentID"));
               user.setIcon(rs.getBlob("icon").getBinaryStream());
               user.setPhone(rs.getString("phone"));
               user.setEmail(rs.getString("email"));
               user.setFlag(rs.getInt("flag"));
               user.setLevel(rs.getInt("level"));
               user.setRegistTime(rs.getLong("registTime"));
               user.setBanTime(rs.getLong("banTime"));
               break;
            }
       } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }finally{
           dbc.close();
       }
        
       
        return user;
	}

}

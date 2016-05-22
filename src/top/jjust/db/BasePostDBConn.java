package top.jjust.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class BasePostDBConn {
	//定义数据库驱动类   
    protected final String DBDRIVER = "com.mysql.jdbc.Driver" ;   
    //定义数据库连接URL   
    protected final String DBURL = "jdbc:mysql://localhost:3306/justbbs" ;   
    //定义数据库连接用户名   
    protected final String DBUSER = "root" ;   
    //定义数据库连接密码   
    protected final String DBPASSWORD = "Lizhijiang123@" ;   
    //定义数据库连接对象   
    protected Connection conn = null ;   
    //构造方法，加载驱动   
    public BasePostDBConn(){   
        try{   
            Class.forName(DBDRIVER) ;   
            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;     
        }   
        catch (Exception e){   
            System.out.println("加载驱动失败");   
        }   
    }   
    // 取得数据库连接   
    public Connection getConnection(){   
        return conn ;   
    }   
    // 关闭数据库连接   
    public void close(){   
        try{   
            conn.close() ;   
        }catch (Exception e){   
            System.out.println("数据库连接关闭失败");   
        }          
    }   
}

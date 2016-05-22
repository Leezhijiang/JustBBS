package top.jjust.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

import org.apache.catalina.User;

import com.mysql.fabric.xmlrpc.base.Data;
import com.sun.javafx.fxml.BeanAdapter;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import top.jjust.bean.post.CommitPostBean;
import top.jjust.bean.post.PostBean;
import top.jjust.bean.post.TitlePostBean;
import top.jjust.bean.user.UserBean;
import top.jjust.controller.CommitPostController;
import top.jjust.controller.PostController;
import top.jjust.controller.TitlePostController;
import top.jjust.controller.UserController;
import top.jjust.db.dao.DAOFactory;

public class Test {
	@org.junit.Test
	public void get() throws Exception {
		//*******************User测试
//		UserBean bean = new UserBean();
//		bean.setName("FIRSTUSER");
//		bean.setPassword("123");
//		bean.setEmail("15615");
//		bean.setFlag(0);
//		String path = System.getProperty("user.dir");
//		InputStream is = new FileInputStream(path+"/WebContent/Img/icon.gif");
//		bean.setIcon(is);
//		bean.setLevel(100);
//		bean.setPhone("110");
//		bean.setRealName("li");
//		bean.setRegistTime(new Date().getTime());
//		bean.setStudentID("1341904220");
//		System.out.println(UserController.createNewUser(bean));
//		UserBean userBean = UserController.getUserByName("FIRSTUSER");
//		if(userBean==null){
//			System.out.println("null");
//		}else {
//			System.out.println(userBean.toString());
//		}
		//System.out.println(UserController.deleteUser("FIRSTUSER")+"");
		//***************************TitlePost测试
//		TitlePostBean post = new TitlePostBean();
//		post.setAgree(100);
//		post.setDisagree(10);
//		post.setChildPostID("12345,4");
//		post.setContent("内容XXXXXX");
//		post.setTime(new Date().getTime());
//		post.setTitle("测试");
//		post.setUserName("LEE");
//		System.out.println(TitlePostController.create(post));
		//System.out.println(TitlePostController.addChild(6, 4));
		//TitlePostController.deleteChild(6);
		//System.out.println(TitlePostController.deletePostByPostID(4));
		//System.out.println(TitlePostController.deleteChildByChildPostID(3, 12345));
		//TitlePostController.addChild(3,1);
		//***********************post测试
//		PostBean post = new PostBean();
//		post.setParentPostID(3);
//		post.setChildPostID("12345,4");
//		post.setContent("内容XXXXXX");
//		post.setTime(new Date().getTime());
//		post.setUserName("LEE");
//		System.out.println(PostController.create(post));
		//PostBean post = (PostBean) DAOFactory.getPostDAO().queryByWhat("postID", ""+1).get(0);
		//System.out.println(post.getParentPostID());
		//System.out.println(PostController.);
		//*******************综合测试
//		TitlePostBean post = new TitlePostBean();
//		post.setAgree(0);
//		post.setDisagree(0);
//		post.setTime(new Date().getTime());
//		post.setTitle("第一次综合测试");
//		post.setUserName("LEE");
//		post.setContent("diyici内容");
//		TitlePostController.create(post);
//		CommitPostBean post = new CommitPostBean();
//		post.setContent("第一次回复，1l");
//		post.setUserName("LEE");
//		post.setTime(new Date().getTime());
//		post.setParentPostID(2);
//		CommitPostController.publish(post);
		//CommitPostController.deletePostByPostID(1);
		//PostController.deleteByPostID(3);
		//TitlePostController.deletePostByPostID(7);
	}


}

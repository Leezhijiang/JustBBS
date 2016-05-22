package top.jjust.controller;

import top.jjust.bean.user.UserBean;
import top.jjust.db.dao.DAOFactory;

public class UserController {
	/**
	 * 检测是否重名
	 * @param name
	 * @return
	 */
	public static boolean studentidCrossCheck(String name){
		if(getUserByName(name) == null)
			return false;
		return true;
	}
	/**
	 * 新建用户,检查规则
	 * @param user
	 */
	public static boolean createNewUser(UserBean user){
		return DAOFactory.getUserDAO().addUser(user);
	}
	/**
	 * 以user的name属性为标志改变其他属性
	 * @param user
	 */
	public static void updateUser(UserBean user){
		DAOFactory.getUserDAO().update(user);
	}
	/**
	 * 根据名字得到用户
	 * @param name
	 * @return null说明没有该用户
	 */
	public static UserBean getUserByName(String name){
		return DAOFactory.getUserDAO().getUserByName(name);
		
	}
	/**
	 * 登录(检测是否含有非法字符)
	 * @return null登录失败
	 */
	public static UserBean login(String name ,String password){
		UserBean user = getUserByName(name);
		if(user != null&&!password.contains("||")){
			if(user.getPassword() == password){
				return user;
			}
		}
		return null;
	}
	/**
	 * 根据名字删除用户
	 * @param name
	 * @return false 删除失败或者没有这个用户
	 */
	public static boolean deleteUser(String name){
		return DAOFactory.getUserDAO().delete(name);
	}
}

package top.jjust.db.dao;

import java.util.List;

import top.jjust.bean.post.BasePostBean;
import top.jjust.bean.user.UserBean;

public interface UserDAO {
	 // 增加操作   
    public boolean addUser(UserBean user) ;   
    // 修改操作   
    public boolean update(UserBean user);   
    // 删除操作   
    public boolean delete(String name) ;   
    // 登录操作   
    public UserBean getUserByName(String name);   
}

package top.jjust.db.dao;

import java.util.List;

import top.jjust.bean.post.BasePostBean;

public interface BasePostDAO {
	 // 增加操作   
    public void insert(BasePostBean post) throws Exception ;   
    // 修改操作   
    public void update(BasePostBean post) throws Exception ;   
    // 删除操作   
    public void delete(BasePostBean post) throws Exception ;   
    // 按页码查询操作   
    public List<BasePostBean> queryByPage(int page) throws Exception ;   
    // 查询全部   
    public List<BasePostBean> queryAll() throws Exception ;   
}

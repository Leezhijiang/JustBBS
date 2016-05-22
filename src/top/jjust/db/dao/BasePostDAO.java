package top.jjust.db.dao;

import java.util.List;

import top.jjust.bean.post.BasePostBean;

public interface BasePostDAO {
	 // 增加操作   
    public boolean create(BasePostBean post) ;   
    // 修改操作   
    public boolean updateContent(long postID,String content) ;   
    //修改子贴操作
    public boolean updateChildPost(long postID,String childPost);
    // 删除操作   
    public boolean deletePostByPostID(long postID);   
    // 按页码查询操作   
    /**
     * 按照page和size选定第几页，按照order选定排序方式，按照desc选定是否进行降序排列
     * @param page 第几页>=1
     * @param size 每页几条数据>=0
     * @param order
     * @param desc 是否降序排列
     * @return
     */
    public List<? extends BasePostBean> queryByPage(int page,int size,String order,boolean desc);   
    // 查询全部   
    public List<? extends BasePostBean> queryAll();   
    //按页码查询操作 
    public List<? extends BasePostBean> queryByWhat(String what,String value);
    //按照what查找，是否需要按order排序，生序降序？
    public List<? extends BasePostBean> queryByWhatAndOrder(String what, String value,String order,boolean desc);
}

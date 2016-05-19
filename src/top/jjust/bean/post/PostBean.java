package top.jjust.bean.post;

import java.util.ArrayList;

import top.jjust.bean.post.BasePostBean;

public class PostBean extends BasePostBean {
	private BasePostBean parent;//父帖子
	private ArrayList<BasePostBean> childPost;//子帖子
	public BasePostBean getParent() {
		return parent;
	}
	public void setParent(BasePostBean parent) {
		this.parent = parent;
	}
	public ArrayList<BasePostBean> getChildPost() {
		return childPost;
	}
	public void setChildPost(ArrayList<BasePostBean> childPost) {
		this.childPost = childPost;
	}
}

package top.jjust.bean.post;

import top.jjust.bean.post.BasePostBean;

public class CommitPostBean extends BasePostBean {
	private BasePostBean parent;//当前帖子的父类

	public BasePostBean getParent() {
		return parent;
	}

	public void setParent(BasePostBean parent) {
		this.parent = parent;
	}
}

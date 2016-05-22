package top.jjust.bean.post;

import top.jjust.bean.post.BasePostBean;

public class CommitPostBean extends BasePostBean {
	private long parentPostID;//当前帖子的父类

	public long getParentPostID() {
		return parentPostID;
	}

	public void setParentPostID(long parentPostID) {
		this.parentPostID = parentPostID;
	}
	
}

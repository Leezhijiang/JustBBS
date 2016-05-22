package top.jjust.bean.post;

import top.jjust.bean.user.*;;

public class BasePostBean {
	private long postID;//帖子标示附-自动设置
	private String userName;//所属用户
	private long time;//发表时间
	private String content;//发表内容
	public String getUserName() {
		return userName;
	}
	public long getPostID() {
		return postID;
	}
	public void setPostID(long postID) {
		this.postID = postID;
	}
	public void setUserName(String user) {
		this.userName = user;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.postID+"    "+this.userName+"    "+this.content;
	}
}

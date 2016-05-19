package top.jjust.bean.post;

import top.jjust.bean.user.*;;

public class BasePostBean {
	private BaseUserBean user;//所属用户
	private long time;//发表时间
	private String content;//发表内容
	public BaseUserBean getUser() {
		return user;
	}
	public void setUser(BaseUserBean user) {
		this.user = user;
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
}

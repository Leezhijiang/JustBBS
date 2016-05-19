package top.jjust.bean.post;

import java.util.ArrayList;

import top.jjust.bean.post.BasePostBean;
import top.jjust.bean.user.BaseUserBean;

public class TitlePostBean extends BasePostBean {
	private String title;//标题
	private int agree;//赞同票数
	private int disagree;//反对票数
	private ArrayList<BasePostBean>  childPost;//子贴
	private int size;//子贴数量
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAgree() {
		return agree;
	}
	public void setAgree(int agree) {
		this.agree = agree;
	}
	public int getDisagree() {
		return disagree;
	}
	public void setDisagree(int disagree) {
		this.disagree = disagree;
	}
	public ArrayList<BasePostBean> getChildPost() {
		return childPost;
	}
	public void setChildPost(ArrayList<BasePostBean> childPost) {
		this.childPost = childPost;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}

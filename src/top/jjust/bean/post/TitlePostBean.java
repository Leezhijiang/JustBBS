package top.jjust.bean.post;

import java.util.ArrayList;

import top.jjust.bean.post.BasePostBean;
import top.jjust.bean.user.BaseUserBean;
import top.jjust.common.StaticValue;

public class TitlePostBean extends BasePostBean {
	private String title;//标题
	private int agree;//赞同票数
	private int disagree;//反对票数
	//private String  childPostID;//子贴(数据库中使用String表示，存储子类的id，用“，”分割)
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
//	public String getAllChildPostID() {
//		return childPostID;
//	}
//	public void setChildPostID(String childPostID) {
//		if(this.childPostID == null||this.childPostID.equals("")){
//			this.childPostID = childPostID;
//			return;
//		}
//		this.childPostID = this.childPostID+StaticValue.SPLIT_FOR_CHILDPOST+childPostID;
//		this.size = childPostID.split(StaticValue.SPLIT_FOR_CHILDPOST).length;
//	}
//	public void setChildPostIDCommon(String childPostID){
//		this.childPostID = childPostID;
//	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}

package top.jjust.bean.post;

import java.io.NotActiveException;
import java.math.BigInteger;
import java.util.ArrayList;

import top.jjust.bean.post.BasePostBean;
import top.jjust.common.StaticValue;

public class PostBean extends BasePostBean {
	private long parentPostID;//父帖子
	//private String  childPostID;//子帖子
	public long getParentPostID() {
		return parentPostID;
	}
	public void setParentPostID(long parentPostID) {
		this.parentPostID = parentPostID;
	}
//	public String getChildPostID() {
//		return childPostID;
//	}
//	public void setChildPostID(String childPostID) {
//		if(this.childPostID == null||this.childPostID.equals("")){
//			this.childPostID = childPostID;
//			return;
//		}
//		this.childPostID = this.childPostID+StaticValue.SPLIT_FOR_CHILDPOST+childPostID;
//	}
//	public void setChildPostIDCommon(String childPostID){
//		this.childPostID = childPostID;
//	}
	
}

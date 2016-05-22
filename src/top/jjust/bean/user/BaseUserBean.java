package top.jjust.bean.user;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.tomcat.jni.FileInfo;

public class BaseUserBean {
	private String name = "";//用户名
	private int level = 0;//等级
	private InputStream icon = null;//头像
	private int flag = 0;//标记
	private String password = "";
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public InputStream getIcon() {
		return icon;
	}
	public void setIcon(InputStream icon) {
		if(icon == null){
			try {
				this.icon = new FileInputStream("\\./Img/icon\\.gif");
				return;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.icon = icon;
	}
}

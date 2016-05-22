package top.jjust.bean.user;

public class AdminUserBean {
	private long farewellTime;//卸任时间
	private int agree;
	private int disagree;
	public long getFarewellTime() {
		return farewellTime;
	}
	public void setFarewellTime(long farewellTime) {
		this.farewellTime = farewellTime;
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
}

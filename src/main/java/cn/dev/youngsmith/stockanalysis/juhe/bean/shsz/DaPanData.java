package cn.dev.youngsmith.stockanalysis.juhe.bean.shsz;

import java.io.Serializable;

/**
 * @ClassName: DaPanData
 * @Description: TODO 即时查询大盘信息
 * @author shiy
 * @date 2017年3月10日 下午2:46:58
 */
public class DaPanData implements Serializable {

	private static final long serialVersionUID = 6232497812340647010L;
	private double dot;
	private String name;
	private double nowPic;
	private double rate;
	private double traAccount;
	private int traAmount;

	public double getDot() {
		return dot;
	}

	public void setDot(double dot) {
		this.dot = dot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getNowPic() {
		return nowPic;
	}

	public void setNowPic(double nowPic) {
		this.nowPic = nowPic;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getTraAccount() {
		return traAccount;
	}

	public void setTraAccount(double traAccount) {
		this.traAccount = traAccount;
	}

	public int getTraAmount() {
		return traAmount;
	}

	public void setTraAmount(int traAmount) {
		this.traAmount = traAmount;
	}

	@Override
	public String toString() {
		return "DaPanData [dot=" + dot + ", name=" + name + ", nowPic=" + nowPic + ", rate=" + rate + ", traAccount="
				+ traAccount + ", traAmount=" + traAmount + "]";
	}

}

package cn.dev.youngsmith.stockanalysis.juhe.bean.shsz;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: DaPanData
 * @Description: TODO 即时查询大盘信息
 * @author shiy
 * @date 2017年3月10日 下午2:46:58
 */
@XmlRootElement
@Entity
public class DaPanData implements Serializable {
	private static final long serialVersionUID = 6232497812340647010L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int daPanData_ID;
	private double dot;
	private String name;
	private double nowPic;
	private double rate;
	private double traAccount;
	private int traAmount;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "daPanData")
	private SHSZInstantInfo shszInstantInfo;

	public DaPanData() {

	}

	public int getDaPanData_ID() {
		return daPanData_ID;
	}

	public void setDaPanData_ID(int daPanData_ID) {
		this.daPanData_ID = daPanData_ID;
	}

	public SHSZInstantInfo getShszInstantInfo() {
		return shszInstantInfo;
	}

	public void setShszInstantInfo(SHSZInstantInfo shszInstantInfo) {
		this.shszInstantInfo = shszInstantInfo;
	}

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

package cn.dev.youngsmith.stockanalysis.juhe.bean.shsz;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: GoPicture
 * @Description: TODO 即时查询截图
 * @author shiy
 * @date 2017年3月10日 下午2:48:07
 */
@XmlRootElement
@Entity
public class GoPicture implements Serializable {

	private static final long serialVersionUID = -9076460459133182676L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int goPicture_ID;

	@Column(length = 1024, columnDefinition = "Varchar(1024)")
	private String minurl;
	@Column(length = 1024, columnDefinition = "Varchar(1024)")
	private String dayurl;
	@Column(length = 1024, columnDefinition = "Varchar(1024)")
	private String weekurl;
	@Column(length = 1024, columnDefinition = "Varchar(1024)")
	private String monthurl;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "goPicture")
	private SHSZInstantInfo shszInstantInfo;

	public SHSZInstantInfo getShszInstantInfo() {
		return shszInstantInfo;
	}

	public void setShszInstantInfo(SHSZInstantInfo shszInstantInfo) {
		this.shszInstantInfo = shszInstantInfo;
	}

	public int getGoPicture_ID() {
		return goPicture_ID;
	}

	public void setGoPicture_ID(int goPicture_ID) {
		this.goPicture_ID = goPicture_ID;
	}

	public String getMinurl() {
		return minurl;
	}

	public void setMinurl(String minurl) {
		this.minurl = minurl;
	}

	public String getDayurl() {
		return dayurl;
	}

	public void setDayurl(String dayurl) {
		this.dayurl = dayurl;
	}

	public String getWeekurl() {
		return weekurl;
	}

	public void setWeekurl(String weekurl) {
		this.weekurl = weekurl;
	}

	public String getMonthurl() {
		return monthurl;
	}

	public void setMonthurl(String monthurl) {
		this.monthurl = monthurl;
	}

	@Override
	public String toString() {
		return "GoPicture [minurl=" + minurl + ", dayurl=" + dayurl + ", weekurl=" + weekurl + ", monthurl=" + monthurl
				+ "]";
	}

}

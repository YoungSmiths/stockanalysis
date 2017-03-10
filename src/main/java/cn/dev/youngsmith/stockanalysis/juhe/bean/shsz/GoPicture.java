package cn.dev.youngsmith.stockanalysis.juhe.bean.shsz;

import java.io.Serializable;

/**
 * @ClassName: GoPicture
 * @Description: TODO 即时查询截图
 * @author shiy
 * @date 2017年3月10日 下午2:48:07
 */
public class GoPicture implements Serializable {

	private static final long serialVersionUID = -9076460459133182676L;
	private String minurl;
	private String dayurl;
	private String weekurl;
	private String monthurl;

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

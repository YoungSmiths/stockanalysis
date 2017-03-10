package cn.dev.youngsmith.stockanalysis.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class StockInstantInfo implements Serializable {
	private static final long serialVersionUID = -6710876614390230132L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	/**
	 * 股票编码
	 */
	private String gid;
	/**
	 * 股票名
	 */
	private String name;
	/**
	 * 竞卖价
	 */
	private double reservePri;
	/**
	 * 竞买价
	 */
	private double competitivePri;
	/**
	 * 今日开盘价
	 */
	private double todayStartPri;
	/**
	 * 昨日收盘价
	 */
	private double yestodEndPri;
	/**
	 * 涨跌百分比
	 */
	private double increPer;
	/**
	 * 涨跌额
	 */
	private double increase;

	/**
	 * 当前价格
	 */
	private double nowPri;
	/**
	 * 今天目前最高价
	 */
	private double todayMax;
	/**
	 * 今天目前最低价
	 */
	private double todayMin;
	/**
	 * 交易量
	 */
	private int traNumber;
	/**
	 * 交易额
	 */
	private double traAmount;
	/**
	 * 日期
	 */
	private Date date;
	/**
	 * 时间
	 */
	private String time;

	private int buyOne;
	private double buyOnePri;
	private int buyTwo;
	private double buyTwoPri;
	private int buyThree;
	private double buyThreePri;
	private int buyFour;
	private double buyFourPri;
	private int buyFive;
	private double buyFivePri;

	private int sellOne;
	private double sellOnePri;
	private int sellTwo;
	private double sellTwoPri;
	private int sellThree;
	private double sellThreePri;
	private int sellFour;
	private double sellFourPri;
	private int sellFive;
	private double sellFivePri;
	private String dapandata;
	private String gopicture;

	class GoPicture {
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
			return "GoPicture [minurl=" + minurl + ", dayurl=" + dayurl + ", weekurl=" + weekurl + ", monthurl="
					+ monthurl + "]";
		}

	}

	class DaPanData {
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
			return "DaPanData [dot=" + dot + ", name=" + name + ", nowPic=" + nowPic + ", rate=" + rate
					+ ", traAccount=" + traAccount + ", traAmount=" + traAmount + "]";
		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getReservePri() {
		return reservePri;
	}

	public void setReservePri(double reservePri) {
		this.reservePri = reservePri;
	}

	public double getCompetitivePri() {
		return competitivePri;
	}

	public void setCompetitivePri(double competitivePri) {
		this.competitivePri = competitivePri;
	}

	public double getTodayStartPri() {
		return todayStartPri;
	}

	public void setTodayStartPri(double todayStartPri) {
		this.todayStartPri = todayStartPri;
	}

	public double getYestodEndPri() {
		return yestodEndPri;
	}

	public void setYestodEndPri(double yestodEndPri) {
		this.yestodEndPri = yestodEndPri;
	}

	public double getIncrePer() {
		return increPer;
	}

	public void setIncrePer(double increPer) {
		this.increPer = increPer;
	}

	public double getIncrease() {
		return increase;
	}

	public void setIncrease(double increase) {
		this.increase = increase;
	}

	public double getNowPri() {
		return nowPri;
	}

	public void setNowPri(double nowPri) {
		this.nowPri = nowPri;
	}

	public double getTodayMax() {
		return todayMax;
	}

	public void setTodayMax(double todayMax) {
		this.todayMax = todayMax;
	}

	public double getTodayMin() {
		return todayMin;
	}

	public void setTodayMin(double todayMin) {
		this.todayMin = todayMin;
	}

	public int getTraNumber() {
		return traNumber;
	}

	public void setTraNumber(int traNumber) {
		this.traNumber = traNumber;
	}

	public double getTraAmount() {
		return traAmount;
	}

	public void setTraAmount(double traAmount) {
		this.traAmount = traAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getBuyOne() {
		return buyOne;
	}

	public void setBuyOne(int buyOne) {
		this.buyOne = buyOne;
	}

	public double getBuyOnePri() {
		return buyOnePri;
	}

	public void setBuyOnePri(double buyOnePri) {
		this.buyOnePri = buyOnePri;
	}

	public int getBuyTwo() {
		return buyTwo;
	}

	public void setBuyTwo(int buyTwo) {
		this.buyTwo = buyTwo;
	}

	public double getBuyTwoPri() {
		return buyTwoPri;
	}

	public void setBuyTwoPri(double buyTwoPri) {
		this.buyTwoPri = buyTwoPri;
	}

	public int getBuyThree() {
		return buyThree;
	}

	public void setBuyThree(int buyThree) {
		this.buyThree = buyThree;
	}

	public double getBuyThreePri() {
		return buyThreePri;
	}

	public void setBuyThreePri(double buyThreePri) {
		this.buyThreePri = buyThreePri;
	}

	public int getBuyFour() {
		return buyFour;
	}

	public void setBuyFour(int buyFour) {
		this.buyFour = buyFour;
	}

	public double getBuyFourPri() {
		return buyFourPri;
	}

	public void setBuyFourPri(double buyFourPri) {
		this.buyFourPri = buyFourPri;
	}

	public int getBuyFive() {
		return buyFive;
	}

	public void setBuyFive(int buyFive) {
		this.buyFive = buyFive;
	}

	public double getBuyFivePri() {
		return buyFivePri;
	}

	public void setBuyFivePri(double buyFivePri) {
		this.buyFivePri = buyFivePri;
	}

	public int getSellOne() {
		return sellOne;
	}

	public void setSellOne(int sellOne) {
		this.sellOne = sellOne;
	}

	public double getSellOnePri() {
		return sellOnePri;
	}

	public void setSellOnePri(double sellOnePri) {
		this.sellOnePri = sellOnePri;
	}

	public int getSellTwo() {
		return sellTwo;
	}

	public void setSellTwo(int sellTwo) {
		this.sellTwo = sellTwo;
	}

	public double getSellTwoPri() {
		return sellTwoPri;
	}

	public void setSellTwoPri(double sellTwoPri) {
		this.sellTwoPri = sellTwoPri;
	}

	public int getSellThree() {
		return sellThree;
	}

	public void setSellThree(int sellThree) {
		this.sellThree = sellThree;
	}

	public double getSellThreePri() {
		return sellThreePri;
	}

	public void setSellThreePri(double sellThreePri) {
		this.sellThreePri = sellThreePri;
	}

	public int getSellFour() {
		return sellFour;
	}

	public void setSellFour(int sellFour) {
		this.sellFour = sellFour;
	}

	public double getSellFourPri() {
		return sellFourPri;
	}

	public void setSellFourPri(double sellFourPri) {
		this.sellFourPri = sellFourPri;
	}

	public int getSellFive() {
		return sellFive;
	}

	public void setSellFive(int sellFive) {
		this.sellFive = sellFive;
	}

	public double getSellFivePri() {
		return sellFivePri;
	}

	public void setSellFivePri(double sellFivePri) {
		this.sellFivePri = sellFivePri;
	}

	public String getDapandata() {
		return dapandata;
	}

	public void setDapandata(String dapandata) {
		this.dapandata = dapandata;
	}

	public String getGopicture() {
		return gopicture;
	}

	public void setGopicture(String gopicture) {
		this.gopicture = gopicture;
	}

	@Override
	public String toString() {
		return "StockInstantInfo [id=" + id + ", gid=" + gid + ", name=" + name + ", reservePri=" + reservePri
				+ ", competitivePri=" + competitivePri + ", todayStartPri=" + todayStartPri + ", yestodEndPri="
				+ yestodEndPri + ", increPer=" + increPer + ", increase=" + increase + ", nowPri=" + nowPri
				+ ", todayMax=" + todayMax + ", todayMin=" + todayMin + ", traNumber=" + traNumber + ", traAmount="
				+ traAmount + ", date=" + date + ", time=" + time + ", buyOne=" + buyOne + ", buyOnePri=" + buyOnePri
				+ ", buyTwo=" + buyTwo + ", buyTwoPri=" + buyTwoPri + ", buyThree=" + buyThree + ", buyThreePri="
				+ buyThreePri + ", buyFour=" + buyFour + ", buyFourPri=" + buyFourPri + ", buyFive=" + buyFive
				+ ", buyFivePri=" + buyFivePri + ", sellOne=" + sellOne + ", sellOnePri=" + sellOnePri + ", sellTwo="
				+ sellTwo + ", sellTwoPri=" + sellTwoPri + ", sellThree=" + sellThree + ", sellThreePri=" + sellThreePri
				+ ", sellFour=" + sellFour + ", sellFourPri=" + sellFourPri + ", sellFive=" + sellFive
				+ ", sellFivePri=" + sellFivePri + ", dapandata=" + dapandata + ", gopicture=" + gopicture + "]";
	}

}
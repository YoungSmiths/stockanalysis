package cn.dev.youngsmith.stockanalysis.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class StockDayInfo implements Serializable {
	private static final long serialVersionUID = 4232272229545190786L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	/**
	 * 股票编号
	 */
	private int stockId;
	/**
	 * 今日开盘价
	 */
	private double todayStartPrice;
	/**
	 * 昨日收盘价
	 */
	private double yesterdayEndPrice;
	/**
	 * 涨跌百分比
	 */
	private double increasePercent;
	/**
	 * 涨跌金额
	 */
	private double increase;
	/**
	 * 今日最高价
	 */
	private double todayMax;
	/**
	 * 今日最低价
	 */
	private double todayMin;
	/**
	 * 竞买价格
	 */
	private double competitivePrice;
	/**
	 * 竞卖价格
	 */
	private double reservePrice;
	/**
	 * 成交金额
	 */
	private double traceAmount;
	/**
	 * 成交量
	 */
	private int traceNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public double getTodayStartPrice() {
		return todayStartPrice;
	}

	public void setTodayStartPrice(double todayStartPrice) {
		this.todayStartPrice = todayStartPrice;
	}

	public double getYesterdayEndPrice() {
		return yesterdayEndPrice;
	}

	public void setYesterdayEndPrice(double yesterdayEndPrice) {
		this.yesterdayEndPrice = yesterdayEndPrice;
	}

	public double getIncreasePercent() {
		return increasePercent;
	}

	public void setIncreasePercent(double increasePercent) {
		this.increasePercent = increasePercent;
	}

	public double getIncrease() {
		return increase;
	}

	public void setIncrease(double increase) {
		this.increase = increase;
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

	public double getCompetitivePrice() {
		return competitivePrice;
	}

	public void setCompetitivePrice(double competitivePrice) {
		this.competitivePrice = competitivePrice;
	}

	public double getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(double reservePrice) {
		this.reservePrice = reservePrice;
	}

	public double getTraceAmount() {
		return traceAmount;
	}

	public void setTraceAmount(double traceAmount) {
		this.traceAmount = traceAmount;
	}

	public int getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(int traceNumber) {
		this.traceNumber = traceNumber;
	}

}

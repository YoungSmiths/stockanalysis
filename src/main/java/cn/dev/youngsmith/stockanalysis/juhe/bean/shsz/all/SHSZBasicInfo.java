package cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.all;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: SHSZAllJson
 * @Description: TODO 上证深圳所有股票model,单个股票信息
 * @author shiy
 * @date 2017年3月10日 下午2:45:14
 */
@XmlRootElement
@Entity
public class SHSZBasicInfo implements Serializable {
	private static final long serialVersionUID = -5245565776292348024L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String symbol;
	private String name;
	private double trade;
	private double pricechange;
	private double changepercent;
	private double buy;
	private double sell;
	private double settlement;
	private double open;
	private double high;
	private double low;
	private int volume;
	private int amount;
	private String code;
	private String ticktime;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTrade() {
		return trade;
	}

	public void setTrade(double trade) {
		this.trade = trade;
	}

	public double getPricechange() {
		return pricechange;
	}

	public void setPricechange(double pricechange) {
		this.pricechange = pricechange;
	}

	public double getChangepercent() {
		return changepercent;
	}

	public void setChangepercent(double changepercent) {
		this.changepercent = changepercent;
	}

	public double getBuy() {
		return buy;
	}

	public void setBuy(double buy) {
		this.buy = buy;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(double sell) {
		this.sell = sell;
	}

	public double getSettlement() {
		return settlement;
	}

	public void setSettlement(double settlement) {
		this.settlement = settlement;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTicktime() {
		return ticktime;
	}

	public void setTicktime(String ticktime) {
		this.ticktime = ticktime;
	}

	@Override
	public String toString() {
		return "SHSZBasicInfo [id=" + id + ", symbol=" + symbol + ", name=" + name + ", trade=" + trade
				+ ", pricechange=" + pricechange + ", changepercent=" + changepercent + ", buy=" + buy + ", sell="
				+ sell + ", settlement=" + settlement + ", open=" + open + ", high=" + high + ", low=" + low
				+ ", volume=" + volume + ", amount=" + amount + ", code=" + code + ", ticktime=" + ticktime + "]";
	}

}

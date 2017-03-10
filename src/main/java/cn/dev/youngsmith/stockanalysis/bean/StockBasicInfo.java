package cn.dev.youngsmith.stockanalysis.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class StockBasicInfo implements Serializable {
	private static final long serialVersionUID = -5333784509382615243L;
	@Id
	@Column(unique = true, nullable = false)
	private int stockId;
	private String stockName;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

}

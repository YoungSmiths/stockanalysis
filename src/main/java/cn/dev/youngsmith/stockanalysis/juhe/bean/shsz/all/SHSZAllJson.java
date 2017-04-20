package cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.all;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: SHSZAllJson
 * @Description: TODO 上证深圳所有股票model
 * @author shiy
 * @date 2017年3月10日 下午2:45:14
 */
//@XmlRootElement
//@Entity
public class SHSZAllJson implements Serializable {
	private static final long serialVersionUID = 3640355777360442314L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int totalCount;
	private int page;
	private int num;
	private List<SHSZBasicInfo> data = new ArrayList<SHSZBasicInfo>();

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<SHSZBasicInfo> getData() {
		return data;
	}

	public void setData(List<SHSZBasicInfo> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SHSZAllJson [id=" + id + ", totalCount=" + totalCount + ", page=" + page + ", num=" + num + ", data="
				+ data + "]";
	}

}

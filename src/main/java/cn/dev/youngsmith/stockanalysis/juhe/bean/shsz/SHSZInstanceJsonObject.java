package cn.dev.youngsmith.stockanalysis.juhe.bean.shsz;

import java.io.Serializable;

public class SHSZInstanceJsonObject implements Serializable {
	private static final long serialVersionUID = -743256943932982709L;

	private SHSZInstantInfo data = new SHSZInstantInfo();
	private DaPanData dapandata = new DaPanData();
	private GoPicture gopicture = new GoPicture();

	public SHSZInstantInfo getData() {
		return data;
	}

	public void setData(SHSZInstantInfo data) {
		this.data = data;
	}

	public DaPanData getDapandata() {
		return dapandata;
	}

	public void setDapandata(DaPanData dapandata) {
		this.dapandata = dapandata;
	}

	public GoPicture getGopicture() {
		return gopicture;
	}

	public void setGopicture(GoPicture gopicture) {
		this.gopicture = gopicture;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SHSZInstanceJsonObject [data=" + data + ", dapandata=" + dapandata + ", gopicture=" + gopicture + "]";
	}

}

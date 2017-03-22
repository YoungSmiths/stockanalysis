package cn.dev.youngsmith.stockanalysis.juhe.bean.shsz;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SHSZInstanceJsonObject implements Serializable {
	private static final long serialVersionUID = -743256943932982709L;
	Map<String, Object> map = new HashMap<String, Object>();

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public SHSZInstanceJsonObject() {
		// TODO Auto-generated constructor stub
		map.put("data", new SHSZInstantInfo());
		map.put("dapandata", new DaPanData());
		map.put("gopicture", new GoPicture());
	}

	@Override
	public String toString() {
		return "SHSZInstanceJsonObject [map=" + map + "]";
	}

}

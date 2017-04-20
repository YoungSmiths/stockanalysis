package cn.dev.youngsmith.stockanalysis.dao.impl;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.transaction.Transactional;

import cn.dev.youngsmith.stockanalysis.juhe.bean.shsz.SHSZInstantInfo;

@SessionScoped
@Transactional
public class SHSZInstantDaoImpl extends GeneralDaoImpl implements Serializable {
	private static final long serialVersionUID = -6000662134415315436L;

	public void save(SHSZInstantInfo shszInstantInfo) {

	}
}

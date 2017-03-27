package com.chanjet.qm.service;

import java.util.List;

import com.chanjet.qm.beans.Goods;

/**
 * 商品业务接口
 *
 */
public interface IGoodsService {

	//分页
	List<Goods> getGoodsPager(int pageNO, int size);

	//获得单个商品对象
	Goods getGoodsById(int id);
	
	//获得商品总数
	int getGoodsCount();

	//添加
	int insert(Goods entity);

	//删除单个
	int delete(int id);

	//删除多个
	int deletes(int[] ids);

	//更新
	int update(Goods entity);

}
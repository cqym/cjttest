package com.chanjet.qm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chanjet.qm.beans.Goods;
import com.chanjet.qm.mapper.GoodsMapper;
import com.chanjet.qm.service.IGoodsService;

/**
 * 商品业务实现
 * 
 */
//自动添加到Spring容器中
@Service
public class GoodsServiceImpl implements IGoodsService{
	//自动装配
	@Resource
	GoodsMapper goodsdao;
	
	//分页

	public List<Goods> getGoodsPager(int pageNO, int size) {
		int skip=(pageNO-1)*size;
		return goodsdao.getGoodsPager(skip, size);
	}

	//获得单个产品对象
	public Goods getGoodsById(int id) {
		return goodsdao.getGoodsById(id);
	}
	
	//获得商品总数
	public int getGoodsCount() {
		return goodsdao.getGoodsCount();
	}

	//添加
	public int insert(Goods entity) {
		return goodsdao.insert(entity);
	}

	//删除单个

	public int delete(int id) {
		return goodsdao.delete(id);
	}
	
	//删除多个
	public int deletes(int[] ids) {
		int rows=0;
		for (int id : ids) {
			rows+=delete(id);
		}
		return rows;
	}

	//更新
	public int update(Goods entity) {
		return goodsdao.update(entity);
	}

}

package com.chanjet.qm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chanjet.qm.beans.UserBean;
import com.chanjet.qm.mapper.UserMapper;
import com.chanjet.qm.service.IUserService;
import com.chanjet.qm.util.BeanUtil;
import com.chanjet.qm.util.PagedResult;
import com.github.pagehelper.PageHelper;


/**
 * 功能概要：UserService实现类
 * 
 * @author linbingwen
 * @since  2015年9月28日 
 */
@Service
public class UserServiceImpl implements IUserService{
	@Resource
	private UserMapper userDao;

	public UserBean selectUserById(Integer userId) {
		return userDao.selectUserById(userId);
		
	}

	public List<UserBean> selectUserByUserName(String userName) {
		List<UserBean> list = userDao.selectUserByUserName(userName);
		return list;
	}

	public PagedResult<UserBean> queryByPage(String userName,Integer pageNo,Integer pageSize ) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		return BeanUtil.toPagedResult(userDao.selectUserByUserName(userName));
	}

}

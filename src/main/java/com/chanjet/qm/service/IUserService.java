package com.chanjet.qm.service;

import java.util.List;

import com.chanjet.qm.beans.UserBean;
import com.chanjet.qm.util.PagedResult;



/**
 * 功能概要：UserService接口类
 * 
 * @author linbingwen
 * @since  2015年9月28日 
 */
public interface IUserService {
	
	UserBean selectUserById(Integer userId);
	
	List<UserBean> selectUserByUserName(String userName);
	
	/**
	 * 
	 * @author linbingwen
	 * @since  2015年10月23日 
	 * @param userName 查询条件，可为空
	 * @param pageNo 查询条件，可为空，默认取1
	 * @param pageSize 查询条件，可为空，默认取10
	 * @return
	 */
	PagedResult<UserBean> queryByPage(String userName,Integer pageNo,Integer pageSize);

}

package com.chanjet.qm.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chanjet.qm.beans.UserBean;


/**
 * 功能概要：User的DAO类
 * 
 * @author linbingwen
 * @since 2015年9月28日
 */
public interface UserMapper {
	
	/**
	 * 
	 * @author linbingwen
	 * @since 2015年9月28日
	 * @param userId
	 * @return
	 */
	 UserBean selectUserById(Integer userId);
	
	 /**
	  * 
	  * @author linbingwen
	  * @since  2015年10月22日 
	  * @param userName
	  * @return
	  */
	 List<UserBean> selectUserByUserName(@Param("userName") String userName);
	 
	 

}

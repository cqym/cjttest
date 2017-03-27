package com.chanjet.qm.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chanjet.qm.beans.TempletBean;


public interface TempletMapper {
	
    /**
     * 插入模板
     * @param module
     * @return
     * @throws Exception
     */
	@Insert("insert into ss_module(id,name,module_type,request,response,create_date,update_date,user_id,discription) " +
                            " value (null,#{module.name},#{module.clientType},#{module.request},#{module.response},#{module.createDate},#{module.updateDate},#{module.userId},#{module.discription})")
	@Options(useGeneratedKeys=true,keyProperty="module.id")
	public TempletBean insertModule(@Param("module")TempletBean module) throws Exception;
	
	/**
	 * 根据模板id修改模板
	 * @param module
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Update(" update ss_module set title=#{module.title},client_type=#{module.module_type},request=#{module.request},response=#{module.response},create_date=#{module.create_date},update_date=#{module.update_date},user_id=#{module.user_id},discription=#{module.discription} where id=#{id}")
	        
    public TempletBean updateModule (@Param("module")TempletBean module,@Param("id")long id) throws Exception;
	
     /**
      * 根据模板id删除模板
      * @param id
      * @return
      * @throws Exception
      */
	@Delete(" delete from ss_module where id=#{id}  ")
    public int deleteModule(long id) throws Exception;
	
	 /**
     * @param id
     * @return
     * @throws Exception
     */
    
    @Select(" select * from ss_module where id=#{id}")
    @Results({
        
        @Result(id=true,property="id",column="id",javaType=Long.class),
        @Result(property="clientType",column="module_type",javaType=String.class),
        @Result(property="request",column="request",javaType=String.class),
        @Result(property="response",column="account",javaType=String.class),
        @Result(property="createDate",column="create_date",javaType=Date.class),
        @Result(property="updateDate",column="update_date",javaType=Date.class),
        @Result(property="discription",column="discription",javaType=String.class),
        @Result(property="userId",column="user_id",javaType=Long.class)
    })
    public TempletBean getModuleById(long id) throws Exception;

    @Select(" select * from ss_module")
    @Results({
        
        @Result(id=true,property="id",column="id",javaType=Long.class),
        @Result(property="clientType",column="module_type",javaType=String.class),
        @Result(property="request",column="request",javaType=String.class),
        @Result(property="response",column="account",javaType=String.class),
        @Result(property="createDate",column="create_date",javaType=Date.class),
        @Result(property="updateDate",column="update_date",javaType=Date.class),
        @Result(property="discription",column="discription",javaType=String.class),
        @Result(property="userId",column="user_id",javaType=Long.class)
    })
    public List<TempletBean> getAllModules();
   
    public List<TempletBean> findModuleByCodition() throws Exception;

//    List<TempletBean> getModuleByPage(int skip, int take);
    @Select(" select count(1) from ss_module")
    int getAllModuleCount();

    List<TempletBean> getModuleByPage(Map map);
}

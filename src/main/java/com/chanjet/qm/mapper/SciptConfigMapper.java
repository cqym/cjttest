package com.chanjet.qm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chanjet.qm.beans.SciptConfigBean;
import com.chanjet.qm.beans.TempletBean;

public interface SciptConfigMapper {

    /** 插入配置脚本
     * 
     * @param sciptconfig
     * @return
     * @throws Exception */
    @Insert("insert into ss_sciptconfig value (null,sciptconfig.order_num,sciptconfig.step_name,sciptconfig.step_desc,sciptconfig.req_params,sciptconfig.rsp_params,sciptconfig.rele_params,sciptconfig.templ_id,sciptconfig.req_info)")
    @Options(useGeneratedKeys = true, keyProperty = "sciptconfig.id")
    public int insertsciptconfig(@Param("sciptconfig") TempletBean sciptconfig) throws Exception;

    /** 根据id修改配置脚本
     * 
     * @param sciptconfig
     * @param id
     * @return
     * @throws Exception */
    @Update(" update ss_sciptconfig set order_num=#{sciptconfig.order_num},step_name=#{sciptconfig.step_name},step_desc=#{sciptconfig.step_desc},req_params=#{sciptconfig.req_params},rsp_params=#{sciptconfig.rsp_params},rele_params=#{sciptconfig.rele_params},templ_id=#{sciptconfig.templ_id},req_info=#{sciptconfig.req_info} where id=#{id}")
    public int updatesciptconfig(@Param("sciptconfig") TempletBean sciptconfig, @Param("id") long id) throws Exception;

    /** 根据用例id删除配置脚本
     * 
     * @param id
     * @return
     * @throws Exception */
    @Delete(" delete from ss_sciptconfig where id=#{id}  ")
    public int deletesciptconfig(long id) throws Exception;



    @Select("select * from ss_sciptconfig where id=#{id} ")
    @Results({

    @Result(id = true, property = "id", column = "id", javaType = Long.class), 
            @Result(property = "orderNum", column = "order_num", javaType = String.class),
            @Result(property = "stepName", column = "step_name", javaType = String.class),
            @Result(property = "stepDesc", column = "step_desc", javaType = String.class),
            @Result(property = "reqParams", column = "req_params", javaType = String.class),
            @Result(property = "rspParams", column = "rsp_params", javaType = String.class),
            @Result(property = "releParams", column = "rele_params", javaType = String.class),
            @Result(property = "templId", column = "templ_id", javaType = Long.class),
            @Result(property = "reqInfo", column = "req_info", javaType = String.class)

    })
    public List<SciptConfigBean> getSciptConfigById(long id) throws Exception;
    
    public List<SciptConfigBean> findsciptconfigByCodition(String stepName) throws Exception;

}

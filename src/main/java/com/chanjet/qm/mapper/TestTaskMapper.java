package com.chanjet.qm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chanjet.qm.beans.TestTaskBean;



public interface TestTaskMapper {

    /** @param caseId
     * @return
     * @throws Exception */
    @Select("select * from ss_version_task where id=#{taskId} ")
    @Results({

    @Result(id = true, 
            property = "id", column = "id", javaType = Long.class), 
            @Result(property = "taskName", column = "task_name", javaType = String.class),
            @Result(property = "taskNo", column = "task_no", javaType = String.class),
            @Result(property = "parentId", column = "parent_id", javaType = Long.class),
            @Result(property = "leaf", column = "leaf", javaType = Boolean.class),
            @Result(property = "taskDisc", column = "task_disc", javaType = String.class),
            @Result(property = "userId", column = "user_id", javaType = Long.class),
            @Result(property = "createDate", column = "create_date", javaType = Date.class),
            @Result(property = "update_date", column = "update_date", javaType = Date.class),
            @Result(property = "status", column = "status", javaType = Boolean.class)

    })
    public TestTaskBean getTaskInfoById(@Param("taskId") long caseId);

    /** 
     * @param user
     * @return
     * @throws Exception */
    @Insert("insert into ss_version_task value (null,'id','task_name','parent_id', 'leaf', 'task_disc', 'user_id', 'create_date', 'update_date',  'task_no', 'status')")
    @Options(useGeneratedKeys = true, keyProperty = "testtask.id")
    public long insertTask(@Param("testtask") TestTaskBean testtask) throws Exception;


    /**
     * 根据caseId修改用例信息
     * @param testtask
     * @param taskId
     * @return
     * @throws Exception
     */
    @Update(" update ss_version_task set task_name=#{testtask.task_name},parent_id=#{testtask.parent_id},leaf=#{testtask.leaf} ,task_disc=#{testtask.task_disc} , create_date=#{testtask.create_date} , update_date=#{testtask.update_date}, user_id=#{testtask.user_id} ,task_no=#{testtask.task_no},status=#{testtask.status}  where id=#{caseId}")
    public long updateTask(@Param("testtask") TestTaskBean testtask, @Param("id") long caseId) throws Exception;

    /** 
     * 根据caseId修改刪除用例信息
     * @param caseId
     * @return
     * @throws Exception */
    @Delete(" delete from ss_version_task where id=#{caseId}  ")
    public long deleteTask(long caseId) throws Exception;

    /**
     * 根据parentId查询所有用例信息
     * @param parentId
     * @return
     */
    @Select("select * from ss_version_task where parent_id=#{parentId} ")
    @Results({
        @Result(id = true, 
                property = "id", column = "id", javaType = Long.class), 
                @Result(property = "taskName", column = "task_name", javaType = String.class),
                @Result(property = "taskNo", column = "task_no", javaType = String.class),
                @Result(property = "parentId", column = "parent_id", javaType = Long.class),
                @Result(property = "leaf", column = "leaf", javaType = Boolean.class),
                @Result(property = "taskDisc", column = "task_disc", javaType = String.class),
                @Result(property = "userId", column = "user_id", javaType = Long.class),
                @Result(property = "createDate", column = "create_date", javaType = Date.class),
                @Result(property = "update_date", column = "update_date", javaType = Date.class),
                @Result(property = "status", column = "status", javaType = Boolean.class)

        })
    public List<TestTaskBean> getTaskInfoByPId(@Param("parentId") long parentId); 
    
    /**
     * 根据name查询所有用例信息
     * @param caseName
     * @return
     */
    @Select("select * from ss_version_task where text=#{taskName} ")
    @Results({
        @Result(id = true, 
                property = "id", column = "id", javaType = Long.class), 
                @Result(property = "taskName", column = "task_name", javaType = String.class),
                @Result(property = "taskNo", column = "task_no", javaType = String.class),
                @Result(property = "parentId", column = "parent_id", javaType = Long.class),
                @Result(property = "leaf", column = "leaf", javaType = Boolean.class),
                @Result(property = "taskDisc", column = "task_disc", javaType = String.class),
                @Result(property = "userId", column = "user_id", javaType = Long.class),
                @Result(property = "createDate", column = "create_date", javaType = Date.class),
                @Result(property = "update_date", column = "update_date", javaType = Date.class),
                @Result(property = "status", column = "status", javaType = Boolean.class)

        })
    public List<TestTaskBean> findTaskInfoByName(@Param("taskName") String  caseName); 
   
}

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

import com.chanjet.qm.beans.TestCaseBean;

public interface TestCaseMapper {

    /** @param caseId
     * @return
     * @throws Exception */
    @Select("select * from ss_case where id=#{caseId} ")
    @Results({

    @Result(id = true, 
            property = "id", column = "id", javaType = Long.class), 
            @Result(property = "caseName", column = "case_name", javaType = String.class),
            @Result(property = "parentId", column = "parent_id", javaType = Long.class),
            @Result(property = "caseDisc", column = "case_disc", javaType = String.class),
            @Result(property = "userId", column = "user_id", javaType = Long.class),
            @Result(property = "createDate", column = "create_date", javaType = Date.class),
            @Result(property = "update_date", column = "update_date", javaType = Date.class),
            @Result(property = "priority", column = "priority", javaType = Long.class),
            @Result(property = "caseId", column = "scipt_id", javaType = Long.class),
            @Result(property = "caseNo", column = "case_no", javaType = String.class),
            @Result(property = "leaf", column = "leaf", javaType = Boolean.class)

    })
    public TestCaseBean getCaseInfoById(@Param("caseId") long caseId);

    /** 
     * @param user
     * @return
     * @throws Exception */
    @Insert("insert into ss_case value (null,testcase.case_name,testcase.parent_id, testcase.case_disc,testcase.user_id, testcase.create_date, testcase.update_date,testcase.priority, testcase.scipt_id,  testcase.case_no,leaf)")
    @Options(useGeneratedKeys = true, keyProperty = "testcase.id")
    public long insertCase(@Param("testcase") TestCaseBean testCase) throws Exception;


    /**
     * 根据caseId修改用例信息
     * @param testCase
     * @param caseId
     * @return
     * @throws Exception
     */
    @Update(" update ss_case set case_name=#{testcase.case_name},parent_id=#{testcase.parent_id},case_disc=#{testcase.case_disc} , create_date=#{testcase.create_date} , update_date=#{testcase.update_date}, user_id=#{testcase.user_id} ,case_no=#{testcase.case_no},priority=#{testcase.priority} ,leaf=#{testcase.leaf},scipt_id=#{testcase.scipt_id} where id=#{caseId}")
    public long updateCase(@Param("testcase") TestCaseBean testCase, @Param("id") long caseId) throws Exception;

    /** 
     * 根据caseId修改刪除用例信息
     * @param caseId
     * @return
     * @throws Exception */
    @Delete(" delete from ss_case where id=#{caseId}  ")
    public long deleteCase(long caseId) throws Exception;

    /**
     * 根据parentId查询所有用例信息
     * @param parentId
     * @return
     */
    @Select("select * from ss_case where parent_id=#{parentId} ")
    @Results({

        @Result(id = true, 
                property = "id", column = "id", javaType = Long.class), 
                @Result(property = "caseName", column = "case_name", javaType = String.class),
                @Result(property = "parentId", column = "parent_id", javaType = Long.class),
                @Result(property = "caseDisc", column = "case_disc", javaType = String.class),
                @Result(property = "userId", column = "user_id", javaType = Long.class),
                @Result(property = "createDate", column = "create_date", javaType = Date.class),
                @Result(property = "update_date", column = "update_date", javaType = Date.class),
                @Result(property = "priority", column = "priority", javaType = Long.class),
                @Result(property = "caseId", column = "scipt_id", javaType = Long.class),
                @Result(property = "caseNo", column = "case_no", javaType = String.class),
                @Result(property = "leaf", column = "leaf", javaType = Boolean.class)

        })
    public List<TestCaseBean> getCaseInfoByPId(@Param("parentId") long parentId); 
    
    /**
     * 根据name查询所有用例信息
     * @param caseName
     * @return
     */
    @Select("select * from ss_case where text=#{caseName} ")
    @Results({

        @Result(id = true, 
                property = "id", column = "id", javaType = Long.class), 
                @Result(property = "caseName", column = "case_name", javaType = String.class),
                @Result(property = "parentId", column = "parent_id", javaType = Long.class),
                @Result(property = "caseDisc", column = "case_disc", javaType = String.class),
                @Result(property = "userId", column = "user_id", javaType = Long.class),
                @Result(property = "createDate", column = "create_date", javaType = Date.class),
                @Result(property = "update_date", column = "update_date", javaType = Date.class),
                @Result(property = "priority", column = "priority", javaType = Long.class),
                @Result(property = "caseId", column = "scipt_id", javaType = Long.class),
                @Result(property = "caseNo", column = "case_no", javaType = String.class),
                @Result(property = "leaf", column = "leaf", javaType = Boolean.class)

        })
    public List<TestCaseBean> findCaseInfoByName(@Param("caseName") String  caseName); 
   
}

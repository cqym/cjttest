package com.chanjet.qm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.chanjet.qm.beans.Node;

/**
 * Created by songtao on 24/3/17.
 */
public interface NodeMapper {
    @Select("SELECT TreeID,ID, PID, OrderID, Obsolete, Name FROM tree_nodes WHERE TreeID = #{TreeID}   ORDER BY PID, OrderID ASC;")
    @Results({
            @Result(column="ID",property="iD",javaType = Integer.class),
            @Result(column="TreeID",property="treeID",javaType = Integer.class),
                    @Result(column="PID",property="pID",javaType = Integer.class),
                    @Result(column="OrderID",property="orderID",javaType = Integer.class),
                    @Result(column="Obsolete",property="obsolete",javaType = Integer.class),
                    @Result(column="Name",property="name",javaType = String.class)

    })
    List<Node> getNodesByTreeID(Map<String, Object> paramMap);
}

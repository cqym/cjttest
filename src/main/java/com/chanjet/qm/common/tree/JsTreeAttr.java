package com.chanjet.qm.common.tree;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 */
public class JsTreeAttr {

    //jackjson自定义属性名
    @JsonProperty(value = "class")
    //Gson 自定义属性名
    @SerializedName("class")
    private String klass;

    public final String getKlass() {
        return klass;
    }

    public final void setKlass(String value) {
        klass = value;
    }
}

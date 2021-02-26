package com.wangxl.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JsonData
 * @Description : 返回结果
 *
 * @Author : Wangxl
 * @Date : 2021/2/25 16:10
*/
@Data
public class JsonData {

    private boolean ret;

    private String msg;

    private Object data;

    public JsonData(boolean ret){
        this.ret = ret;
    }

    public static JsonData success(Object object,String msg){
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }
    public static JsonData success(Object object){
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        return jsonData;
    }

    public static JsonData fail(String msg){
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }
    public Map<String,Object> toMap(){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("ret",ret);
        resultMap.put("msg",msg);
        resultMap.put("data",data);
        return resultMap;
    }
}

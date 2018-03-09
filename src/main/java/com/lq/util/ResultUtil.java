package com.lq.util;


import com.alibaba.fastjson.JSON;
import com.lq.bean.Result;

public class ResultUtil {
    public static Object success(Object object){
        Result result=new Result(null);
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return JSON.toJSON(result);
    }

    public static Object success(){
        return success(null);
    }

    public static Object error(){
        Result result=new Result(null);
        result.setCode(1);
        result.setMsg("失败");
        return JSON.toJSON(result);
    }

}

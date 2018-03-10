package com.lq.util

import com.alibaba.fastjson.JSON
import com.lq.bean.Result
/**
 * Created by LiQian_Nice on 2018/3/9
 *
 * kotlin中的静态方法类
 */
object ResultUtil{

    /**
     * ResultUtil.INSTANCE.success(messageList)
     * Kotlin中为Any 等于 java中的Object
     */
    fun success(data:Any,code:Int,msg:String): Any? {
        var result = Result(data)
        result.msg = msg
        result.code = code
        return JSON.toJSON(result)
    }
}


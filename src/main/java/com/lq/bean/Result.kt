package com.lq.bean

/**
 * Created by LiQian_Nice on 2018/3/9
 *
 * Kotlin泛型实体类
 */
class Result<D>(d:D) {

    /**错误码*/
    var code:Int=0

    /**提示信息**/
    var msg:String=""

    /**具体的内容**/
    var data=d







}
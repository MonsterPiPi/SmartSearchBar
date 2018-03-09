package com.lq.bean


/**
 * Created by LiQian_Nice on 2018/3/9
 *
 * 历史搜索记录表
 */
class HistoryRecord{

    var id:String=""
    var command:String=""
    var createTime:String=""

    //类似java的构造方法
    constructor(id:String,command:String,createTime:String){
        this.id=id
        this.command=command
        this.createTime=createTime
    }

    //类似java的构造方法
    constructor(){
        id=""
        command=""
        createTime=""
    }
}
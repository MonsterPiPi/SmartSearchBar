package com.lq.bean


/**
 * Created by LiQian_Nice on 2018/3/9
 *
 * 历史搜索记录表
 */
class HistoryRecord{

    var id:String=""
    var command:String=""
    var createtime:String=""

    //类似java的构造方法
    constructor(id:String,command:String,createtime:String){
        this.id=id
        this.command=command
        this.createtime=createtime
    }

    //类似java的构造方法
    constructor(){
        id=""
        command=""
        createtime=""
    }
}
package com.lq.bean

/**
 * Created by LiQian_Nice on 2018/3/9
 *
 */
class Message{

    //类似java的成员变量
    var id : String=""
    var command: String=""

    //类似java的构造方法
    constructor(id:String,command:String){
        this.id=id
        this.command=command
    }

    //类似java的构造方法
    constructor(){
        id=""
        command=""
    }


}
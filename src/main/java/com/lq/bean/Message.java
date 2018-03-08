package com.lq.bean;

/**
 * Created by LiQian_Nice on 2018/3/8
 *
 * 与消息表对应的实体类
 */
public class Message {

    /**
     * 主键
     */
    private int id;
    /**
     * 指令名称
     */
    private String command;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }



}

package com.xiaoba.controller;

import com.xiaoba.entity.Message;
import com.xiaoba.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author zhouning
 */
@Api(tags = "消息接口")
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @ApiOperation(value = "接收系统消息")
    @GetMapping("/sysMessage")
    public Object sysMessage(){
        return messageService.sysMessage();
    }

    @ApiOperation(value = "发送系统消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queueName",value = "队列名字"),
            @ApiImplicitParam(name = "content",value = "内容"),
    })
    @GetMapping("/sendMessage")
    public boolean sendMessage(String queueName,String content){
        return messageService.sendMessage(queueName,content);
    }

    @ApiOperation(value = "创建消息队列")
    @ApiImplicitParam(name = "queueName",value = "队列名字")
    @GetMapping("/creatQueue")
    public boolean creatQueue(String queueName){
        return messageService.createQueue(queueName);
    }

    @ApiOperation(value = "接收个人消息")
    @ApiImplicitParam(name = "queueName",value = "队列名字")
    @GetMapping("/receiveMessage")
    public Object receiveMessage(String queueName){
        return messageService.receiveMessage(queueName);
    }

    @ApiOperation(value = "接收个人已读消息从数据库")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "receiver",value = "接收者"),
            @ApiImplicitParam(name = "pageIndex",value = "页面")
    })
    @GetMapping("/receiveReadMsg")
    public List<Message> receiveReadMsg(String receiver,int pageIndex){
        return messageService.receiveReadMsg(receiver, pageIndex);
    }

    @ApiOperation(value = "已读消息消息的数量")
    @ApiImplicitParam(name = "receiver",value = "接收者")
    @GetMapping("/countOfReadMsg")
    public int countOfReadMsg(String receiver){
        return messageService.countOfReadMsg(receiver);
    }

    @ApiOperation(value = "接收个人未读消息从数据库")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "receiver",value = "接收者"),
            @ApiImplicitParam(name = "pageIndex",value = "页面")
    })
    @GetMapping("/receiveUnReadMsg")
    public List<Message> receiveUnReadMsg(String receiver,int pageIndex){
        return messageService.receiveUnReadMsg(receiver, pageIndex);
    }

    @ApiOperation(value = "未读消息消息的数量")
    @ApiImplicitParam(name = "receiver",value = "接收者")
    @GetMapping("/countOfUnReadMsg")
    public int countOfUnReadMsg(String receiver){
        return messageService.countOfUnReadMsg(receiver);
    }
}

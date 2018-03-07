package com.jk.controller;

import com.jk.model.log.LogBean;
import com.jk.pool.ThreadPool;
import com.jk.service.login.LogThread;
import com.jk.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    /**
     *
     * @param loginnumber
     * @param password
     * @return
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public Boolean login(String loginnumber,String password){

        //假设登陆成功了
        LogBean logBean = new LogBean();
        logBean.setIp("127.0.0.1");
        logBean.setIpAddress("中国");
        logBean.setLog("登陆日志"+ UUID.randomUUID().toString());
        logBean.setLogTime(new Date());
        logBean.setName("login");
        logBean.setRequestMsg("loginnumber="+loginnumber+"password="+password);
        logBean.setResponseMsg("{'loginnumber':'admin','password':'admin'}");
        ThreadPool.executor(new LogThread(loginService,logBean));
        return true;
    }
}

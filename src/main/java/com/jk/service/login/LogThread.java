package com.jk.service.login;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.log.LogBean;

public class LogThread implements Runnable {
    private LoginService loginService;
    private LogBean logBean;
    @Override
    public void run() {
        String log = JSONObject.toJSONString(logBean);
        loginService.saveLog(log);
    }

    public LogThread() {
    }

    public LogThread(LoginService loginService, LogBean logBean) {
        this.loginService = loginService;
        this.logBean = logBean;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public LogBean getLogBean() {
        return logBean;
    }

    public void setLogBean(LogBean logBean) {
        this.logBean = logBean;
    }
}

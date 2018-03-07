package com.jk.service.login;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class LoginServiceHystric implements LoginService {
    @Override
    public void saveLog(String log) {
        System.out.println("日志微服务挂了，短路器启用了。");
    }
}

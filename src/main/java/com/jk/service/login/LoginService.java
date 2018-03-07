package com.jk.service.login;

import com.jk.model.log.LogBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider-log",fallback = LoginServiceHystric.class)
@Component
public interface LoginService {

    @RequestMapping("/log/saveLog")
    void saveLog(@RequestParam(value = "log") String log);
}

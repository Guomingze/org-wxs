package cn.wxs.controller;

import cn.business.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Entrance")
public class Entrance {

    @Autowired
    private Login logins;

    @ResponseBody
    @RequestMapping("/login")
    public String login(String code){
        return logins.login(code);
    }
}

package cn.business;

import cn.util.OpenIdBycode;
import cn.wxs.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Login {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OpenIdBycode openIdBycode;

    public String login(String code){
        String openid = openIdBycode.getOpenid(code);

        return null;
    }
}

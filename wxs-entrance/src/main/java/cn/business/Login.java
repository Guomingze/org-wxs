package cn.business;

import cn.util.OpenIdBycode;
import cn.wxs.dao.UserDao;
import cn.wxs.pojo.User;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Login {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OpenIdBycode openIdBycode;

    public String login(String code){
        if("".equals(code) || code.length() < 5 ){
            return "code不正确";
        }
        String openid = openIdBycode.getOpenid(code);
        if(openid == null){
            return "code过期或无效";
        }
        User user = new User();
        user.setUpwd(openid);
        List<User> users = userDao.allUser(user);
        if(users != null){
            return JSON.toJSONString(users);
        }else{
            return "登录失败";
        }
    }
}

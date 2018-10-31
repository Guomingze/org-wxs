package cn.business;

import cn.util.OpenIdBycode;
import cn.util.RandomStr;
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
            User user1 = users.get(0);
            user1.setUpwd(null);
            user1.setUphone(null);
            return JSON.toJSONString(user1);
        }else{
            User user1 = new User();
            user1.setUpwd(openid);
            user1.setUname(RandomStr.getRandomString(5));
            int count = userDao.addUser(user1);
            if(count < 0){
                return "登录失败，请重试";
            }
            user1.setUpwd(openid);
            user1 = userDao.allUser(user1).get(0);
            user1.setUpwd(null);
            return JSON.toJSONString(user1);
        }
    }
}

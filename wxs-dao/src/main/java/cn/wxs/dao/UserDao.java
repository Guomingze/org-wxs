package cn.wxs.dao;

import cn.wxs.pojo.User;

import java.util.List;

public interface UserDao {
    /**
     * 动态查询用户
     * @param user 用户实体类
     * @return 查询到的用户
     */
    List<User> allUser(User user);

    /**
     * 添加一个新用户
     * @param user
     * @return 受影响行数
     */
    int addUser(User user);

    /**
     * 根据用户Id修改用户信息
     * @param user 用户信息
     * @return 受影响行数
     */
    int updateUser(User user);
}

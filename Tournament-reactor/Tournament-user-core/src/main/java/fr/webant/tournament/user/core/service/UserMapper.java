/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.webant.tournament.user.core.service;

import fr.webant.tournament.user.core.dto.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.javalite.activejdbc.LazyList;

/**
 *
 * @author anthony
 */
class UserMapper {

    public static UserModel toModel(User user) {
        Map<String,Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("firstname", user.getFirstname());
        map.put("lastname", user.getLastname());
        map.put("email", user.getEmail());
        return new UserModel().fromMap(map);
    }
    
    public static User toUser(UserModel model) {
        User user = new User();
        user.setId(model.getInteger("id"));
        user.setFirstname(model.getString("firstname"));
        user.setLastname(model.getString("lastname"));
        user.setEmail(model.getString("email"));
        return user;
    }
    
    public static List<User> toUserList(LazyList<UserModel> lazyList) {
        List<User> users = new ArrayList<>();
        lazyList.stream().forEach((model) -> users.add(toUser(model)));
        return users;
    }
}

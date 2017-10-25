/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.webant.tournament.user.core.service;

import fr.webant.tournament.user.core.dto.User;
import java.util.ArrayList;
import java.util.List;
import org.javalite.activejdbc.LazyList;

/**
 *
 * @author anthony
 */
class UserMapper {
    
    public static User toUser(UserModel model) {
        User user = new User();
        user.setId(model.getInteger("id"));
        user.setFirstname(model.getString("firstname"));
        user.setLastname(model.getString("lastname"));
        user.setEmail(model.getString("email"));
        user.setLogin(model.getString("login"));
        return user;
    }
    
    public static List<User> toUserList(LazyList<UserModel> lazyList) {
        List<User> users = new ArrayList<>();
        lazyList.stream().forEach((model) -> users.add(toUser(model)));
        return users;
    }
}

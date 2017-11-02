package fr.webant.tournament.user.core.service;

import fr.webant.tournament.user.core.dto.User;
import java.util.ArrayList;
import java.util.List;
import org.javalite.activejdbc.LazyList;

/**
 * @author anthony
 * Convert a JavaLite User model to a simple User
 * Used only by UserService
 * @See fr.webant.tournament.user.core.service.UserService
 */
class UserMapper {
    
    /**
     * Convert a UserModel to User
     * @param model JavaLite UserModel
     * @return a User
     * @see fr.webant.tournament.user.core.dto.User
     * @see fr.webant.tournament.user.core.dto.User
     */
    public static User toUser(UserModel model) {
        User user = new User();
        user.setId(model.getInteger("id"));
        user.setFirstname(model.getString("firstname"));
        user.setLastname(model.getString("lastname"));
        user.setEmail(model.getString("email"));
        user.setLogin(model.getString("login"));
        return user;
    }
    
    /**
     * Convert a UserModel's list to a User's list
     * @param lazyList UserModel's lit
     * @return a User's list
     */
    public static List<User> toUserList(LazyList<UserModel> lazyList) {
        List<User> users = new ArrayList<>();
        lazyList.stream().forEach((model) -> users.add(toUser(model)));
        return users;
    }
}

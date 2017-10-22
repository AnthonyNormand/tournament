package fr.webant.tournament.user.core.service;

import fr.webant.tournament.user.core.dto.User;
import java.util.List;
import javax.inject.Singleton;

/**
 *
 * @author anthony
 */
@Singleton
public class UserService {

    public List<User> findAll() {
        return UserMapper.toUserList(UserModel.findAll());
    }

    public User findUser(Integer userId) {
        return UserMapper.toUser(UserModel.findById(userId));
    }

    public User createUser(User user) {
        UserModel model = UserMapper.toModel(user);
        model.saveIt();
        return user; //todo not good
    }

    //todo pas logique de passer un user en parametre
    public User updateUser(User user) {
        UserModel model = UserMapper.toModel(user);
        model.saveIt();
        return user; //todo not good
    }

    public void deleteUser(Integer userId) {
        UserModel.findById(userId).delete();
    }

}

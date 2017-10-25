package fr.webant.tournament.user.core.service;

import fr.webant.tournament.user.core.dto.User;
import fr.webant.tournament.user.core.encryption.PasswordEncryptionUtil;
import java.util.List;
import javax.inject.Singleton;

/**
 *
 * @author anthony
 */
@Singleton
public class UserService {
    
    public boolean validateCredentials(String login, String password) {
        UserModel model = UserModel.findFirst("login = ?", login);
        if (model == null) return false;
        System.err.println(model.getString("salt"));
        String encodedPassword = PasswordEncryptionUtil.getSHA512SecurePassword(password, model.getString("salt"));
        System.err.println(encodedPassword);
        System.err.println(model.getString("password"));
        return encodedPassword.equals(model.getString("password"));
    }

    public List<User> findAll() {
        return UserMapper.toUserList(UserModel.findAll());
    }

    public User findUser(Integer userId) {
        return UserMapper.toUser(UserModel.findById(userId));
    }

    public User createUser(User user) {
        UserModel model = new UserModel();
        model.set("login", user.getLogin());
        model.set("lastname", user.getLastname());
        model.set("firstname", user.getFirstname());
        model.set("email", user.getEmail());
        model.set("salt", PasswordEncryptionUtil.getRandomSalt());
        model.set("password", PasswordEncryptionUtil.getSHA512SecurePassword(user.getPassword(), model.getString("salt")));
        model.saveIt();
        model.refresh();
        return UserMapper.toUser(model);
    }

    public User updateUser(User user) {
        UserModel model = UserModel.findById(user.getId());
        model.set("lastname", user.getLastname());
        model.set("firstname", user.getFirstname());
        model.set("email", user.getEmail());
        model.set("password", PasswordEncryptionUtil.getSHA512SecurePassword(user.getPassword(), model.getString("salt")));
        model.saveIt();
        model.refresh();
        return UserMapper.toUser(model);
    }

    public void deleteUser(Integer userId) {
        UserModel.findById(userId).delete();
    }

}

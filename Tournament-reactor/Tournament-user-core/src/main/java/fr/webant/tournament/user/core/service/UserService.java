package fr.webant.tournament.user.core.service;

import fr.webant.tournament.user.core.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;

/**
 *
 * @author anthony
 */
@Singleton
public class UserService {
    
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        return list;
    }
    
    public User findUser(Integer userId) {
        User user = new User();
        user.setFirstName("toto");
        return user;
    }
    
    public User createUser(User user) {
        return user;
    }
    
    public User updateUser(User user) {
        return user;
    }
   
    public void deleteUser(User user){
        
    }
}
package fr.webant.tournament.user.core.service;
import javax.inject.Inject;
import fr.webant.tournament.user.core.model.User;
import org.codejargon.feather.Feather;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 *
 * @author anthony
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class UserServiceTest {
    
    @Inject
    private UserService userService;
    
    @Before
    public void init() {
        Feather feather = Feather.with();
        userService = feather.instance(UserService.class);
    }
    
    
    @Test 
    public void testFindUser(){
        System.out.println(userService.findUser(123));
    }
}

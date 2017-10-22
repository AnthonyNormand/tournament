package fr.webant.tournament.user.core.service;
import javax.inject.Inject;
import org.codejargon.feather.Feather;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.dialects.PostgreSQLDialect;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
        //TODO not yet implemented
    }
}

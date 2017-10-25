package fr.webant.tournament.user.core.service;

import fr.webant.tournament.user.core.dto.User;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import static org.assertj.core.api.Assertions.assertThat;
import org.codejargon.feather.Feather;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.Spy;

/**
 *
 * @author anthony
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class UserServiceTest {

    @Spy
    private UserService userService;

    @Before
    public void init() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("database.properties");
        Properties p = new Properties();
        p.load(is);
        Flyway flyway = new Flyway();
        flyway.setDataSource(p.getProperty("development.url"), p.getProperty("development.username"), p.getProperty("development.password"));
        flyway.clean();
        flyway.migrate();
        Feather feather = Feather.with();
        userService = feather.instance(UserService.class);
    }

    @Test
    public void testValidCredentials() {
        assertThat(userService.validateCredentials("ANO", "ANO")).isEqualTo(true);
        assertThat(userService.validateCredentials("DRA", "DRA")).isEqualTo(true);
        assertThat(userService.validateCredentials("DRA", "ANO")).isEqualTo(false);
    }
    
    @Test
    public void testFindUsers(){
        List<User> users = userService.findAll();
        assertThat(users).isNotNull().hasSize(2);
        assertThat(users.get(0).getLogin()).isEqualTo("ANO");
    }
    
    @Test
    public void testCreateUser(){
        User user = new User();
        user.setLogin("TDO");
        user.setFirstname("Thierry");
        user.setLastname("Doucet");
        user.setPassword("jaimeleponey");
        user.setEmail("thierry.doucet@gmail.com");
        user = userService.createUser(user);
        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(3);
    }
}

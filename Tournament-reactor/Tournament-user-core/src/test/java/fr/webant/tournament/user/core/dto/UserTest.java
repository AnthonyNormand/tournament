package fr.webant.tournament.user.core.dto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @author anthony Test de la classe User, précence des champs (accessible via
 * GETTER/SETTER
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class UserTest { 
    
    
    /** Validate Getter and Setter */
    @Test
    public void testUser(){
        User user = new User();
        user.setEmail("antho.normand@gmail.com");
        user.setFirstname("anthony");
        user.setLastname("normand");
        user.setLogin("antho");
        user.setPassword("newPassword");
        
        assertThat(user.getEmail()).isEqualTo("antho.normand@gmail.com");
        assertThat(user.getLogin()).isEqualTo("antho");
        assertThat(user.getFirstname()).isEqualTo("anthony");
        assertThat(user.getLastname()).isEqualTo("normand");
        assertThat(user.getPassword()).isEqualTo("newPassword");
    }
    
    /**
     * Tests if two Users are equals. 
     * Two Users are equals if they had the same ID
     */
    @Test
    public void testEqualsAndHashcode(){
        User user1 = new User();
        user1.setId(1);
        
        User user2 = new User();
        user2.setId(1);
        
        User user3 = new User();
        user3.setId(2);
        
        /* Wihtout ID */
        User user4 = new User();
        
        /* Equals */
        assertThat(user1).isEqualTo(user1);
        assertThat(user1).isEqualTo(user2);
        assertThat(user1).isNotEqualTo(user3);
        assertThat(user2).isNotEqualTo(user3);
        assertThat(user1).isNotEqualTo(user4);
        assertThat(user3).isNotEqualTo(user4);
        assertThat((User)null).isNotEqualTo(user1);
        assertThat(user1).isNotEqualTo(null);
        assertThat(user1).isNotEqualTo("test");
        
        /* Hashcode */
        assertThat(user1.hashCode()).isEqualTo(user2.hashCode());
        assertThat(user1.hashCode()).isNotEqualTo(user3.hashCode());
        
        
    }

}

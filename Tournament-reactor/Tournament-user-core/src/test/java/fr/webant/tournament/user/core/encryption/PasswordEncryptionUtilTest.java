/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.webant.tournament.user.core.encryption;


import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

/**
 *
 * @author anthony
 */
public class PasswordEncryptionUtilTest {
  
    @Test
    public void testRandomSalt() {
        String salt = PasswordEncryptionUtil.generateRandomSalt();
        assertThat(salt).isNotNull();
        String salt2 = PasswordEncryptionUtil.generateRandomSalt();
        assertThat(salt2).isNotNull();
        assertThat(salt).isNotEqualTo(salt2);
    }
    
    @Test
    public void testRandomPassword() {
        String salt = PasswordEncryptionUtil.generateRandomSalt();
        String word = "default";
        String password = PasswordEncryptionUtil.hashPassword(word, salt);
        assertThat(password).isNotNull().isNotEqualTo(word);
        
        /* Same password*/
        String password2 = PasswordEncryptionUtil.hashPassword(word, salt);
        assertThat(password).isEqualTo(password2);
        
        /* Different word*/
        String password3 = PasswordEncryptionUtil.hashPassword("test2", salt);
        assertThat(password).isNotEqualTo(password3);
        
        /* Different salt*/
        salt = PasswordEncryptionUtil.generateRandomSalt();
        String password4 = PasswordEncryptionUtil.hashPassword(word, salt);
        assertThat(password).isNotEqualTo(password4);
    }
  
}

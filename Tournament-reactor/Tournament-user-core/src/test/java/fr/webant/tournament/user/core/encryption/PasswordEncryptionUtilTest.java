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
        String salt = PasswordEncryptionUtil.getRandomSalt();
        assertThat(salt).isNotNull();
        String salt2 = PasswordEncryptionUtil.getRandomSalt();
        assertThat(salt2).isNotNull();
        assertThat(salt).isNotEqualTo(salt2);
    }
    
    @Test
    public void testRandomPassword() {
        String salt = PasswordEncryptionUtil.getRandomSalt();
        String word = "default";
        String password = PasswordEncryptionUtil.getSHA512SecurePassword(word, salt);
        assertThat(password).isNotNull().isNotEqualTo(word);
        
        /* Same password*/
        String password2 = PasswordEncryptionUtil.getSHA512SecurePassword(word, salt);
        assertThat(password).isEqualTo(password2);
        
        /* Different word*/
        String password3 = PasswordEncryptionUtil.getSHA512SecurePassword("test2", salt);
        assertThat(password).isNotEqualTo(password3);
        
        /* Different salt*/
        salt = PasswordEncryptionUtil.getRandomSalt();
        String password4 = PasswordEncryptionUtil.getSHA512SecurePassword(word, salt);
        assertThat(password).isNotEqualTo(password4);
    }
  
}

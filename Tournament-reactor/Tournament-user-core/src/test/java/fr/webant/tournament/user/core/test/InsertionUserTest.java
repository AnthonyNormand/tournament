/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.webant.tournament.user.core.test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author anthony
 */
public class InsertionUserTest {
    
    
    public static void main(String[] args) {
        
        try {
            Random r = new Random(System.currentTimeMillis());
            String key = new String(r.longs(48).sum() + "");
            System.out.println("Random key : " + key);
            byte[] keyData = r.toString().getBytes();
            SecretKeySpec sks = new SecretKeySpec(keyData, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, sks);
            String inputText = "bellete";
            byte[] encrypted = cipher.doFinal(inputText.getBytes());
            System.out.println("Mot de passe encodé : " + encrypted.toString());
            cipher.init(Cipher.DECRYPT_MODE, sks);
            byte[] decrypted = cipher.doFinal(encrypted);
            System.out.println("Mot de passe décodé : " + new String(decrypted));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException  | BadPaddingException e) {
           throw new RuntimeException(e);
        
        }
    }
    
}

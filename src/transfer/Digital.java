/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

/**
 *
 * @author Raghav Saxena
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class Digital
{    
    public static void main(String [] args) throws Exception
    {
        // generate public and private keys
        KeyPair keyPair = buildKeyPair();
        PublicKey pubKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        
        // sign the message
        String h="Raghav is a good boy";
        byte[] p=h.getBytes();
        byte [] signed = encrypt(privateKey,p);     
        System.out.println(new String(signed));  // <<signed message>>
        
        // verify the message
        byte[] verified = decrypt(pubKey, signed);                                 
        System.out.println(new String(verified));     // This is a secret message
    }

    public static KeyPair buildKeyPair() throws NoSuchAlgorithmException
    {
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);      
        return keyPairGenerator.genKeyPair();
    }

    public static byte[] encrypt(PrivateKey privateKey, byte[] p) throws Exception
    {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);  

        return cipher.doFinal(p);  
    }
    
    public static byte[] decrypt(PublicKey publicKey, byte [] encrypted) throws Exception 
    {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        
        return cipher.doFinal(encrypted);
    }
}

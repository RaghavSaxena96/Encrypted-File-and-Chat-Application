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


import javax.swing.*;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random ;
public class DES {
static byte[] skey = new byte[1000];
static String skeyString;

static byte[] raw;

static String inputMessage,encryptedData,decryptedMessage;
public DES() {
try {
generateSymmetricKey();
}
catch(Exception e) {
System.out.println(e);
}

}
 

public static byte[] encryption(String message)
{
    


   String encrypteddata="";
   byte[] ibyte = message.getBytes();
   byte[] ebyte=new byte[1000000000];;
try
{
ebyte=encrypt(raw, ibyte);
}
catch(Exception e)
{
    System.out.println("Error yaha he");
    JOptionPane.showMessageDialog(null,e);
}
return ebyte;
}



public static String decryption(byte[] encrypt)
{
   String decrypteddata="";
  
   if(raw.length==0)
   {
       JOptionPane.showMessageDialog(null,"Pagal thi wo");
   }
try{
byte[] dbyte=decrypt(raw,encrypt);

decrypteddata = new String(dbyte);

}
catch(Exception e)
{
    JOptionPane.showMessageDialog(null,"Error yaha thi");
    JOptionPane.showMessageDialog(null,e);
}
return decrypteddata;
}




static void generateSymmetricKey() {
try {
Random r = new Random();
int num = r.nextInt(10000);
String knum = String.valueOf(num);
byte[] knumb = knum.getBytes();
skey=getRawKey(knumb);
skeyString = new String(skey);
System.out.println("DES Symmetric key = "+skeyString);
}
catch(Exception e) {
System.out.println(e);
}
}
public static byte[] getRawKey(byte[] seed) throws Exception {
KeyGenerator kgen = KeyGenerator.getInstance("DES");
SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
sr.setSeed(seed);
kgen.init(56, sr);
SecretKey skey = kgen.generateKey();
raw = skey.getEncoded();
return raw;
}
public static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
Cipher cipher = Cipher.getInstance("DES");
cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
byte[] encrypted = cipher.doFinal(clear);
return encrypted;
}

public static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
Cipher cipher = Cipher.getInstance("DES");
cipher.init(Cipher.DECRYPT_MODE, skeySpec);
byte[] decrypted = cipher.doFinal(encrypted);
return decrypted;
}
public static void main(String[] args)
{
    
   DES ob=new DES();
    
    String s="Raghav Got a good Job in goldman sachs";
    
    byte[] x=encryption(s);
    
    String g=decryption(x);
    System.out.println(raw);
    System.out.println(g);
    String f="5646";
    byte d[]=new byte[10000];
    try{
     d=getRawKey(f.getBytes());
    }
    catch(Exception e)
    {
        
    }
    System.out.println(d);
    
}
}


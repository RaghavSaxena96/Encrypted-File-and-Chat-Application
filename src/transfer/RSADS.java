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
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
 
public class RSADS
{
    private BigInteger p;
    private BigInteger q;
    private BigInteger N=new BigInteger("47879599771368128201894679114567480722263224884969731513869368622771059342011");
    private BigInteger phi;
    private BigInteger e=new BigInteger("13116807353294036417");
    private BigInteger d=new BigInteger("30531522691643793768108134516681418843757987155572369553785304584087331718049");
    private int        bitlength = 128;
    private Random     r;
 
    public RSADS()
    {
       
    }
 
    public RSADS(BigInteger e, BigInteger d, BigInteger N)
    {
        this.e = e;
        this.d = d;
        this.N = N;
    }
 
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException
    {
        RSADS rsa=new RSADS(); 
        DataInputStream in = new DataInputStream(System.in);
        String teststring;
        System.out.println("Enter the plain text:");
        teststring = in.readLine();
        System.out.println("Encrypting String: " + teststring);
        System.out.println("String in Bytes: "
                + bytesToString(teststring.getBytes()));
        // encrypt
        byte[] encrypted = rsa.encrypt(teststring.getBytes());
        // decrypt
        byte[] decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypting Bytes: " + bytesToString(decrypted));
        System.out.println("Decrypted String: " + new String(decrypted));
    }
 
    private static String bytesToString(byte[] encrypted)
    {
        String test = "";
        for (byte b : encrypted)
        {
            test += Byte.toString(b);
        }
        return test;
    }
 
    // Encrypt message
    public byte[] encrypt(byte[] message)
    {
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }
 
    // Decrypt message
    public byte[] decrypt(byte[] message)
    {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }
}
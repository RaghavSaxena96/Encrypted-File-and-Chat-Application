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
 
public class RSA2
{
    private BigInteger p;
    private BigInteger q;
    private BigInteger N=new BigInteger("84843496058131583758473664412854471812458004298126051558798456352693182175609");
    private BigInteger phi;
    private BigInteger e=new BigInteger("15133036136518194623");
    private BigInteger d=new BigInteger("82144437845786231241962200418791374123607769564119722896116356901719774028367");
    private int        bitlength = 128;
    private Random     r;
 
    public RSA2()
    {
        //r = new Random();
        //p = BigInteger.probablePrime(bitlength, r);
        //q = BigInteger.probablePrime(bitlength, r);
        //N = p.multiply(q);
        //phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        //e = BigInteger.probablePrime(bitlength / 2, r);
        //while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
        //{
          //  e.add(BigInteger.ONE);
        //}
        //d = e.modInverse(phi);
        //System.out.println("N is  "+N);
        //System.out.println("Encryption key is ..."+e);
        //System.out.println("Decryption key is....."+d);
    }
 
    public RSA2(BigInteger e, BigInteger d, BigInteger N)
    {
        this.e = e;
        this.d = d;
        this.N = N;
    }
 
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException
    {
        RSA2 rsa=new RSA2(); 
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
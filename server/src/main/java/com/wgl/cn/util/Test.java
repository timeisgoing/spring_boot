package com.wgl.cn.util;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-11 001116:55:14
 * #Version 1.0
 **/

public class Test {

  /*  public static byte[] encrypt(byte[] data, byte[] iv, byte[] key) {
        if (key.length != 16) {
            throw new RuntimeException("Invalid AES key length (must be 16 bytes)");
        } else {
            try {
                SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
                byte[] enCodeFormat = secretKey.getEncoded();
                SecretKeySpec seckey = new SecretKeySpec(enCodeFormat, "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                int blockSize = cipher.getBlockSize();
                int length = data.length;
                if (length % blockSize != 0) {
                    length = length + (blockSize - (length % blockSize));
                }
                byte[] plaintext = new byte[length];
                System.arraycopy(data, 0, plaintext, 0, data.length);
                IvParameterSpec ivSpec = new IvParameterSpec(iv);
                cipher.init(1, seckey, ivSpec);
                byte[] result = cipher.doFinal(plaintext);
                return result;
            } catch (Exception var9) {
                throw new RuntimeException("encrypt fail!", var9);
            }
        }
    }*/

/*    //public static void main(String[] args) throws Exception {
    //    //byte[] encrypt = encrypt("92426d82eff8a244".getBytes(), null, "ab797bb233ac7c00c01f9687dd143dfa".getBytes());
    //    String password = Encrypt.getMd5("Duowanyy123");
    //    System.out.println(password); //e8a6e3c392426d82eff8a244ae50d571
    //    String aesPassWord = Encrypt.getAesEncrypt(Encrypt.getMd5("Duowanyy123"), "ab797bb233ac7c00c01f9687dd143dfa");
    //    System.out.println(aesPassWord);//8ff402daa0e367bb02265b7cf9a3820135ac6c62e69df794ca6bd9a48f43f765
    //}*/


}

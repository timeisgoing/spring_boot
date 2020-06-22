package com.wgl.cn.util;
/*
 * 本示例由360网友 浩世凡夫 （http://bbs.360safe.com/home.php?mod=space&uid=10606016）友情提供
 * 只需传入,password 和 apiSecret ，即可获得AES 加密后的密文.
 * 经验证是可以访问clientLogin方法并且成功返回accessToken和sesseionToken的.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {
    /**
     *
     * @param s:要进行加密的字符串
     * @return  字符串的md5值
     */
    public static String getMd5(String s) {
        char hexChar[] = {'0', '1', '2', '3', '4', '5', '6',
                '7', '8' , '9', 'a', 'b', 'c', 'd', 'e', 'f','A', 'B', 'C', 'D', 'E', 'F'};
        //md5加密算法的加密对象为字符数组，这里是为了得到加密的对象
        byte[] b = s.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(b);
            byte[] b2 = md.digest();// 进行加密并返回字符数组
            char str[] = new char[b2.length << 1];
            int len = 0;
            //将字符数组转换成十六进制串，形成最终的密文
            for (int i = 0; i < b2.length; i++) {
                byte val = b2[i];
                str[len++] = hexChar[(val >>> 4) & 0xf];
                str[len++] = hexChar[val & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES 加密
     * 密钥是apiSecret 的前16位
     * 向量是apiSecret 的后16位
     * @param password
     * @param key
     * @param iv
     * @return
     * @throws Exception
     */
    public static String getAesEncrypt(String password,String apiSecret)throws Exception{
        String key = apiSecret.substring(0,16);
        String iv = apiSecret.substring(16);
        String md5Pass = getMd5(password);

        SecretKeySpec keyspec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes("UTF-8"));

        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
        byte[] encrypted = cipher.doFinal(md5Pass.getBytes("UTF-8"));

        return bytesToHexString(encrypted);
    }
    public static String bytesToHexString(byte[] bs) {
        StringBuffer sb = new StringBuffer();
        String hex = "";
        for (int i = 0; i < bs.length; i++) {
            hex = Integer.toHexString(bs[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}

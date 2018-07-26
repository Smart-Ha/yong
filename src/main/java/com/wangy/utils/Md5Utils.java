package com.wangy.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Md5Utils {

    private static final Logger log = LoggerFactory.getLogger(Md5Utils.class);

    /**
     * md5加密
     * @param s
     * @return
     */
    public static byte[] md5(String s) {
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(s.getBytes("UTF-8"));
            byte[] messageDigest = algorithm.digest();
            return messageDigest;
        } catch (Exception e) {
            log.error("MD5 Error...", e);
        }
        return null;
    }
    /**
     * 生成盐
     * @return
     */
    public static byte[] createSalt(){
        byte[] salt = new byte[16];
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.nextBytes(salt);
            return salt;
        } catch (NoSuchAlgorithmException e) {
            log.error("create salt Error...", e);
            return null;
        }
    }

    /**
     * 生成盐,获取盐
     * @return
     */
    public static String getSalt(){
        try {
            return new String(toHex(createSalt()).getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * byte 转 16进制
     * @param hash
     * @return
     */
    public static final String toHex(byte hash[]) {
        if (hash == null) {
            return null;
        }
        StringBuffer buf = new StringBuffer(hash.length * 2);
        int i;

        for (i = 0; i < hash.length; i++) {
            if ((hash[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString(hash[i] & 0xff, 16));
        }
        return buf.toString();
    }

    public static String hashWithSalt(String password,String salt) {
        return hash(password + salt);
    }

    public static String hash(String password) {
        try {
            return new String(toHex(md5(password)).getBytes("UTF-8"), "UTF-8");
        } catch (Exception e) {
            log.error("not supported charset...{}", e);
            return password;
        }
    }


}

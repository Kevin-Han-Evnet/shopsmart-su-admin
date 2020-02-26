package com.fiveone.shopsmart.suadmin.hash;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class KevinHash {

    /**
     * 랜덤한 문자열을 원하는 길이만큼 반환합니다.
     *
     * @param length 문자열 길이
     * @return 랜덤문자열
     */
    public static String getKeyString (int length) {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();

        String chars[] = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,1,2,3,4,5,6,7,8,9,0".split(",");

        for (int i=0 ; i<length ; i++) {
            buffer.append(chars[random.nextInt(chars.length)]);
        }
        return buffer.toString();
    }


    /**
     * 비밀번호 암호화
     * @return
     */
    public static String getHashedPassword (String key, String iv, String password_str) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {


        SecretKey keyspec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        AlgorithmParameterSpec ivspec = new IvParameterSpec(iv.getBytes("UTF-8"));


        //Encription
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
        int blockSize = cipher.getBlockSize();
        byte[] dataBytes = password_str.getBytes("UTF-8");


        //find fillChar & pad
        int plaintextLength = dataBytes.length;
        int fillChar = ((blockSize - (plaintextLength % blockSize)));

        if (plaintextLength % blockSize != 0) {
            plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
        }

        byte[] plaintext = new byte[plaintextLength];
        Arrays.fill(plaintext, (byte) fillChar);
        System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);



        byte[] cipherBytes = cipher.doFinal(plaintext);
        String afterCiphered = new String(Base64.getEncoder().encodeToString(cipherBytes));

        return afterCiphered;

    }


    /**
     * 비밀번호 복호화
     * @return
     */
    public static String getUnHashedPassword (String key, String iv, String hashed_pwd) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {


        SecretKey keyspec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        AlgorithmParameterSpec ivspec = new IvParameterSpec(iv.getBytes("UTF-8"));

        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);


        //Decription
        byte[] base64decoded = Base64.getDecoder().decode(hashed_pwd.getBytes("UTF-8"));
        byte[] aesdecode = cipher.doFinal(base64decoded);


        // unpad
        byte[] origin = new byte[aesdecode.length - (aesdecode[aesdecode.length - 1])];
        System.arraycopy(aesdecode, 0, origin, 0, origin.length);

        String originStr =  new String(origin, "UTF-8");

        return originStr;
    }

}

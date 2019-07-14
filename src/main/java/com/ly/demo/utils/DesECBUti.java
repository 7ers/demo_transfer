package com.ly.demo.utils;

import com.alibaba.fastjson.JSONObject;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.Base64;

public class DesECBUti {
    /**
     * 加密数据
     * @param encryptString
     * @param encryptKey
     * @return
     * @throws Exception
     */
    public static String encryptDES(String encryptString, String encryptKey) throws Exception {
        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }


    /***
     * 解密数据
     * @param decryptString
     * @param decryptKey
     * @return
     * @throws Exception
     */
    public static String decryptDES(String decryptString, String decryptKey) throws Exception {
        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte decryptedData[] = cipher.doFinal(Base64.getDecoder().decode(decryptString));
        return new String(decryptedData);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<JsonData> arrayList = new ArrayList<>(2);
        JsonData jsonData1 = new JsonData();
        jsonData1.setUa("Mozilla/5.0");
        jsonData1.setIp("192.168.0.1");
        JsonData jsonData2 = new JsonData();
        jsonData2.setUa("Chrome/75");
        jsonData2.setIp("192.168.0.1");
        arrayList.add(jsonData1);
        arrayList.add(jsonData2);
        String clearText = JSONObject.toJSONString(arrayList);
        String key = "3fa6f09b";
        System.out.println("明文："+clearText+"\n密钥："+key);
        String encryptText = encryptDES(clearText, key);
        System.out.println("加密后："+encryptText);
        String decryptText = decryptDES(encryptText, key);
        System.out.println("解密后："+decryptText);
    }
}

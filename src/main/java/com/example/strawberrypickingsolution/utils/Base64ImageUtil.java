package com.example.strawberrypickingsolution.utils;

/**
 * @Author: ModestYjx
 * @Description:
 * @Version: 1.0.0
 * @Date: 2021/12/9 15:48
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.tomcat.util.codec.binary.Base64;


public class Base64ImageUtil {
    public static String getBase64FromImage(String path) {
        byte[] fileByte = null;
        try {
            File file = new File(path);
            fileByte = Files.readAllBytes(file.toPath());
            System.out.println("data:image/png;base64," + Base64.encodeBase64String(fileByte));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.encodeBase64String(fileByte);
    }
}

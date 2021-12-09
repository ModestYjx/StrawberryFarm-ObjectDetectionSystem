package com.example.strawberrypickingsolution;

/**
 * @Author: ModestYjx
 * @Description:
 * @Version: 1.0.0
 * @Date: 2021/12/9 12:00
 */

import com.example.strawberrypickingsolution.utils.Base64ImageUtil;
import com.example.strawberrypickingsolution.utils.GsonUtils;
import com.example.strawberrypickingsolution.utils.HttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * easydl物体检测
 */
public class StrawberryDetectionApplicationExample {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String easydlObjectDetection() throws IOException {
        // 请求url
        String url = "【url】";

        String base64Code = Base64ImageUtil.getBase64FromImage("src/main/java/com/example/strawberrypickingsolution/train_270.jpg");
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", base64Code);

            String param = GsonUtils.toJson(map);


            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "【token】";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        StrawberryDetectionApplicationExample.easydlObjectDetection();
    }
}

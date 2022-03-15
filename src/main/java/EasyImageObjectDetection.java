import utils.GsonUtils;
import utils.HttpUtil;

import java.util.HashMap;
import java.util.Map;
/**
 * @Author: ModestYjx
 * @Project: StrawberryPickingSolution
 * @Description:
 * @Version: 1.0.0
 * @Date: 2022/1/15 15:44
 */

/**
 * easydl物体检测
 */
public class EasyImageObjectDetection {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String easydlObjectDetection() {
        // 请求url
        String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/detection/strawberryDetection";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", "train_270.jpg");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.5f0265cc03b91aefc1906a5b48a7b891.2592000.1644824417.282335-25216528";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        EasyImageObjectDetection.easydlObjectDetection();
    }
}

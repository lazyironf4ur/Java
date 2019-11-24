package jeckill;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Random;


/**
 * @author:Lazy1ron
 * @date:2019/10/25 19:35
 */
public class Request {

    public static String sendPost(String url) throws IOException {
        //1.获得一个httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = null;
        result = EntityUtils.toString(entity);
        return result;
    }

    public static String setPhone(int num) {
        String phone = "";
        if (num != 11) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < num; i++) {
            phone = phone + new Random().nextInt(10);
        }


        return phone;
    }

    public static void main(String[] args) throws IOException {
        String path = "http://localhost:27000/seckill//execution/1000";

        String md5 = "/" + "c2097fe5d7ddf03207e4c3126b3d57b8";

        for (int i = 0; i < 20; i++) {
            String phone = "/" + setPhone(11);
            String url = path + phone +md5;
            System.out.println("请求" + i + ":" + sendPost(url));
        }
    }
}

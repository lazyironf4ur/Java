package utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author:Lazy1ron
 * @date:2021/4/15 2:45
 */
public class UploadNacosConfig {

    public static final String FILE_PATH = "D:\\Program\\seata\\conf\\seata_config.txt";

    public static HashMap<String, String> CONF_MAP = new HashMap<>();

    public static String uploadConf(String[] params) throws IOException {
        String url = "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=" + params[0] +"&group=SEATA_GROUP&content=" + params[1] + "&tenant=seata_namespace_id&username=nacos&password=nacos";
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.addHeader("content-type", "application/json;charset=UTF-8");
        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity());
        return result;
    }

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        try {
            File file = new File(FILE_PATH);
            BufferedReader  buf = new BufferedReader(new FileReader(file));
            while (buf.readLine() != null) {
                lines.add(buf.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.forEach(i -> {
            String[] kv;
            kv = i.split("=", 2);
            if (kv.length > 1) {
                try {
                    String result = uploadConf(kv);
                    if (result.contains("true")) {
                        System.out.println("Succeed set " + kv[0] + "=" + kv[1]);
                    } else {
                        System.out.println("config not set successful, please check you program!");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

    }
}

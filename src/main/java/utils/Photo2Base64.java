package utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Base64;
import java.util.Scanner;
/**
 * @author:Lazy1ron
 * @date:2021/4/12 2:55
 */
public class Photo2Base64 {

    public static final String DEFAULT_URL = "C:\\Users\\16051\\Downloads\\idp_2.jpg";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your URL: ");
        String url = scanner.nextLine();
        url = StringUtils.isEmpty(url) ? DEFAULT_URL : url;
        System.out.println(new String(ImageToBase64ByLocal(url)));
    }

    public static byte[] ImageToBase64ByLocal(String url){
        InputStream in = null;
        byte[] bytes = null;

        try{
            in = new FileInputStream(new File(url));
            bytes = new byte[in.available()];

            in.read(bytes);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encode(bytes);
    }
}

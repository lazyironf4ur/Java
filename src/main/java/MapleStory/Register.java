package MapleStory;

import client.LoginCrypto;

public class Register {

    public static void main(String[] args) {
        String pwd = "lazy1ron";
        System.out.println(pwd2HexSha1(pwd));
    }

    public static String pwd2HexSha1(String pwd) {
        return LoginCrypto.hexSha1(pwd);
    }
}

package exception;


import lombok.Getter;


/**
 * @author:Lazy1ron
 * @date:2020/1/20 14:08
 */

@Getter
public class MyException extends RuntimeException {

    private String retCd;

    private String message;

    public MyException() {
        super();
    }

    public MyException(String retCd, String message) {
        super();
        this.retCd = retCd;
        this.message = message;
    }

    // throw 一个 exception 如果上层栈不进行捕获处理则会在当前栈中直接处理

    public static void main(String[] args) {

        try {
            //noThrowExceptionTest();
            throwExceptionTest();
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println(e.getRetCd());
            return;
        }
        System.out.println(1111);
    }

    public static void throwExceptionTest() {
        try {
            throw new MyException("10001", "this is a customized exception");
        } finally {
            System.out.println("finally test");
        }

    }

    public static void noThrowExceptionTest() {
        throw new MyException("10002", "this is another customized exception");
    }

}

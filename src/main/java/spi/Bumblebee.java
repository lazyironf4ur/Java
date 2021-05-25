package spi;

public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, i'm Bumblebee.");
    }
}

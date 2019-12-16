package design.product;

import design.AbstractCsPlayer;

/**
 * @author:Lazy1ron
 * @date:2019/10/31 4:25
 */
public class S1mple extends AbstractCsPlayer {

    public S1mple(){};
    public S1mple(String name, String gun, Integer age) {
        super(name, gun, age);
    }

    public void say() {
        System.out.println("i'm S1mple");

    }

    @Override
    public void playcs() {

    }
}

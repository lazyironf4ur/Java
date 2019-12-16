package design.product;

import design.AbstractCsPlayer;


/**
 * @author:Lazy1ron
 * @date:2019/10/31 4:25
 */
public class Niko extends AbstractCsPlayer {
    public Niko(){};

    Niko(String name, String gun, Integer age) {
        super(name, gun, age);
    }

    public void say() {
        System.out.println("i'm Niko");
    }

    @Override
    public void playcs() {

    }
}

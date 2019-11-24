package design.factory;

import design.AbstractFactory;
import design.AbstractCsPlayer;
import design.product.S1mple;

/**
 * @author:Lazy1ron
 * @date:2019/10/31 4:24
 */
public class S1mpleFactory implements AbstractFactory {

    @Override
    public AbstractCsPlayer getProduct() {
        return new S1mple();
    }
}

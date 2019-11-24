package design.factory;

import design.AbstractFactory;
import design.AbstractCsPlayer;
import design.product.Niko;

/**
 * @author:Lazy1ron
 * @date:2019/10/31 4:22
 */
public class CsPlayerFactory implements AbstractFactory {
    @Override
    public AbstractCsPlayer getProduct() {
        return new Niko();
    }
}

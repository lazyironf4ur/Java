package classloader;

/**
 * @author:Lazy1ron
 * @date:2019/8/30 8:41
 */
public class ClassLoaderOp {

    public static void main(String[] args) {

        // AppClassLoader
        System.out.println("ClassLoaderOp is: " + ClassLoaderOp.class.getClassLoader());

        // ExtClassLoader
        System.out.println("Parent ClassLoaderOp is: " + ClassLoaderOp.class.getClassLoader().getParent());

        // Null
        System.out.println("Grandparent ClassLoaderOp is: " + ClassLoaderOp.class.getClassLoader().getParent().getParent());
    }
}

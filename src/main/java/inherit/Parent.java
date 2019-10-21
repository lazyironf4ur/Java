package inherit;

/**
 * @author:Lazy1ron
 * @date:2019/9/1 11:08
 */
public class Parent extends AbstractParent {
    private String name;
    private Integer age;

    public Parent() {};
    public Parent(String name, Integer age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    @Override
    public int compare(AbstractParent abstractParent) {
        if (this.age > abstractParent.getAge()) {
            return 1;
        } else {
            return 0;
        }
    }

}

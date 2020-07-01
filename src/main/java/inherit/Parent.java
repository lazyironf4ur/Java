package inherit;

import lombok.Data;

/**
 * @author:Lazy1ron
 * @date:2019/9/1 11:08
 */
@Data
public class Parent extends AbstractParent implements Cloneable{
    private String name;
    private Integer age;

    public Parent() {}

    @Override
    public Parent clone() throws CloneNotSupportedException {
        Parent parent;
        parent = (Parent) super.clone();
        return parent;
    }

    ;
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


    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Age: " + age;
    }
}

package inherit;

/**
 * @author:Lazy1ron
 * @date:2019/9/1 11:15
 */
public abstract class AbstractParent {
    public String getName() {
        return name;
    }

    public AbstractParent() {};
    public AbstractParent(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    private String name;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public abstract int compare(AbstractParent abstractParent);
}

package design;


import lombok.Getter;

/**
 * @author:Lazy1ron
 * @date:2019/10/31 4:21
 */
@Getter
public abstract class AbstractCsPlayer {

    private String name;
    private String gun;
    private Integer age;

    public AbstractCsPlayer (String name, String gun, Integer age) {
        this.name = name;
        this.gun = gun;
        this.age = age;
    }
    public AbstractCsPlayer(){};

    public abstract void playcs();
}

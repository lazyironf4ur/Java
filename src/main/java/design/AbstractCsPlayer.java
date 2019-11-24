package design;

/**
 * @author:Lazy1ron
 * @date:2019/10/31 4:21
 */
public abstract class AbstractCsPlayer {

    private String name;
    private String gun;

    public AbstractCsPlayer (String name, String gun) {
        this.name = name;
        this.gun = gun;
    }
    public AbstractCsPlayer(){};

    public abstract void playcs();
}

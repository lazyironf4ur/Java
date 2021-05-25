package jvm;

/**
 * @author:Lazy1ron
 * @date:2020/7/27 19:09
 *
 * vm Args: -Xlog:gc* -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC -XX:PretenureSizeThreshold=3145728
 */
public class PretenureSizeThresholdTest {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        byte[] allocate;
        allocate = new byte[4 * _1MB];
    }
}
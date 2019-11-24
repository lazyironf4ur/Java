package rabbitmq;

import java.util.Collections;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author:Lazy1ron
 * @date:2019/10/30 22:31
 */
public class AsyncConfirm {
    private static SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());

}

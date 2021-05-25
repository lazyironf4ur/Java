package algorithm;

import java.util.*;

/**
 * @author:Lazy1ron
 * @date:2021/4/27 9:47
 */
public class QueuePerformwith2Stack<E> {

    private Stack<E> pop = new Stack<>();
    private Stack<E> push = new Stack<>();

    public void perform(E e) {
        if (e instanceof Collection) {
            Iterator it = ((Collection) e).iterator();
            while (it.hasNext()) {
                push.push((E) it.next());
            }
        } else push.push(e);

        while(!push.empty()) {
            pop.push(push.pop());
        }
        while(!pop.empty()) {
            System.out.println(pop.pop());
        }
    }

    public void perform(E ...e) {
        if (e.length > 1) {
            for (int i = 0; i < e.length; i++) {
                push.push(e[i]);
            }
        }
        while(!push.empty()) {
            pop.push(push.pop());
        }
        while(!pop.empty()) {
            System.out.println(pop.pop());
        }
    }


    public static void main(String[] args) {
        String[] str = {"4", "3", "2", "1"};

        List<String> list = new ArrayList<>();

        list.addAll(Arrays.asList(str));
        QueuePerformwith2Stack qp2s = new QueuePerformwith2Stack();

        //qp2s.perform(str);
        qp2s.perform(list);
    }
}



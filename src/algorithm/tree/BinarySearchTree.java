package tree;

import java.util.Comparator;
import java.util.Map;

/**
 * @author:Lazy1ron
 * @date:2019/9/3 23:55
 */
public class BinarySearchTree<T extends Number> {

    private static Node origin_node =null;

    static class Node<T extends Number> implements Comparable {
        T item;
        Node<T> lnode;
        Node<T> rnode;


        public Node(T item, Node<T> lnode, Node<T> rnode) {
            this.item = item;
            this.lnode = lnode;
            this.rnode = rnode;
        }


        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Node<T> getLnode() {
            return lnode;
        }

        public void setLnode(Node<T> lnode) {
            this.lnode = lnode;
        }

        public Node<T> getRnode() {
            return rnode;
        }

        public void setRnode(Node<T> rnode) {
            this.rnode = rnode;
        }

        @Override
        public int compareTo(Object o) {
            Node<T> cnode = (Node) o;
            Double value1 = this.item.doubleValue();
            Double value2 = cnode.item.doubleValue();
            if (value1.equals(value2)) {
                return 0;
            }
            if (value1 > value2) {
                return 1;
            }
            if (value1 < value2) {
                return -1;
            }
            return 0;
        }
    }

    public void addnode(T t) {
        Node<T> s = null, p = null;
        Node<T> newNode = new Node<T>(t, s, p);
        if (origin_node == null) {
            origin_node = newNode;
        } else {
            if (newNode.compareTo(origin_node) == 1) {
                origin_node.setLnode(null);
                origin_node.setRnode(newNode);
            }
            if (newNode.compareTo(origin_node) == 0) {
                throw new IllegalArgumentException();
            }
            if (newNode.compareTo(origin_node) == -1) {
                origin_node.setLnode(newNode);
                origin_node.setRnode(null);
            }
        }

    }
    public Node search(Node searchNode) {
        Node temp = origin_node;
        T t = (T) searchNode.item;
        Node node = createNewNode(t);
        if (temp == null) {
            return null;
        } else {
            if (temp.compareTo(node) == 0) {
                return temp;
            }
            if (temp.compareTo(node) > 0) {
                temp = temp.rnode;
                search(temp);
            }
            if (temp.compareTo(node) < 0) {
                temp = temp.lnode;
                search(temp);
            }
        }
        return null;
    }

    public Node<T> createNewNode(T t) {
        Node<T> s = null, p = null;
        Node<T> newNode = new Node<T>(t, s, p);
        return newNode;
    }
}

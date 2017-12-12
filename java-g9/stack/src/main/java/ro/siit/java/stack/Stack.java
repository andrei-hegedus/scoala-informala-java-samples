package ro.siit.java.stack;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by andrei on 12/7/17.
 */
public class Stack implements Collection<Integer> {

    private LinkedList<Integer> values = new LinkedList<Integer>();

    /**
     * Adds the parameter element to the top of the stack.
     *
     * @param value
     */
    public void push(int value) {
        values.addFirst(value);
    }

    public Integer pop() {
        if (values.isEmpty()) {
            return null;
        }
        return values.removeFirst();
    }

    public Integer peek() {
        if (values.isEmpty()) {
            return null;
        }
        return values.getFirst();
    }

    // Collection methods

    public int size() {
        return values.size();
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public boolean contains(Object o) {
        return values.contains(o);
    }

    public Iterator<Integer> iterator() {
        return values.iterator();
    }

    public Object[] toArray() {
        return values.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return values.toArray(a);
    }

    public boolean add(Integer integer) {
        push(integer);
        return true;
    }

    public boolean remove(Object o) {
        return values.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return values.containsAll(c);
    }

    public boolean addAll(Collection<? extends Integer> c) {
        for (Integer i : c) {
            push(i);
        }
        return true;
    }

    public boolean removeAll(Collection<?> c) {
        return values.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return values.retainAll(c);
    }

    public void clear() {
        values.clear();
    }
}

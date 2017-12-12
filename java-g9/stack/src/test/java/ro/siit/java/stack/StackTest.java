package ro.siit.java.stack;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by andrei on 12/7/17.
 */
public class StackTest {

    @Test
    public void testPush() {
        Stack stack = new Stack();
        stack.push(5);
        assertEquals(new Integer(5), stack.peek());
    }

    @Test
    public void testPeekMultipleTimes() {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(3);
        assertEquals(new Integer(3), stack.peek());
        assertEquals(new Integer(3), stack.peek());
        assertEquals(new Integer(3), stack.peek());
    }

    @Test
    public void testPeekEmptyStack() {
        Stack stack = new Stack();
        assertNull(stack.peek());
    }

    @Test
    public void testPop() {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(3);
        assertEquals(new Integer(3), stack.pop());
        assertEquals(new Integer(5), stack.pop());
        assertNull(stack.pop());
    }

    @Test
    public void testPopEmptyStack() {
        Stack stack = new Stack();
        assertNull(stack.pop());
    }

    @Test
    public void testCombineMethods() {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(5);
        assertEquals(new Integer(5), stack.peek());
        stack.push(-2);
        assertEquals(new Integer(-2), stack.peek());
        assertEquals(new Integer(-2), stack.pop());
        assertEquals(new Integer(5), stack.pop());
        assertEquals(new Integer(3), stack.peek());
        stack.push(6);
        assertEquals(new Integer(6), stack.peek());
        assertEquals(new Integer(6), stack.pop());
        assertEquals(new Integer(3), stack.pop());
        assertNull(stack.peek());
    }

    // Collection interface testing
    @Test
    public void col_testSize() {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(5);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        stack.peek();
        assertEquals(1, stack.size());
        stack.push(-2);
        assertEquals(2, stack.size());
    }

    @Test
    public void col_testIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void col_testIterator() {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(5);
        stack.push(-4);
        Iterator<Integer> iterator = stack.iterator();
        assertEquals(new Integer(-4), iterator.next());
        assertEquals(new Integer(5), iterator.next());
        assertEquals(new Integer(3), iterator.next());
    }

    @Test
    public void col_testClear() {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(5);
        stack.push(-4);
        stack.clear();
        assertTrue(stack.isEmpty());
    }

}
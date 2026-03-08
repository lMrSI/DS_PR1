package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.traversal.Iterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.Point;

import static org.junit.Assert.*;

public class PR1StackTest {

    PR1Stack pr1q;

    private void fillCharStack() {
        for (char c = '0'; c <= '8'; c++) {
            pr1q.push(c);
        }
    }

    private void fillPointStack() {
        for (int i = 0; i < 9; i++) {
            Point p = new Point(i, i * 2);
            pr1q.push(p);
        }
    }

    @Before
    public void setUp() {
        this.pr1q = new PR1Stack();

        assertNotNull(this.pr1q.getCharStack());
        assertNotNull(this.pr1q.getPointStack());

        this.fillCharStack();
        this.fillPointStack();
    }

    @After
    public void release() {
        this.pr1q = null;
    }

    @Test
    public void stackTestChar() {
        Stack<Character> stack = pr1q.getCharStack();
        assertEquals(9, stack.size());

        assertEquals(Character.valueOf('8'), pr1q.popChar());
        assertEquals(Character.valueOf('7'), pr1q.popChar());
        assertEquals(Character.valueOf('6'), pr1q.popChar());
        assertEquals(Character.valueOf('5'), pr1q.popChar());
        assertEquals(Character.valueOf('4'), pr1q.popChar());
        assertEquals(Character.valueOf('3'), pr1q.popChar());
        assertEquals(Character.valueOf('2'), pr1q.popChar());
        assertEquals(Character.valueOf('1'), pr1q.popChar());
        assertEquals(Character.valueOf('0'), pr1q.popChar());

        assertEquals(0, stack.size());
    }

    @Test
    public void stackTestPoint() {
        Stack<Point> stack = pr1q.getPointStack();
        assertEquals(9, stack.size());

        Point p = pr1q.popPoint();
        assertNotNull(p);
        assertEquals(8, p.x);
        assertEquals(16, p.y);

        p = pr1q.popPoint();
        assertEquals(7, p.x);
        assertEquals(14, p.y);

        p = pr1q.popPoint();
        assertEquals(6, p.x);
        assertEquals(12, p.y);
    }
}
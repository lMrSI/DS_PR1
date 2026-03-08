package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.traversal.Iterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.Point;

import static org.junit.Assert.*;

public class PR1QueueTest {

    private PR1Queue pr1q;

    @Before
    public void setUp() {
        pr1q = new PR1Queue();
        assertNotNull(pr1q.getQueue());
        assertNotNull(pr1q.getPointQueue());
        fillPointQueue();
    }

    @After
    public void release() {
        pr1q = null;
    }

    private void fillPointQueue() {
        double a = 0;
        double b = 1;

        for (int i = 0; i < 9; i++) {
            double theta = i;
            Point p = generatePoint(a, b, theta);
            pr1q.add(p);
        }
    }

    private Point generatePoint(double a, double b, double theta) {
        int x = (int) (a + b * theta * Math.cos(theta));
        int y = (int) (a + b * theta * Math.sin(theta));
        return new Point(x, y);
    }
/*
    @Test
    public void queueTest() {
        assertEquals(pr1q.CAPACITY-1, pr1q.getQueue().size());
        // Ejemplo mínimo de uso con Character
        pr1q.add('0');
        Character c = pr1q.poll();
        assertNotNull(c);
    }

 */
/*
    @Test
    public void queueTest2() {
        Queue<Character> queue = pr1q.getQueue();
        Iterator<Character> it = queue.values();
        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('0'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('1'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('2'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('3'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('4'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('5'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('6'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('7'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('8'), it.next());
    }
 */

    @Test
    public void pointQueueTest() {
        Queue<Point> queue = pr1q.getPointQueue();

        assertEquals(9, queue.size());

        for (int i = 0; i < 9; i++) {
            Point p = pr1q.pollPoint();
            assertNotNull(p);
        }

        assertEquals(0, queue.size());
    }

    @Test
    public void pointQueueIteratorTest() {
        Queue<Point> queue = pr1q.getPointQueue();
        Iterator<Point> it = queue.values();

        int count = 0;
        while (it.hasNext()) {
            Point p = it.next();
            assertNotNull(p);
            count++;
        }

        assertEquals(9, count);

        Point p = pr1q.pollPoint();
        assertNotNull(p);
    }
}
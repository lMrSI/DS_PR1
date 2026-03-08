package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;

import java.awt.*;

public class PR1Queue {

    public final int CAPACITY = 10;

    private Queue<Character> charQueue;

    private Queue<Point> pointQueue;

    public PR1Queue() {
        newCharQueue();
        newPointQueue();
    }

    public void newCharQueue() {
        charQueue = new QueueArrayImpl<>(CAPACITY);
    }

    public Queue<Character> getQueue() {
        return charQueue;
    }

    public void add(Character c) {
        charQueue.add(c);
    }

    public Character poll() {
        return charQueue.poll();
    }

    public void newPointQueue() {
        pointQueue = new QueueArrayImpl<>(CAPACITY);
    }

    public Queue<Point> getPointQueue() {
        return pointQueue;
    }

    public void add(Point p) {
        if (pointQueue.size() < CAPACITY) {
            pointQueue.add(p);
        }
    }

    public Point pollPoint() {
        if (pointQueue.size() > 0) {
            return pointQueue.poll();
        }
        return null;
    }
}
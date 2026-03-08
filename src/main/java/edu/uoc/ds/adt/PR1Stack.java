package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;

import java.awt.Point;

public class PR1Stack {

    public final int CAPACITY = 10;

    private Stack<Character> charStack;

    private Stack<Point> pointStack;

    public PR1Stack() {
        newCharStack();
        newPointStack();
    }

    public void newCharStack() {
        charStack = new StackArrayImpl<>(CAPACITY);
    }

    public Stack<Character> getCharStack() {
        return charStack;
    }

    public void push(Character c) {
        charStack.push(c);
    }

    public Character popChar() {
        return charStack.pop();
    }

    public void newPointStack() {
        pointStack = new StackArrayImpl<>(CAPACITY);
    }

    public Stack<Point> getPointStack() {
        return pointStack;
    }

    public void push(Point p) {
        if (pointStack.size() < CAPACITY) {
            pointStack.push(p);
        }
    }

    public Point popPoint() {
        if (pointStack.size() > 0) {
            return pointStack.pop();
        }
        return null;
    }
}
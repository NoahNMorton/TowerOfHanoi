package pack1;
/*
*Author: Noah Morton
*Date created: 8/28/16, 12:56 PM
*Part of project: StackTester
*/

import java.util.ArrayList;

public class Stack<E> implements StackInterface<E> {

    private ArrayList<E> stack;

    public Stack(int disAmt) {
        this.stack = new ArrayList<>();
    }

    @Override
    public E push(E o) {
        stack.add(0,o);
        return o;
    }

    @Override
    public E peek() {
        return stack.get(0);
    }

    @Override
    public E pop() {
        return stack.remove(0);
    }

    @Override
    public boolean empty() {
        return stack.size()==0;
    }


    public int size() {
        return stack.size();
    }


    public E get(int x) {
        return stack.get(x);
    }
}

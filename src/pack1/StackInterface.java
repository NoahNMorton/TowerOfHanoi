package pack1;
/*
Noah Morton
Tully 7th period
 */

@SuppressWarnings("ALL")
public interface StackInterface<E> {
    public E push(E o);

    public E peek();

    public E pop();

    boolean empty();
}
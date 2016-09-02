package pack1;

@SuppressWarnings("ALL")
public interface StackInterface<E> {
    public E push(E o);

    public E peek();

    public E pop();

    boolean empty();
}
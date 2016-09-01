package pack1;

@SuppressWarnings("ALL")
public interface StackInterface<E> {
    E push(E o);

    E peek();

    E pop();

    boolean empty();
}
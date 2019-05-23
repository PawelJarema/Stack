public interface IStack <T> {
    public void push(T value) throws Exception;
    public T pop();
    public T peek();
    public void grow(int size);
    public boolean isEmpty();
    public boolean isFull();
    public int size();
    public int maxSize();
}

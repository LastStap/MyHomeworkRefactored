package dumshenko.daniil;

public interface Stackable {
    public boolean isEmpty();
    public boolean isFull();
    public void putElementToStack(int element);
    public int deleteElementFromStack();
    public int getTopElement();
}

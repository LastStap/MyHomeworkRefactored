package dumshenko.daniil;

import java.util.Arrays;
import java.util.Optional;

public class Stack implements Stackable {

    private final int maxSize;
    private final int[] stackArray;
    private int topElement;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
        topElement = -1;
    }

    @Override
    public boolean isEmpty() {
        return (topElement == -1);
    }

    @Override
    public boolean isFull() {
        return (topElement == maxSize - 1);
    }

    @Override
    public void putElementToStack(int element) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full, it is impossible to add this element");
        }
        stackArray[++topElement] = element;
    }

    @Override
    public int deleteElementFromStack() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty, it is impossible to delete any elements");
        }
        return stackArray[topElement--];
    }

    @Override
    public int getTopElement() {
        return stackArray[topElement];
    }

    Optional<Integer> getTopOptionalElement() {
        if (isEmpty()){
            return Optional.empty();
        }
        return Optional.of(stackArray[topElement]);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack is empty";
        }
        return "Stack elements: " + Arrays.toString(Arrays.copyOfRange(stackArray, 0, topElement + 1));
    }
}

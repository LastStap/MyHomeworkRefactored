package dumshenko.daniil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack(3);
    }

    @Test
    void shouldReturnIfStackIsEmpty() {
        // When
        assertTrue(stack.isEmpty());
        // Then
        stack.putElementToStack(10);
        assertFalse(stack.isEmpty());
    }

    @Test
    void shouldReturnIfStackIsFull() {
        //When
        stack.putElementToStack(10);
        stack.putElementToStack(20);
        stack.putElementToStack(30);
        //Then
        assertTrue(stack.isFull());
    }

    @Test
    void shouldPutElementToStack() {
        //Given
        int element = 10;

        //When
        if (!stack.isFull()) {
            stack.putElementToStack(element);
        }
        //Then
        assertEquals(element, stack.getTopElement());
    }

    @Test
    void shouldDeleteElementFromStack() {
        //Given
        int element1 = 10;
        int element2 = 10;

        if (!stack.isFull()) {
            stack.putElementToStack(element1);
            stack.putElementToStack(element2);
        }
        int topElementBeforeAnnihilation = stack.getTopElement();
        //When
        stack.deleteElementFromStack();
        int topElementAfterAnnihilation = stack.getTopElement();
        //Then
        assertEquals(topElementAfterAnnihilation, topElementBeforeAnnihilation);
    }

    @Test
    void shouldReturnTopElement() {
        //Given
        int element1 = 10;
        int element2 = 10;

        //When
        if (!stack.isFull()) {
            stack.putElementToStack(element1);
            stack.putElementToStack(element2);
        }

        //Then
        assertEquals(element2, stack.getTopElement());
    }

    @Test
    void shouldReturnOptionalTopElement() {
        //Given
        int element1 = 10;
        int element2 = 20;

        if (!stack.isFull()) {
            stack.putElementToStack(element1);
            stack.putElementToStack(element2);
        }

        //When
        Optional<Integer> topElement = stack.getTopOptionalElement();

        //Then
        assertTrue(topElement.isPresent());
        assertEquals(20, topElement.get());

        stack.deleteElementFromStack();
        stack.deleteElementFromStack();
        Optional<Integer> emptyElement = stack.getTopOptionalElement();
        assertTrue(emptyElement.isEmpty());
    }

    @Test
    void shouldReturnExeptionWhenPuttingElementToFullStack() {
        //Given
        stack.putElementToStack(10);
        stack.putElementToStack(20);
        stack.putElementToStack(30);

        //When
        Exception exception = assertThrows(IllegalStateException.class, () -> stack.putElementToStack(40));
        //Then
        assertEquals("Stack is full, it is impossible to add this element", exception.getMessage());
    }

    @Test
    void shouldReturnExeptionWhenDeletingElementFromEmptyStack() {
        //When
        Exception exception = assertThrows(IllegalStateException.class, stack::deleteElementFromStack);
        //Then
        assertEquals("Stack is empty, it is impossible to delete any elements", exception.getMessage());
    }
}

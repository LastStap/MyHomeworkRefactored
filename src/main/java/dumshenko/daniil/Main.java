package dumshenko.daniil;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        System.out.println("Чи стек пустий: " + stack.isEmpty());

        stack.putElementToStack(10);
        stack.putElementToStack(20);
        stack.putElementToStack(30);
        stack.putElementToStack(40);
        stack.putElementToStack(50);

        System.out.println("Чи стек повний: " + stack.isFull());

        System.out.println(stack.deleteElementFromStack());

        System.out.println(stack.getTopElement());

        System.out.println(stack.getTopOptionalElement());

        System.out.println(stack);
    }
}

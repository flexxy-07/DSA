package Stack;

public class CustomStacks {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStacks(){
        this(DEFAULT_SIZE);
    }

    public CustomStacks(int size) {
        this.data = new int[size];
    }

    public boolean push(int item){
        if (isFull()){
            System.out.println("Stack is Full!!");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }
    public int pop(){
        if (isEmpty()){
            System.out.println("Cannot pop from an empty stack!");
        }
        return data[ptr--];
    }
    public int peek() {
        if (isEmpty()){
            System.out.println("Cannot peak from empty stack");
        }
        return data[ptr];
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty(){
        return ptr == -1;
    }
}

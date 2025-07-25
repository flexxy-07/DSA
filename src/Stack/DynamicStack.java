package Stack;

public class DynamicStack extends CustomStacks {
    public DynamicStack(){
        super();
    }
    public DynamicStack (int size){
        super(size);
    }
    @Override
    public boolean push(int item){
        if (this.isFull()){
            // double the array
            int[] temp = new int[data.length * 2];
            // copy all the elements in the temp array
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        // at this point we know that array is not equal
        // insert item
        return super.push(item);
    }
}

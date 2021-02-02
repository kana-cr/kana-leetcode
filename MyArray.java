import java.util.Arrays;

public class MyArray<T> {
    
    private Object[] data;//数据

    private int count;//数据个数

    private static final int DEFAULT_LENGTH = 10;

    public MyArray(int capacity) {
        data = new Object[capacity];
    }
    
    public MyArray() {
        data = new Object[DEFAULT_LENGTH];
    }

    public int size(){
        return count;
    }

    public T add(T value){
        if(count == data.length){
        Object[] oldData = data;
        data = new Object[data.length << 1];
        data = Arrays.copyOf(oldData, data.length);
        }
        count++;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T get(int index){
        rangeCheck(index);
        return (T) data[index];
    }


    @SuppressWarnings("unchecked")
    public T replace(int index ,T value){
        rangeCheck(index);
        T oldValue = (T) data[index];
        data[index] = value;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index){
        rangeCheck(index);
        T oldValue = (T) data[index];
        count--;
        for (int i = index; i < count; i++) {
            if(data[i + 1] == null) break;
            data[i] = data[i + 1];
        }
        return oldValue; 
    }

    private void rangeCheck(int index) throws IllegalArgumentException{
        if(index >= count)
        throw new IndexOutOfBoundsException("下标越界");
    }


}
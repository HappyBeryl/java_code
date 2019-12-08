public class MyArrayList<T> {
    public T[] elem;
    public int usedSize;
    public MyArrayList() {
        //this.elem = new T[10];
        this.elem = (T[])new Object[10];
        this.usedSize = 0;
    }
    public void add(T data) {
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }
    public T get() {
        return this.elem[this.usedSize-1];
    }

    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        System.out.println(myArrayList);
        myArrayList.add("Java");
//        myArrayList.add(2); //报错
        String ret = myArrayList.get();
    }
}
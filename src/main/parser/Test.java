public class MyClass {
    private int myField;

    public MyClass() {
    }

    public MyClass(int value) {
        myField = value;
    }

    public int getMyField() {
        return myField;
    }

    public static void main(String[] args) {
        MyClass myObject = new MyClass(42);
        System.out.println(myObject.getMyField());
    }
}
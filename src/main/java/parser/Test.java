package parser;

public class Test {
    private int myField;

    public Test() {
    }

    public Test(int value) {
        myField = value;
    }

    public int getMyField() {
        return myField;
    }

    public static void main(String[] args) {
        Test myObject = new Test(42);
        System.out.println(myObject.getMyField());
    }
}
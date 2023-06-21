package ressources.Testcases;

public class StringMethods {
static Test test = new Test();
    public static void main(String[] args) {

        System.out.println(test.getChar(1));
        System.out.println(test.getPos("Ha"));
        System.out.println(test.getLength());
        System.out.println(test.empty());
        System.out.println(test.concat());

    }

}

class Test {
    String a = "Hallo";
    String b = " World";

    public char getChar(int i) {
        return a.charAt(i);
    }

    public int getPos(String c) {
        return a.indexOf(c);
    }

    public int getLength() {
        return a.length();
    }

    public boolean empty() {
        return a.isEmpty();
    }

    public String concat() {
        return a.concat(b);
    }
}

package ressources.Testcases.singleton;

public class SingletonMain {

    public static void main(String[] args) {
        ClassSingleton Single = ClassSingleton.getInstance();
        Single.x++;
        System.out.println(Single.x);
        addConstant();
        System.out.println(Single.x);
        ClassSingleton tre = ClassSingleton.getInstance();
        if (tre.x == Single.x) {
            System.out.println("It is the same!");
        }

    }

    public static void addConstant() {
        ClassSingleton.getInstance().x += 5;

    }
}

class ClassSingleton {

    private static ClassSingleton INSTANCE;
    private String info = "Initial info class";
    public int x = 0;

    private ClassSingleton() {
    }

    public static ClassSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClassSingleton();
        }

        return INSTANCE;
    }

    // getters and setters
}
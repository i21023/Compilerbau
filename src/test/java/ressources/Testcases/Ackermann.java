package ressources.Testcases;

public class Ackermann {
    public static void main(String[] args) {
        System.out.println(Ackermann(3,4));
    }

    public static int Ackermann(int a, int b) {
        if(a==0)return(b+1);
        else if(b==0)return Ackermann(a-1,1);
        else return Ackermann(a-1,Ackermann(a,b-1));
    }
}

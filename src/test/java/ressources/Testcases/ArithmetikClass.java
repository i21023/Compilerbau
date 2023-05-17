package ressources.Testcases;

public class ArithmetikClass {

    public int add(int a, int b){
        if(b==0)
        {
            return a;
        }
        return add(a+1,b-1);
    }

    public int mul(int a, int b)
    {
        if(b==0)
        {
            return 0;
        }
        if(b==1)
        {
            return a;
        }
        return add(a, mul(a,b-1));

    }

}

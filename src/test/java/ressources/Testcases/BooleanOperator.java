package ressources.Testcases;

public class BooleanOperator {
    boolean bool1=true;
    boolean bool2=false;
    public boolean OpAnd()
    {
    if(bool1 & bool2){
        return true;

    }else{
        return false;
    }
    }
    public boolean OpOr()
    {
        if(bool1 | bool2){
            return true;

        }else{
            return false;
        }
    }
}

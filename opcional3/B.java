package opcional3;

public class B {

    int v1;

    public B(){
        v1 = 100;
    }

    public A m2(){
        A o1 = new A(v1);
        return o1;
    }
    
}

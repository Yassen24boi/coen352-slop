package Q1;

record State(int n, int m){}

public class LCF {
    
   public static int lcf(int n, int m) {

    if (n == 0 && m == 0) {
        throw new IllegalArgumentException("Invalid input");
    }

    State state = new State(n, m);

    System.out.println(state.n());

    if (m == 0)
        return n;

    return lcf(m, n % m);
}

    public static void main(String[] args) {
        int n = 56;
        int m = 42;

        System.out.println(lcf(n, m));
    }
}

public class Student {

    // data member
    int id;

    // constructor
    public Student(int id) {
        this.id = id;
    }

    // static method
    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        // create object
        Student st = new Student(10);

        // print id
        System.out.println(st.id);

        // assert test
        assert add(2, 3) == 10;

    }
}
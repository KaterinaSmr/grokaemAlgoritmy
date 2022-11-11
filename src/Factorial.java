public class Factorial {
    public static void main(String[] args) {
        int num = 5;
        for (int i = 0; i <= num; i++) {
            System.out.println(i + "! = " + factorial(i));
        }
    }

    static int factorial(int num){
        if(num == 0) return 1;
        return num * factorial(num-1);
    }
}

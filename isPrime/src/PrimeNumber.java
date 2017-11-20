
// Good way of determining if a number is prime or not.

public class PrimeNumber {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++){
            if (!isPrime(i)){
                continue;
            }
            System.out.println(i + " is a prime number.");
        }
    }

    static boolean isPrime(int nr){
        if (nr == 0) return false;
        if (nr == 1) return false;
        if (nr == 2) return true;
        if (nr == 3) return true;
        if (nr % 2 == 0) return false;
        if (nr % 3 == 0) return false;

        int i = 5;
        int w = 2;

        while (i <= nr/2){
            if (nr % i == 0) return false;

            i += w;
            w = 6 - w;
        }
        return true;
    }

}

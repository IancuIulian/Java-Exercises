/**
 * Created by ulisee on 12/05/16.
 *
 *  Print the following output:
 *               1
               2 1 2
             3 2 1 2 3
                 .
                 .
        n... 3 2 1 2 3 ...n
 */
public class ForLoopNumberPyramid {

    public static void main(String[] args) {
        int n = 8;

        for (int i = 1; i <= n; i++){
            for (int j = i; j < n; j++){
                System.out.print("  ");
            }
            for (int j = i; j > 0; j--){
                System.out.print(j+" ");
            }
            for (int j = 2; j <= i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}

/**
 * Created by ulise on 02/04/2017.
 */
public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = {4,2,5,8,1,3,7,9,6};

//        StupidSort(arr);
//        BubbleSort(arr);
        SelectionSort(arr);
//        InsertionSort(arr);
        printArray(arr);

    }

    static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    static void StupidSort(int[] arr){
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void BubbleSort(int[] arr){
        int temp;
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void SelectionSort(int[] arr){
        int minIndex, temp;
        for (int i = 0; i < arr.length-1; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    static void InsertionSort(int[] arr){
        int k, temp;
        for (int i = 1; i < arr.length; i++) {
            k = i;
            while (k>0 && arr[k] < arr[k-1]){
                temp = arr[k];
                arr[k] = arr[k-1];
                arr[k-1] = temp;
                k--;
            }
        }
    }

}

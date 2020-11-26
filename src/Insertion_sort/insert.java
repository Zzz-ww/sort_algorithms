package Insertion_sort;

public class insert {
    public static void insert_sort (int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }

            /* Insert key into a suitable position */
            arr[j+1] = key;
        }
    }

    public static void printArr (int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main (String argsp[]){
        int arr[] = {12, 14, 13, 5, 6};
        insert ob = new insert();
        ob.insert_sort(arr);
        printArr(arr);
    }
}

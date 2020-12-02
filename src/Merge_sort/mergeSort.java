package Merge_sort;

public class mergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Creat temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays */

        // Initial index of left and right array
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l; // k是合并后的数组的当前位置
        while (i < n1 && j < n2) {

            // L & R两个数组排序完的数组从头进行比较（L[i] & R[j]），较大的插入最终的数组arr[]
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copying remaining elements of L[] if any
         * 若左&右边序列还有剩余，则将其全部拷贝进tmp[]中 */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m); //取左边的数组不断拆分
            sort(arr, m + 1, r); //取右边的数组不断拆分

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        mergeSort ob = new mergeSort();
        ob.sort(arr, 0, arr.length - 1);
        System.out.println("\nSorted array");
        printArray(arr);
    }

}

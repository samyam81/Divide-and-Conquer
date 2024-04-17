public class InversionCount {

    // Function to count inversions
    public static int countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    // Merge Sort Function
    private static int mergeSort(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count += mergeSort(arr, left, mid); // Count inversions in left half
            count += mergeSort(arr, mid + 1, right); // Count inversions in right half
            count += merge(arr, left, mid, right); // Merge the two halves and count inversions
        }
        return count;
    }

    // Merge Function
    private static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // If element in left subarray is greater than element in right subarray,
                // it means inversion exists.
                temp[k++] = arr[j++];
                count += (mid - i + 1);
            }
        }

        // Copy remaining elements of left subarray if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right subarray if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy merged elements back to original array
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        System.out.println("Number of inversions: " + countInversions(arr));
    }
}

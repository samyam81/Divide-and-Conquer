public class MergeSort {

    public static void main(String[] args) {

        // time:: Nlog(N)
        // Space:: O(N)
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        divide(arr, 0, n - 1);

        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void divide(int[] arr, int Si, int Ei) {
        if (Si < Ei) {
            int mid = Si + (Ei - Si) / 2;
            divide(arr, Si, mid);
            divide(arr, mid + 1, Ei);
            conquer(arr, Si, mid, Ei);
        }
    }

    private static void conquer(int[] arr, int si, int mid, int ei) {
        int merger[] = new int[ei - si + 1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                merger[x++] = arr[idx1++];
            } else {
                merger[x++] = arr[idx2++];
            }
        }
        while (idx1 <= mid) {
            merger[x++] = arr[idx1++];
        }
        while (idx2 <= ei) {
            merger[x++] = arr[idx2++];
        }

        for (int i = 0, j = si; i < merger.length; i++, j++) {
            arr[j] = merger[i];
        }
    }
}

public class FindKthSmallest {
    public static void main(String[] args) {
        // Time complexity: O(n log n)
        // Space complexity: O(log n)
        
        int arr[] = {6, 7, 8, 23, 81};
        int n = arr.length;
        int k = 3;

        int kthSmallest = findKthSmallest(arr, 0, n - 1, k);
        System.out.println("The " + k + "th smallest element is: " + kthSmallest);
    }

    private static int findKthSmallest(int[] arr, int Si, int Ei, int k) {
        if (Si == Ei) {
            return arr[Si];
        }

        int pivotIndex = partition(arr, Si, Ei);
        int sizeLeft = pivotIndex - Si + 1;

        if (k == sizeLeft) {
            return arr[pivotIndex];
        } else if (k < sizeLeft) {
            return findKthSmallest(arr, Si, pivotIndex - 1, k);
        } else {
            return findKthSmallest(arr, pivotIndex + 1, Ei, k - sizeLeft);
        }
    }

    private static int partition(int[] arr, int Si, int Ei) {
        int pivot = arr[Ei];
        int i = Si - 1;

        for (int j = Si; j < Ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[Ei];
        arr[Ei] = temp;

        return i + 1;
    }
}

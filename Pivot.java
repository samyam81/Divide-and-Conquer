public class Pivot {
    public static void main(String[] args) {
      
        // arr = [4, 5, 6, 7, 0, 1, 2] Output::4
        //Complexity: 0(Log N)
      
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int result = pivot(arr, 0, arr.length - 1);
        System.out.println("The index is " + result);

    }

    private static int pivot(int[] arr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1; 
            } else if (arr[mid] < arr[right]) {
                right = mid; 
            } else {
                return right; 
            }

        }
        return left; 
    }
}

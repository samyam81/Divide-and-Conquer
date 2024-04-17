public class FindMax {
    public static void main(String[] args) {
        // Time complexity: O(log n)
        // Space complexity: O(log n)
        
        int arr[]={6,7,8,23,81};
        int n=arr.length;

        int max = Find(arr,0,n-1);
        System.out.println("The max is:::"+max);
    }

    private static int Find(int[] arr, int Si, int Ei) {

        if (Si==Ei) {
                return arr[Si];           
        }

        int mid=Si+(Ei-Si)/2;
        int maxleft=Find(arr, Si, mid);
        int maxRight=Find(arr, mid+1, Ei);
        if (maxRight>maxleft) {
            return maxRight;
        } else
            return maxleft;

    }
}

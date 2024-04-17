import java.util.Random;
public class quicksort {
    public static void main(String[] args) {
        int[] arr= new int[50];
        cin(arr);
        System.out.println("The Array before sorting is");
        cout(arr);
        sortQuick(arr,0,49);
        System.out.println("The Array After sorting is");
        cout(arr);
    }
    private static void cout(int[] arr) {
        for(int i=0;i<50;i++){
            System.out.println(arr[i]);
        }
    }
    private static void cin(int[] arr) {
          Random random = new Random();
         // generate a random array;
        for(int i=0;i<50;i++){
            arr[i]=random.nextInt();
         }
    }
    private static void sortQuick(int[] arr,int low, int high){
        if(low<high){
            int pi=partition(arr,low,high);
            sortQuick(arr,low,pi-1);
            sortQuick(arr,pi+1,high);
        }
    }
    private static int partition(int arr[],int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<=high-1;j++)
        {  if(arr[j]<=pivot){
              i++;
            swap(arr,i,j);
        }
    }
    swap (arr,i+1,high);
    return (i+1) ;
    }
    private static void swap(int arr[],int a, int b){
        int temp1=arr[a];
        arr[a]=arr[b];
        arr[b]=temp1;
    }
}

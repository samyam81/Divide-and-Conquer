import java.util.LinkedList;

public class MergeSort1 {
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(arr[i]);
        }

        divide(linkedList, 0, n - 1);
        
        System.out.println("Sorted Linked List:");
        for (int num : linkedList) {
            System.out.print(num + " ");
        }
    }

    private static void divide(LinkedList<Integer> linkedList, int Si, int Ei) {
        if (Si < Ei) {
            int mid = Si + (Ei - Si) / 2;
            divide(linkedList, Si, mid);
            divide(linkedList, mid + 1, Ei);
            conquer(linkedList, Si, mid, Ei);
        }
    }

    private static void conquer(LinkedList<Integer> linkedList, int si, int mid, int ei) {
        LinkedList<Integer> merge = new LinkedList<>();
        int idx1 = si;
        int idx2 = mid + 1;

        while (idx1 <= mid && idx2 <= ei) {
            if (linkedList.get(idx1) <= linkedList.get(idx2)) {
                merge.add(linkedList.get(idx1));
                idx1++;
            } else {
                merge.add(linkedList.get(idx2));
                idx2++;
            }
        }

        while (idx1 <= mid) {
            merge.add(linkedList.get(idx1));
            idx1++;
        }
        while (idx2 <= ei) {
            merge.add(linkedList.get(idx2));
            idx2++;
        }

        for (int i = si, j = 0; i <= ei; i++, j++) {
            linkedList.set(i, merge.get(j));
        }
    }
}

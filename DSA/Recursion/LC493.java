//https://leetcode.com/problems/reverse-pairs/
public class LC493 {
    public static void main(String[] args) {
        count = 0;
        int[] arr2 = { 2, 4, 3, 5, 1 };
        mergeSortInPlace(arr2, 0, arr2.length - 1);
        System.out.println(count);
    }

    static int count = 0;

    static void mergeSortInPlace(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSortInPlace(arr, low, mid);
        mergeSortInPlace(arr, mid + 1, high);
        reversePairs(arr, low, mid, mid + 1);
        mergeInPlace(arr, low, mid, high);
    }

    static void reversePairs(int[] arr, int low, int mid, int high) {
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && arr[i] > 2L * arr[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
    }

    static void mergeInPlace(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, low, temp.length);
    }
}

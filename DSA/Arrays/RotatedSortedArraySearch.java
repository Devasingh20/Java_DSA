import java.util.*;

public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Enter the size of the array: ");
                int n = sc.nextInt();
                int[] arr = new int[n];
                System.out.println("Enter the elements of the rotated sorted array: ");
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                System.out.println("Enter the target element to search: ");
                int target = sc.nextInt();
                int low = 0;
                int high = n - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (arr[mid] == target) {
                        System.out.println("Element found at index: " + mid);
                        return;
                    }
                    if (arr[low] <= arr[mid]) {
                        if (arr[low] <= target && target < arr[mid]) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    } else {
                        if (arr[mid] < target && target <= arr[high]) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                }
                System.out.println("Element not found in the array.");
            }
        }
    }
}

public class LC724 {
    public static void main(String[] args) {
        int[] nums = { 2, 3, -1, 8, 4 };
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }

        boolean found = false;
        for (int i = 0; i < n; i++) {
            int leftsum;
            int rightsum;

            if (i == 0) {
                leftsum = 0;
            } else {
                leftsum = prefix[i - 1];
            }

            if (i == n - 1) {
                rightsum = 0;
            } else {
                rightsum = suffix[i + 1];
            }

            if (leftsum == rightsum) {
                System.out.println(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(-1);
        }
    }
}

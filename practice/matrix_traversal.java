//Row wise traversal of a matrix

// public class matrix_traversal {
//     public static void main(String[] args) {
//         int[][] nums = {
//                 { 1, 2, 3 },
//                 { 4, 5, 6 },
//                 { 7, 8, 9 }
//         };

//         int m = nums.length;
//         int n = nums[0].length;
//         for (int row = 0; row < m; row++) {
//             for (int col = 0; col < n; col++) {
//                 System.out.print(nums[row][col] + " ");
//             }
//         }
//     }
// }

//column wise traversal of a matrix
// public class matrix_traversal {
//     public static void main(String[] args) {
//         int[][] nums = {
//                 { 1, 2, 3 },
//                 { 4, 5, 6 },
//                 { 7, 8, 9 }
//         };

//         int m = nums.length;
//         int n = nums[0].length;
//         for (int col = 0; col < n; col++) {
//             for (int row = 0; row < m; row++) {
//                 System.out.print(nums[row][col] + " ");
//             }
//         }
//     }
// }

//Reverse row wise traversal of a matrix
// public class matrix_traversal {
//     public static void main(String[] args) {
//         int[][] nums = {
//                 { 1, 2, 3 },
//                 { 4, 5, 6 },
//                 { 7, 8, 9 }
//         };

//         int m = nums.length;
//         int n = nums[0].length;
//         for (int row = 0; row < m; row++) {
//             for (int col = n-1; col >= 0; col--) {
//                 System.out.print(nums[row][col] + " ");
//             }
//         }
//     }
// }

//Reverse column wise traversal of a matrix
// public class matrix_traversal {
//     public static void main(String[] args) {
//         int[][] nums = {
//                 { 1, 2, 3 },
//                 { 4, 5, 6 },
//                 { 7, 8, 9 }
//         };

//         int m = nums.length;
//         int n = nums[0].length;
//         for (int col = 0; col < n; col++) {
//             for (int row = m - 1; row >= 0; row--) {
//                 System.out.print(nums[row][col] + " ");
//             }
//         }
//     }
// }

//Boundry traversal..
// public class matrix_traversal {
//     public static void main(String[] args) {
//         int[][] nums = {
//                 { 1, 2, 3 },
//                 { 4, 5, 6 },
//                 { 7, 8, 9 }
//         };
//         int top = 0;
//         int bottom = nums.length - 1;

//         int left = 0;
//         int right = nums[0].length - 1;

//         // Top row
//         for (int col = left; col <= right; col++) {
//             System.out.print(nums[top][col] + " ");
//         }

//         // Right column
//         for (int row = top + 1; row <= bottom; row++) {
//             System.out.print(nums[row][right] + " ");
//         }

//         // Bottom row
//         for (int col = right - 1; col >= left; col--) {
//             System.out.print(nums[bottom][col] + " ");
//         }

//         // Left column
//         for (int row = bottom - 1; row > top; row--) {
//             System.out.print(nums[row][left] + " ");
//         }
//     }
// }

public class matrix_traversal {
    public static void main(String[] args) {
        int[][] nums = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int top = 0;
        int bottom = nums.length - 1;

        int left = 0;
        int right = nums[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) {
                System.out.print(nums[top][col] + " ");
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                System.out.print(nums[row][right] + " ");
            }
            right--;
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    System.out.print(nums[bottom][col] + " ");
                }
                bottom--;
            }
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    System.out.print(nums[row][left] + " ");
                }
                left++;
            }
        }
    }
}
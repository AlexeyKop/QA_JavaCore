/*
2. Написать функцию, возвращающую разницу между самым большим и самым ма-
леньким элементами переданного не пустого массива.
 */

public class ArrayDifference {

    public static int findDifference(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        
        // Проходим по всем элементам массива
        for (int num : nums) {
            if (num > max) { 
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        
        return max - min;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 3, 5, 6};
        int[] arr2 = {7, 2, 12, 9};
        int[] arr3 = {2, 9, 7, 2};

        // Вывод результатов
        System.out.println(findDifference(arr1));
        System.out.println(findDifference(arr2));
        System.out.println(findDifference(arr3));
    }
}

/*
3. Написать функцию, возвращающую истину, если в переданном массиве есть два
соседних элемента, с нулевым значением.
 */


public class ArrayZeroPoint {

    public static boolean hasTwoConsecutiveZeros(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 0, 0, 3, 4};
        int[] arr2 = {0, 1, 2, 3, 0};
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {0, 0};

        // Вывод результатов
        System.out.println(hasTwoConsecutiveZeros(arr1));
        System.out.println(hasTwoConsecutiveZeros(arr2));
        System.out.println(hasTwoConsecutiveZeros(arr3));
        System.out.println(hasTwoConsecutiveZeros(arr4));
    }
}

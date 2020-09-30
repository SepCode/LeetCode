package _1_排序_数组;

public class _剑指_Offer_11_旋转数组的最小数字 {
    public int minArray(int[] numbers) {

        if (numbers.length < 2) return numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > numbers[i]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}

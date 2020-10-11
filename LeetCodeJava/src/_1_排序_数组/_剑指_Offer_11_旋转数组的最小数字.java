package _1_排序_数组;

public class _剑指_Offer_11_旋转数组的最小数字 {
    public int minArray(int[] numbers) {

        if (numbers.length < 2) return numbers[0];
        // 987612345
        int begin = 0, end = numbers.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (numbers[end - 1] > numbers[mid]) {
                end = mid;
            } else if (numbers[end - 1] < numbers[mid]) {
                begin = mid;
            } else {
                end--;
            }
        }

        return numbers[begin];
    }

    public int minArray1(int[] numbers) {

        if (numbers.length < 2) return numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > numbers[i]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}

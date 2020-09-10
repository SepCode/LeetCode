package _3_栈_队列;

public class _739_每日温度 {
    public int[] dailyTemperatures(int[] T) {
    	
    	//										i	j
//    	temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
//    		你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

    	
    	// 倒推法
    	if (T == null || T.length == 0) {
			return null;
		}
    	int[] values = new int[T.length];
    	for (int i = T.length - 2; i >= 0; i--) {
			int j = i + 1;
			
			while (true) {
				
				if (T[i] < T[j]) {
					values[i] = j - i;
					break;
				} else if (values[j] == 0) {
					values[i] = 0;
					break;
				} else {
					j = values[j] + j;
				}
				
				
			}
		}
    	
    	
    	return values;
    	
    	
    	
    	
    	
    	// 栈
//    	Stack<Integer> stack = new Stack<Integer>();
//    	int[] nums = new int[T.length];
//    	for (int i = 0; i < T.length; i++) {
//			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
//				int t = stack.pop();
//				nums[t] = i - t;
//			}
//			stack.push(i);
//		}
//    	return nums;	
    }
}

package _4_字符串;

import java.util.Arrays;
import java.util.HashMap;

public class _1048_最长字符串链 {
    public int longestStrChain(String[] words) {

        //输入：["a","b","ba","bca","bda","bdca"]
        //输出：4
        //解释：最长单词链之一为 "a","ba","bda","bdca"


        // 思路：先按照长度排序，存入map，dp[i]是以单词i结尾的最长长度，以单词为key存入dp，
        //      遍历以i结尾的单词，删除其中一个字符，在map中查找dp最大值;

        // 思路2：遍历单词列表，判断a是否是b的前身，在map中查找a的dp;


        Arrays.sort(words, (a, b)->{ return  a.length() - b.length();});

        HashMap<String, Integer> dp = new HashMap();
        int max = 0;
        for (String w: words) {
            int subMax = 0;
            for (int i = 0; i < w.length(); i++) {
                String str = w.substring(0, i) + w.substring(i + 1);
                subMax = Math.max(subMax, dp.getOrDefault(str, 0) + 1);
            }
            dp.put(w, subMax);
            max = Math.max(max, subMax);
        }



        return max;
    }
}

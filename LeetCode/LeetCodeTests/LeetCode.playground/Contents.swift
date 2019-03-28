import UIKit

class Solution {
    func lengthOfLongestSubstring(_ s: String) -> Int {
        
        var map = [Character:Int]()
        var result = 0
        var j = 0
        
        var str = Array(s)
        
        for index in 0..<str.count {
            
            let char = str[index]
            if let num = map[char] {
                if num >= j {
                    j = num + 1
                }
            }
            result = max(result, index + 1 - j)
            map[char] = index

        }
        
        return result
    }
}

print(Solution().lengthOfLongestSubstring("afsfsiwefhkskbuaywyexverfb"))




class Solution1 {
    func longestCommonPrefix(_ strs: [String]) -> String {
        if strs.count == 0 {
            return ""
        }
        
        var stop = false
        
        var prefix = Array(strs[0])
        for i in 1..<strs.count {
            let otherStr = Array(strs[i])
            var j = 0
            
            while j < prefix.count && !stop {
                if j >= otherStr.count || prefix[j] != otherStr[j] {
                    stop = true
                }
                if !stop {
                    j = j + 1;
                }
            }
            prefix.removeSubrange(Range(NSRange(location: j, length: prefix.count - j))!)
            
            
        }
        return String(prefix)
        
    }
}

print(Solution1().longestCommonPrefix(["sepcod","sep","sepc","sepcode"]))





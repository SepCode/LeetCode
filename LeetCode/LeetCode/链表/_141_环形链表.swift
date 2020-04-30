//
//  _141_环形链表.swift
//  LeetCode
//
//  Created by CF on 2020/4/30.
//  Copyright © 2020 CF. All rights reserved.
//  https://leetcode-cn.com/problems/linked-list-cycle/

import XCTest

class Solution {
    func hasCycle(_ head: ListNode?) -> Bool {
        if head == nil || head?.next == nil {
            return false
        }
        var slow = head
        var fast = head?.next
        while fast != nil && fast?.next != nil {
            if slow === fast! {
                return true
            }
            slow = slow?.next
            fast = fast?.next?.next
        }
        
        
        return false
    }
}

class _141_____: XCTestCase {

    override func setUp() {
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testExample() {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
        let head = ListNode(3)
        let next1 = ListNode(2)
        let next2 = ListNode(0)
        let next3 = ListNode(-4)
        head.next = next1
        next1.next = next2
        next2.next = next3
        next3.next = next1
        
        let solution = Solution()
        print("*************" + String(solution.hasCycle(head)))
        
    }

    func testPerformanceExample() {
        // This is an example of a performance test case.
        self.measure {
            // Put the code you want to measure the time of here.
        }
    }

}

//
//  ListNode.swift
//  LeetCode
//
//  Created by CF on 2020/4/30.
//  Copyright © 2020 CF. All rights reserved.
//

import Foundation


//Definition for singly-linked list.
public class ListNode {
    public var val: Int
    public var next: ListNode?
    public init(_ val: Int) {
        self.val = val
        self.next = nil
    }
}

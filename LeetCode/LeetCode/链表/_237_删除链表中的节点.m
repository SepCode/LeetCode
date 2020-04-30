//
//  _237_删除链表中的节点.m
//  LeetCode
//
//  Created by CF on 2020/4/30.
//  Copyright © 2020 CF. All rights reserved.
//  https://leetcode-cn.com/problems/delete-node-in-a-linked-list/

#import <XCTest/XCTest.h>

void deleteNode(struct ListNode* node) {
    node->val = node->next->val;
    node->next = node->next->next;
}

@interface _237_________ : XCTestCase

@end

@implementation _237_________

- (void)setUp {
    // Put setup code here. This method is called before the invocation of each test method in the class.
}

- (void)tearDown {
    // Put teardown code here. This method is called after the invocation of each test method in the class.
}

- (void)testExample {
    // This is an example of a functional test case.
    // Use XCTAssert and related functions to verify your tests produce the correct results.
    
    struct ListNode next3 = {9,nil};
    struct ListNode next2 = {1,&next3};
    struct ListNode next1 = {5,&next2};
    struct ListNode head = {4,&next1};
    
    struct ListNode *pHead = &head;
    struct ListNode *pDelHead = &head;
    printf("\n");
    while (pHead != nil) {
        printf("%d,",pHead->val);
        pHead = pHead->next;
    }
    
    deleteNode(&next1);
    printf("\n");
    
    while (pDelHead != nil) {
        printf("%d,",pDelHead->val);
        pDelHead = pDelHead->next;
    }
    printf("\n");
}

- (void)testPerformanceExample {
    // This is an example of a performance test case.
    [self measureBlock:^{
        // Put the code you want to measure the time of here.
    }];
}

@end

//
//  LeetCodeTests.m
//  LeetCodeTests
//
//  Created by CF on 2019/3/27.
//  Copyright © 2019 SepCode. All rights reserved.
//

#import <XCTest/XCTest.h>

@interface LeetCodeTests : XCTestCase

@end

@implementation LeetCodeTests

- (void)setUp {
    // Put setup code here. This method is called before the invocation of each test method in the class.
}

- (void)tearDown {
    // Put teardown code here. This method is called after the invocation of each test method in the class.
}

- (void)testExample {
    // This is an example of a functional test case.
    // Use XCTAssert and related functions to verify your tests produce the correct results.
    NSInteger result = 0, a = 1, b = 2;
    for (NSInteger i = 3; i <= 3; i++) {
        result = a + b;
        a = b;
        b = result;
    }
    NSLog(@"--%ld",(long)result);
}

- (void)testPerformanceExample {
    // This is an example of a performance test case.
    [self measureBlock:^{
        // Put the code you want to measure the time of here.
    }];
}









- (void)testTowSum {
    
    NSMutableDictionary *map = [NSMutableDictionary new];
    NSArray *array = @[@(2),@(7),@(11),@(15)], *result;
    int sum = 9;
    
    for (int i = 0; i < array.count; i++) {
        
        id index = map[@(sum - [array[i] intValue])];
        if (index) {
            result = @[@(i),index];
            break;
        } else {
            map[array[i]] = @(i);
        }
        
    }
    
    NSLog(@"--%@",result);
    
    
}


struct ListNode {
    int val;
    struct ListNode *next;
};

- (void)testAddTwoNumbers {
    // 创建链表
    NSArray *array1 = @[@(2),@(4),@(3)], *array2 = @[@(5),@(6),@(4)];
    struct ListNode *l1 = (struct ListNode *)malloc(sizeof(struct ListNode));
    struct ListNode *l2 = (struct ListNode *)malloc(sizeof(struct ListNode));
    struct ListNode *node1 = l1;
    struct ListNode *node2 = l2;
    
    for (int i = 0; i < 3; i++) {
        node1->val = [array1[i] intValue];
        node2->val = [array2[i] intValue];
        if (i < 3 - 1) {
            node1->next = (struct ListNode *)malloc(sizeof(struct ListNode));
            node2->next = (struct ListNode *)malloc(sizeof(struct ListNode));
            node1 = node1->next;
            node2 = node2->next;
        } else {
            node1->next = NULL;
            node2->next = NULL;
        }
    }
    
    // 计算和
    
    node1 = l1;
    node2 = l2;
    struct ListNode *result = (struct ListNode *)malloc(sizeof(struct ListNode));
    struct ListNode *temp = result;
    
    int carry = 0;
    while (node1 || node2) {
        int num1 = node1 ? node1->val : 0;
        int num2 = node2 ? node2->val : 0;
        int sum = num1 + num2 + carry;
        carry = sum / 10;
        temp->val = sum % 10;
        
        node1 = node1->next;
        node2 = node2->next;
        
        if (node1 || node2 || carry > 0) {
            temp->next = (struct ListNode *)malloc(sizeof(struct ListNode));
            temp = temp->next;
        } else {
            temp->next = NULL;
        }
    }
    
    // 打印
    temp = result;
    while (temp) {
        NSLog(@"--%d",temp->val);
        temp = temp->next;
    }
    
    
}


- (void)testLongestSubString {
    
    NSString *str = @"ababbfcdrgffsfwefs";
    
    //
    
    NSMutableDictionary *map = [NSMutableDictionary new];
    NSInteger result = 0;
    for (NSInteger i = 0, j = 0; i < str.length; i++) {

        unichar tempchar = [str characterAtIndex:i];
        NSNumber *index = map[@(tempchar)];
        if (index) {
            NSInteger indexValue = [index intValue];
            if (indexValue >= j) {
                j = indexValue + 1;
            }
            
        }
        result = MAX(result, i + 1 - j);
        map[@(tempchar)] = @(i);
    }
    
    NSLog(@"--%ld",result);
    
}

- (void)testLongestCommonPrefix {
    
    NSArray *array = @[@"sepcod",@"sep",@"sepc",@"sepcode"];
    
    if (!array.count) return;
    
    BOOL stop = NO;
    NSString *result = @"";
    NSString *str1 = array[0];
    for (int i = 0; i < str1.length && !stop; i++) {
        unichar prefix = [str1 characterAtIndex:i];
        for (int j = 1; j < array.count; j++) {
            NSString *otherStr = array[j];
            if (otherStr.length <= i || prefix != [otherStr characterAtIndex:i]) {
                stop = YES;
            }
        }
        if (!stop) {
            result = [result stringByAppendingFormat:@"%c",prefix];
        }
        
    }
    
    NSLog(@"--%@",result);
    
}


- (void)testCheckInclusion {
    
    
    NSLog(@"--%d",checkInclusion("dd","rroddzkdktk"));
    
    
}

bool checkInclusion(char* s1, char* s2) {
    unsigned long count1 = strlen(s1);
    unsigned long count2 = strlen(s2);
    
    if (count1 > count2) {
        return false;
    }
    
    int n1[26] = {0}, n2[26] = {0};
    
    for (int i = 0; i < count1; i++) {
        n1[s1[i] - 'a']++;
        n2[s2[i] - 'a']++;
    }
    
    for (int i = 0; i < count2 - count1; i++) {
        if (ccomp(n1,n2)) {
            return true;
        }
        
        n2[s2[i + count1] - 'a']++;
        n2[s2[i] - 'a']--;
        
    }

    return ccomp(n1,n2);
}

bool ccomp(int *n1, int *n2) {
    for (int i = 0; i < 26; i++) {
        if (n1[i] != n2[i]) {
            return false;
        }
    }
    return true;
}

- (void)testMultiply {
    
    
    
    
}

/*
 
 
  4 5 6
  *   9
  -----
4 5 5
  1 0 4
--------
4 6 5 4
 
 */

char* multiply(char* num1, char* num2) {
    
    int n1 = (int)strlen(num1);
    int n2 = (int)strlen(num2);
    
    char *result = 0;
    
    char *result_sum = 0;
    for (int i = n1 - 1; i >= 0; i--) {
        //  被乘数
        int m_i = num1[i] - '0';
        int carry = 0;
        char *result_i = 0;
        for (int j = n2 - 1; j >= 0; j--) {
            // 乘数
            int m_j = num2[j] - '0';
            
            int mul = (m_i * m_j) + carry;
            carry = mul / 10;
            result_i[j] = carry % 10 + '0';
        }
        
        if (carry >= 0) {
            result_i[n2] = carry + '0';
        }
        
        int sumlen = (int)strlen(result_sum);
        for (int k = sumlen - 1 - i; k >= 0; k--) {
            
            
            
        }
        
    }
    
    
    
    return result;
}

@end

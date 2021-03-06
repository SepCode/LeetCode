//
//  LeetCodeTests.m
//  LeetCodeTests
//
//  Created by CF on 2019/3/27.
//  Copyright © 2019 SepCode. All rights reserved.
//

#import <XCTest/XCTest.h>
#define MYMAX(x,y) ((x) > (y) ? (x) : (y))

@interface LeetCodeTests : XCTestCase

@end

@implementation LeetCodeTests

- (void)setUp {
    // Put setup code here. This method is called before the invocation of each test method in the class.
}

- (void)tearDown {
    // Put teardown code here. This method is called after the invocation of each test method in the class.
}

- (void)testdefine {
    NSLog(@"--%d", MYMAX(10, 1));
}

- (void)testprint {
    int a[5] = {1, 2, 3, 4, 5};
    int *ptr = (int *)(&a);
    printf("--%d, %d", *(a + 1), *ptr + 1);
}

- (void)teststackPrint {
    int b = 10;
    int c = 1;
    int *d = &b;
    int *e = &c;
    int *a[2] = {d,e};
    int **ptr = (int **)(&a + 1);
    printf("--%d, %d", **(a + 1), **(ptr - 1));
    printf("--%p, %p", &b, &c);
    printf("--%p, %p", &a, d);
    printf("--%d, %d", *(&c + 1), b);
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

/*
 
 
 4 5 6
 *   9
 -----
 4 5 5
 1 0 4
 --------
 4 6 5 4
 
 */
- (void)testMultiply {
    
    
    NSLog(@"%s", multiply("123", "456"));
    
}


char* multiply(char* num1, char* num2) {
    
    
    int n1 = (int)strlen(num1);
    int n2 = (int)strlen(num2);
    if ((n1 == 1 && num1[0] == '0') || (n2 == 1 && num2[0] == '0')) {
        return "0";
    }
    
    char *result = malloc(n1 + n2);
    memset(result, 0, n1 + n2);
    for (int i = 0; i < n1 + n2; i++) {
        result[i] = '0';
    }
    
    for (int i = n1 - 1; i >= 0; i--) {
        //  被乘数
        int m_i = num1[i] - '0';
        int mulCarry = 0;
        int addCarry = 0;
        for (int j = n2 - 1; j >= 0; j--) {
            // 乘数
            int m_j = num2[j] - '0';
            
            int mul = (m_i * m_j) + mulCarry + addCarry;
            mulCarry = mul / 10;
            int temp = mul % 10;
            
            int addMul = result[i + j + 1] + temp - '0';
            addCarry = addMul / 10;
            result[i + j + 1] = addMul % 10 + '0';
            
        }
        result[i] += mulCarry + addCarry;
        
    }
    if (result[0] == '0') {
        result++;
    }
    
    return result;
}


- (void)testReverseWords {
    
    printf("%s", reverseWords("a good   example"));
}


char* reverseWords(char* s) {
    int len = (int)strlen(s);
    char *result = malloc(len + 1);
    memset(result, '0', len + 1);
    char *p1 = s + len - 1;
    char *p2 = p1;
    for (int i = len - 1; i >= 0; i--) {
        p1 = s + i;
        bool equal = s[i] == ' ';
        if (equal || i == 0) {
            // 截取到新字符串
            
            if (equal) {
                p1++;
            }
            
            if (p1 <= p2) {
                if (strlen(result) != 0) {
                    strcat(result, " ");
                }
                strncat(result, p1, p2 - p1 + 1);
            }
            if (i != 0) {
                p2 = s + i - 1;
            }
        }
    }
    
    return result;
}



int remove_blank(char *s, int len) {
    int i, cur;
    int flag = 0;
    for (i = 0; i < len; ++i) {
        if (s[i] != ' ')
            break;
    }
    
    while (len > i) {
        if (s[len - 1] == ' ') {
            len--;
        } else {
            break;
        }
    }
    
    for (cur = 0; i < len; ) {
        if (s[i] != ' ') {
            *(s + cur) = *(s + i);
            cur++;
            i++;
            flag = 0;
        } else if (flag) {
            i++;
        } else {
            *(s + cur) = *(s + i);
            cur++;
            i++;
            flag = 1;
        }
    }
    
    *(s + cur) = '\0';
    return cur;
}

void r(char *s, int len) {
    int i = 0;
    char c;
    while (i < len - 1) {
        c = *(s + i);
        *(s + i) = *(s + len - 1);
        *(s + len - 1) = c;
        
        i++;
        len--;
    }
}

void reverseWords1(char *s) {
    if (s == NULL) {
        return;
    }
    
    int len = strlen(s);
    len = remove_blank(s, len);
    //    std::cout << s << std::endl;
    int i, cur;
    
    for (i = 0, cur = i; i < len; i++) {
        if (s[i] == ' ') {
            r(s + cur, i - cur);
            cur = i + 1;
            i = cur;
        }
        
        if (i == len - 1) {
            r(s + cur, i - cur + 1);
        }
    }
    
    r(s, len);
}

char *reverseWords2(char *s) {
    char *p = s;
    int len = strlen(s);
    char *sr = malloc(len*sizeof(char)+1);
    if (sr == NULL) {
        return NULL;
    }
    memset(sr, 0, len*sizeof(char)+1);
    int i, end;
    while(*p == ' ') {
        p++;
    }
    //printf("the s len:%d, the *p:%c\n", len, *p);
    for (end = len-1; end>=0; end--) {
        if (s[end] == ' ') {
            s[end] = '\0';
        } else {
            break;
        }
    }
    //printf("the end:%d,s[end]:%c\n", end, s[end]);
    for (i=end; i>= p-s; i--) {
        if (s[i] == ' ' && s[i+1] != ' ' && s[i+1] != '\0' ) {
            s[i] = '\0';
            strcat(sr, s+i+1);
            strcat(sr, " ");
            //      printf("the s+i+1:%s", s+i+1);
        }
        if (s[i] == ' ') {
            s[i] = '\0';
        }
    }
    strcat(sr, p);
    return sr;
    
}


- (void)testisPalindrome {
    isPalindrome2(1110);
}

bool isPalindrome(int x) {
 
    if (x < 0) {
        return false;
    }
    int y = x;
    long rec = 0;
    while (x != 0) {
        int pop = x % 10;
        x /= 10;
        rec = rec * 10 + pop;
    }
    if (y == x) {
        return true;
    } else {
        return false;
    }
    
}

bool isPalindrome2(int x) {
    
    if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false;
    }
    int rec = 0;
    while (x > rec) {
        rec = rec * 10 + x % 10;
        x /= 10;
    }
    if (x == rec || x == rec / 10) {
        return true;
    }
    return false;
    
}

- (void)testromanToInt {
    romanToInt("IXIVI");
}

int roman(char r) {
    switch (r) {
        case 'I':
            return 1;
            break;
        case 'V':
            return 5;
            break;
        case 'X':
            return 10;
            break;
        case 'L':
            return 50;
            break;
        case 'C':
            return 100;
            break;
        case 'D':
            return 500;
            break;
        case 'M':
            return 1000;
            break;
    }
    return 0;
}
int romanToInt(char* s) {
 
    int len = (int)strlen(s);
    
    int result = roman(s[len - 1]);
    for (int i = len - 2; i >= 0; i--) {
        int l = roman(s[i]);
        int r = roman(s[i + 1]);
        if (l >= r) {
            result += l;
        } else {
            result -= l;
        }
    }
    return result;
}


- (void)testrestoreIpAddresses {
    int size = 0;

    printf("%s",restoreIpAddresses("25525511135", &size)[0]);
//    NSMutableArray *array = [NSMutableArray new];
//    [self restoreIpAddress:@"25525511135" res:@"" array:array count:0];
//    NSLog(@"%@", array);
}
/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
char** restoreIpAddresses(char* s, int* returnSize) {
    char* *sArray = malloc(sizeof(char *));
    char *res = malloc(strlen(s) + 3);
    res = "";
    addIpAddress(s, res, sArray, returnSize, 0);
    return sArray;
}

- (void)restoreIpAddress:(NSString *)str res:(NSString *)res array:(NSMutableArray *)array count:(NSUInteger)count {
    
    if (str.length / 3.0 > 4 - count) {
        return;
    }
    
    if (count == 4 && !str.length) {
        [array addObject:res];
        return;
    }
    
    for (int i = 1; i < 4 && i <= str.length; i++) {
        
        NSString *sub = [str substringToIndex:i];
        if (sub.integerValue > 255 || (sub.length > 1 && [sub characterAtIndex:0] == '0')) return;
        
        NSString *nextRes = [NSString stringWithFormat:@"%@%@%@",res,sub,(count == 3 ? @"" : @".")];
        [self restoreIpAddress:[str substringFromIndex:i] res:nextRes array:array count:count + 1];
        
    }
    
    
    
}






void addIpAddress(char *s, char *res, char* *sArray, int *returnSize, int count);
void addIpAddress(char *s, char *res, char* *sArray, int *returnSize, int count) {
    long sLen = strlen(s);
    if (count > 4 - (sLen / 3.0)) {
        return;
    }
    
    if (count == 4 && sLen == 0) {
        sArray[*returnSize] = res;
        (*returnSize)++;
        return;
    }
    
    for (int i = 1; i <= 3 && i < sLen; i++) {
        char *s1 = malloc(i);
        strncpy(s1, s, i);
        if (((s1[0] == '0' && strlen(s1) == 1) || s1[0] != '0') && atoi(s1) <= 255) {
            
            char *next = s + i;
            char *nextRes = strncat(res, s1, i);
            nextRes = strcat(nextRes, count == 3 ? "" : ".");
            addIpAddress(next, nextRes, sArray, returnSize, count++);
        } else {
            return;
        }
        
    }
}

- (void)testReserveStr {
    NSLog(@"--%@", [self func:@"Antyum"]);
}

- (NSString *)func:(NSString *)str {
    return str.length ? [NSString stringWithFormat:@"%@%@",[self func:[str substringFromIndex:1]],[str substringToIndex:1]] : @"";
}

- (void)testQuickSort {
    int array[] = {1,5,8,3,6,9};
    int r = sizeof(array) / sizeof(int);
    quickSort(array, 0, r - 1);
    for (int i = 0; i < r; i++) {
        
        NSLog(@"%d",array[i]);
    }
}

int *quickSort(int *array, int l, int r) {
    if (l < r) {
        int left = l, right = r;
        int pivot = array[right];
        
        while (left < right) {
            while (array[left] <= pivot && left < right) {
                left++;
            }
            if (left < right) {
                array[right] = array[left];
            }
            while (array[right] >= pivot && left < right) {
                right--;
            }
            if (left < right) {
                array[left] = array[right];
            }
            
        }
        array[left] = pivot;
        
        quickSort(array, l, left - 1);
        quickSort(array, left + 1, r);
        
    }
    
    return array;
}

void mergeSort(int array[], int l, int mid, int r, int temp[]) {
    int lStart = l, lEnd = mid, rStart = mid + 1, rEnd = r;
    int tempCount = 0;
    while (lStart <= lEnd && rStart <= rEnd) {
        if (array[lStart] < array[rStart]) {
            temp[tempCount++] = array[lStart++];
        } else {
            temp[tempCount++] = array[rStart++];
        }
    }
    
    while (lStart <= lEnd) {
        temp[tempCount++] = array[lStart++];
    }
    
    while (rStart <= rEnd) {
        temp[tempCount++] = array[rStart++];
    }
    int i = 0;
    while (i < tempCount) {
        array[l + i] = temp[i];
        i++;
    }
    
}

void merge(int array[], int l, int r, int temp[]) {
    if (l >= r) {
        return;
    }
    int mid = (l + r) / 2;
    merge(array,l, mid, temp);
    merge(array,mid + 1, r, temp);
    if (array[mid] <= array[mid + 1]) {
        return;
    }
    mergeSort(array, l, mid, r, temp);
    
}




- (void)testMergeSort {
    int array[] = {4,3,5,2,7,1,9,8,6};
    int len = sizeof(array) / sizeof(int);
    int *temp = malloc(len + 1);
//    memset(temp, 0, len);
    merge(array, 0, len -1, temp);
    for (int i = 0; i < len; i++) {
        
        printf("%d",array[i]);
    }
    free(temp);
}



@end

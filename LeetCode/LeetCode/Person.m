//
//  Person.m
//  LeetCode
//
//  Created by CF on 2019/4/8.
//  Copyright © 2019 SepCode. All rights reserved.
//

#import "Person.h"

@implementation Person
+ (instancetype)objc {
    return [Person new];
}

- (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey,id> *)change context:(void *)context {
    NSLog(@"--");
}
@end

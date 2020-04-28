//
//  Person.h
//  LeetCode
//
//  Created by CF on 2019/4/8.
//  Copyright © 2019 SepCode. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface Person : NSObject <NSCopying>
///
@property (nonatomic, strong) NSString *firstName;
+ (instancetype)objc;
@end

NS_ASSUME_NONNULL_END

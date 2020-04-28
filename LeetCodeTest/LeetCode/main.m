//
//  main.m
//  LeetCode
//
//  Created by CF on 2019/3/27.
//  Copyright © 2019 SepCode. All rights reserved.
//

//#import <UIKit/UIKit.h>
#import "AppDelegate.h"
#import <Foundation/Foundation.h>



int main(int argc, char * argv[]) {
//    __block int b = 10;
//    void (^c)() = ^{
//        printf("%d",b++);
//    };
//    b++;
//    c();
//    __strong id d = c;
//    NSLog(@"%@",d);
//    NSLog(@"%@",c);
    
//    __autoreleasing NSObject *obj = [[NSObject alloc] init];
//    NSLog(@"%@", obj);
//    NSObject *obj2 = obj;
//    NSLog(@"--%@",obj2);

    @autoreleasepool {
////        CFRunLoopObserverRef observer = CFRunLoopObserverCreateWithHandler(kCFAllocatorDefault, kCFRunLoopAllActivities, YES, 0, ^(CFRunLoopObserverRef observer, CFRunLoopActivity activity) {
////
////            /*
////             kCFRunLoopEntry = (1UL << 0),          进入工作
////             kCFRunLoopBeforeTimers = (1UL << 1),   即将处理Timers事件
////             kCFRunLoopBeforeSources = (1UL << 2),  即将处理Source事件
////             kCFRunLoopBeforeWaiting = (1UL << 5),  即将休眠
////             kCFRunLoopAfterWaiting = (1UL << 6),   被唤醒
////             kCFRunLoopExit = (1UL << 7),           退出RunLoop
////             kCFRunLoopAllActivities = 0x0FFFFFFFU  监听所有事件
////             */
////            switch (activity) {
////                case kCFRunLoopEntry:
////                    NSLog(@"进入");
////                    break;
////                case kCFRunLoopBeforeTimers:
////                    NSLog(@"即将处理Timer事件");
////                    break;
////                case kCFRunLoopBeforeSources:
////                    NSLog(@"即将处理Source事件");
////                    break;
////                case kCFRunLoopBeforeWaiting:
////                    NSLog(@"即将休眠");
////                    break;
////                case kCFRunLoopAfterWaiting:
////                    NSLog(@"被唤醒");
////                    break;
////                case kCFRunLoopExit:
////                    NSLog(@"退出RunLoop");
////                    break;
////                default:
////                    break;
////            }
////        });
////
////        CFRunLoopAddObserver(CFRunLoopGetCurrent(), observer, kCFRunLoopDefaultMode);
         return UIApplicationMain(argc, argv, nil, NSStringFromClass([AppDelegate class]));
    }
}

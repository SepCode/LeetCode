//
//  ViewController.m
//  LeetCode
//
//  Created by CF on 2019/3/27.
//  Copyright © 2019 SepCode. All rights reserved.
//

#import "ViewController.h"
#import <objc/runtime.h>
//#import <objc/runLoop.h>

@interface ViewController (){
    NSObject *_name;
}
@property (nonatomic, strong) dispatch_semaphore_t semaphore;
@property (nonatomic) CFRunLoopActivity obj;
@property (nonatomic) NSUInteger timeCount;
@property(nullable, nonatomic,copy) NSArray *title;
@end


@implementation ViewController
@synthesize timeCount = _timeCount;
@synthesize title = _titleArray;
- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    NSLog(@"%@",NSStringFromClass(self.superclass));
    self.timeCount = 10.0;
    [self registerObserver];
}

- (NSUInteger)timeCount {
    return _timeCount;
}

- (void)setTimeCount:(NSUInteger)timeCount {
    _timeCount = timeCount;
}



    
- (void)registerObserver
{
//    CFRunLoopObserverContext context = {0,(__bridge void*)self,NULL,NULL};
    CFRunLoopObserverRef observer = CFRunLoopObserverCreateWithHandler(kCFAllocatorDefault, kCFRunLoopAllActivities, YES, 0, ^(CFRunLoopObserverRef observer, CFRunLoopActivity activity) {
        self.obj = activity;
        dispatch_semaphore_signal(self.semaphore);
    });
    CFRunLoopAddObserver(CFRunLoopGetMain(), observer, kCFRunLoopCommonModes);
    
    // 创建信号
    _semaphore = dispatch_semaphore_create(0);
    
    // 在子线程监控时长
    dispatch_async(dispatch_get_global_queue(0, 0), ^{
        while (YES)
        {
            // 假定连续5次超时50ms认为卡顿(当然也包含了单次超时250ms)
            long st = dispatch_semaphore_wait(self->_semaphore, dispatch_time(DISPATCH_TIME_NOW, 50*NSEC_PER_MSEC));
            if (st != 0)
            {
                if (self.obj==kCFRunLoopBeforeSources || self.obj==kCFRunLoopAfterWaiting)
                {
                    if (++self->_timeCount < 5)
                        continue;
                    // 检测到卡顿，进行卡顿上报
                }
            }
            self->_timeCount = 0;
        }
    });
}

@end

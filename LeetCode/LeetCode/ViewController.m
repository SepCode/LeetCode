//
//  ViewController.m
//  LeetCode
//
//  Created by CF on 2019/3/27.
//  Copyright © 2019 SepCode. All rights reserved.
//

#import "ViewController.h"
#import <objc/runtime.h>
<<<<<<< HEAD
#import "Person.h"

typedef struct {
    int a, b, c;
} TestStruct;
=======
//#import <objc/runLoop.h>
>>>>>>> abe05096e4119cf123c2fdcb573e8b2661c68f8f

@interface ViewController (){
    NSObject *_name;
}
<<<<<<< HEAD

@property (nonatomic, strong) Person *obj;
=======
@property (nonatomic, strong) dispatch_semaphore_t semaphore;
@property (nonatomic) CFRunLoopActivity obj;
@property (nonatomic) NSUInteger timeCount;
@property(nullable, nonatomic,copy) NSArray *title;
>>>>>>> abe05096e4119cf123c2fdcb573e8b2661c68f8f
@end


@implementation ViewController
@synthesize timeCount = _timeCount;
@synthesize title = _titleArray;
- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
<<<<<<< HEAD
    
    self.obj = [Person new];
    self.obj.firstName = @"sep";
    [self addObserver:self forKeyPath:@"obj.firstName" options:NSKeyValueObservingOptionNew context:nil];
    self.obj.firstName = @"code";
//    dispatch_queue_t queue = dispatch_queue_create("test", DISPATCH_QUEUE_CONCURRENT);
//    for (int i = 0; i < 100000; ++i) {
//        dispatch_async(queue, ^{
//
//            self.obj = [NSObject new];
//        });
//        str = [str lowercaseString];
//        str = [str stringByAppendingString:@"xyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyzxyz"];
//        NSLog(@"%@", str);
//    }
    
//    TestStruct test = {1, 2, 3};
//    NSValue *testValue = [NSValue value:&test withObjCType:@encode(TestStruct)];
//    NSArray *array = @[@(1),@"123",testValue];
//    [self performSelector:@selector(testMoreObj:) withObject:array];
}

//- (void)testMoreObj:(NSArray *)array {
//    NSValue *value = array[2];
//    
//    TestStruct test;
//    NSUInteger size = sizeof(TestStruct);
//    [value getValue:&test size:size];
//    NSLog(@"%d", test.a);
//    
//}
=======
    NSLog(@"%@",NSStringFromClass(self.superclass));
    self.timeCount = 10.0;
    [self registerObserver];
}

- (NSUInteger)timeCount {
    return _timeCount;
}
>>>>>>> abe05096e4119cf123c2fdcb573e8b2661c68f8f

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

//
//  ViewController.m
//  LeetCode
//
//  Created by CF on 2019/3/27.
//  Copyright © 2019 SepCode. All rights reserved.
//

#import "ViewController.h"
#import <objc/runtime.h>
#import "Person.h"
#import "Mee.h"
#import "MyView.h"
#import "MyscrollView.h"

typedef struct {
    int a, b, c;
} TestStruct;

@interface ViewController (){
    NSObject *_name;
}

@property (nonatomic, strong) Person *obj;
@property (nonatomic, strong) dispatch_semaphore_t semaphore;
@property (nonatomic) CFRunLoopActivity activity;
@property (nonatomic, assign) NSUInteger timeCount;
@property (nullable, nonatomic,copy) NSArray *title;

@property (nonatomic, assign) void (^block)(void);
@property (nonatomic, strong) UIView *myview;
@end

void (^block2)(void) = ^{
    printf("%d",1);
};

@implementation ViewController
@synthesize timeCount = _timeCount;
@synthesize title = _titleArray;

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    

}

- (void)viewWillLayoutSubviews {
    
}
- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    MyscrollView *scroll = [[MyscrollView alloc] initWithFrame:CGRectMake(0, 0, 1000, 400)];
    scroll.contentSize = CGSizeMake(1000, 2000);
    self.myview = [[MyView alloc] init];
    [scroll addSubview:self.myview];
    [self.view addSubview:scroll];
    
    self.myview.backgroundColor = [UIColor redColor];
    
    Person *p1 = [[Person alloc] init];
    Person *p2 = [p1 copy];
    NSLog(@"%@,%@",p1,p2);
    
    NSArray *p3 = [[NSArray alloc] init];
    NSArray *p4 = [p3 copy];
    NSLog(@"%@,%@",p3,p4);
    
//    int a = 10;
//
//    self.block = ^{
//        printf("%d",a);
//    };
//
//    NSLog(@"%@",self.block);
    
    
//    NSLog(@"1");
//    dispatch_async(dispatch_get_main_queue(), ^{
//        NSLog(@"2");
//    });
//    NSLog(@"3");
//    [self testtest];
//
//    NSArray *array = @[@(1),@(2)];
//    Person *me = [Person new];
//    __block NSArray *array2 = [NSArray array];
//    [array enumerateObjectsUsingBlock:^(id  _Nonnull obj, NSUInteger idx, BOOL * _Nonnull stop) {
//        array2 = [array2 arrayByAddingObject:obj];
//        me.firstName = [NSString stringWithFormat:@"dajlfda"];
//    }];
//
//
//    [Mee class];
//    [Person class];
//    [self addObserver:self forKeyPath:@"obj.firstName" options:NSKeyValueObservingOptionNew context:nil];
//    self.obj.firstName = @"code";
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


//    NSLog(@"%@",NSStringFromClass(self.superclass));
//    self.timeCount = 10.0;
//    [self registerObserver];
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

- (void)testtest {
    NSLog(@"4");
}

- (NSUInteger)timeCount {
    return _timeCount;
}

- (void)setTimeCount:(NSUInteger)timeCount {
    _timeCount = timeCount;
}

- (void)touchesBegan:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event {
    self.myview.frame = CGRectMake(1000, 0, 10, 100);
}

    
- (void)registerObserver
{
//    CFRunLoopObserverContext context = {0,(__bridge void*)self,NULL,NULL};
    CFRunLoopObserverRef observer = CFRunLoopObserverCreateWithHandler(kCFAllocatorDefault, kCFRunLoopAllActivities, YES, 0, ^(CFRunLoopObserverRef observer, CFRunLoopActivity activity) {
        self.activity = activity;
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
                if (self.activity==kCFRunLoopBeforeSources || self.activity==kCFRunLoopAfterWaiting)
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

- (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey,id> *)change context:(void *)context {
    NSLog(@"--");
}

@end

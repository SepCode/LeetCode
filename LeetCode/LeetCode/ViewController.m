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

typedef struct {
    int a, b, c;
} TestStruct;

@interface ViewController (){
    NSObject *_name;
}

@property (nonatomic, strong) Person *obj;
@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    
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

- (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey,id> *)change context:(void *)context {
    NSLog(@"--");
}

@end

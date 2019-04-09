//
//  ViewController.m
//  LeetCode
//
//  Created by CF on 2019/3/27.
//  Copyright © 2019 SepCode. All rights reserved.
//

#import "ViewController.h"
#import <objc/runtime.h>

@interface ViewController (){
    NSObject *_name;
}

@property (nonatomic, strong) NSObject *obj;
@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    
    
    
    [self addObserver:self forKeyPath:@"name" options:NSKeyValueObservingOptionInitial context:nil];
    [self setValue:@(1) forKey:@"name"];
    
}


- (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey,id> *)change context:(void *)context {
    NSLog(@"--");
}

@end

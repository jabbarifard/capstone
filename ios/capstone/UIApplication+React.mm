#import <Foundation/Foundation.h>

#import "React/RCTBridge.h"
#import "React/RCTBundleURLProvider.h"
#import "UIKit/UIKit.h"

@implementation UIApplication (UIApplicationReact)

- (NSURL *)sourceBundleURL {
#if DEBUG
  return [[RCTBundleURLProvider sharedSettings] jsBundleURLForBundleRoot:@"index"];
#else
  return [[NSBundle mainBundle] URLForResource:@"main" withExtension:@"jsbundle"];
#endif
}
@end


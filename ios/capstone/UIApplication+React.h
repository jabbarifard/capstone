//
//  UIApplication+React.h
//

#ifndef UIApplication_React_h
#define UIApplication_React_h

#import <Foundation/Foundation.h>

@interface UIApplication (UIApplicationReact)
//// MARK: - sourceURLForBridge
@property(readonly, nullable) NSURL* sourceBundleURL;
@end

#endif /* UIApplication_React_h */

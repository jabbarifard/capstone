//
//  AppDelegate.swift
//
//
//  Created by Elaheh.Jabbarifard on 2/28/23.
//

import Foundation
import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
  var window: UIWindow?
  var bridge: RCTBridge!
  func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
    let jsCodeLocation: URL
    jsCodeLocation = UIApplication.shared.sourceBundleURL!
    let rootView = RCTRootView(bundleURL: jsCodeLocation, moduleName: "capstone", initialProperties: nil, launchOptions: launchOptions)
    let rootViewController = UIViewController()
    rootViewController.view = rootView
    self.window = UIWindow(frame: UIScreen.main.bounds)
    self.window?.rootViewController = rootViewController
    self.window?.makeKeyAndVisible()
    return true
  }
}

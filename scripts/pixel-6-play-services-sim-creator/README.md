# Simulator for Google Play Services

`NOTE:` This assumes you are running on macOS.

This repository provides a script + an initial ini to create a Google API v33 + Play Services enabled Pixel 6.

Later versions of Google Play Services are not enabled for specific simulators targeting later Google devices. This prevents testing of certain cutting edge Google features on simulator, locking out developers who do not have recent Android phones from developing against them.

However, Google still publishes system images with these tools enabled. It's not clear why they do not present this option to developers within the GUI, but it is possible to still create new devices from the CLI which have the requisite functionality.

## Usage

1. Make sure that you have Android Studio installed and recent versions of the CLI tools
2. Make sure you have Java 1.8 in your path. If you use `jenv` there is a .java-version file which will hook it up to whatever you currently have installed.
3. Run the `./create-simulator.sh` script. This script will do the following:
   - Install `system-images;android-33;google_apis_playstore;x86_64` via the sdkmanager
   - Setup a simulator + copy a configuration which is a modified version of the Google Pixel 6
   - Do an initial run of the emulator. You can close this simulator after it is done booting up.
4. After that, it will be available within Android Studio and you will be able to run the simulator as you would with any other AVD device registered in Android Studio.

## Android Auto Setup

In order to run the head unit simulator against a device simulator, the Android Auto APK needs to be installed with the above simulator. It's not clear why: the instructions have not been update; why there's no alternative presented to developers; why there is no easy way in the GUI to create an APIv33 w/ Play Srevices device. But all the above are needed for Android Auto development. Therefore, a copy of the APK must be installed manually on the device.

`NOTE:` The attached APK was archived by APK Mirror, which is a reasonably reputable place to get old APKs, but it should also be possible to use your Google account with [`apkeep`](https://github.com/EFForg/apkeep) as well if you don't trust this sourcing.

1. [Ensure you have enabled developer mode on your device](https://developer.android.com/studio/debug/dev-options). By default, Android simulators should have this enabled but it doesn't hurt to double check.
2. While the simulator from the above step is running, perform the following command (This will install the Android auto app to your simulator):
   
   `adb install "$PWD/files/com.google.android.projection.gearhead_9.0.630838-release-90630838_minAPI26(x86_64)(nodpi)_apkmirror.com.apk"`
3. [Then, swipe up, go to App Settings > Apps > All Apps > Android Auto. You should see the attached screenshot](./screenshots/screenshot-1.png)
4. Tap on "Additional Settings in App". This is the only way to access the Android Auto app on later AndroidOS versions.
5. Scroll down to the bottom and tap on the version number 10 times. Enable developer mode. [It should look like this](./screenshots/screenshot-3.png)
6. Follow the remaining steps for [DHU installation](https://developer.android.com/training/cars/testing#install) and [DHU connection](https://developer.android.com/training/cars/testing#connection-adb) from the documentation. Briefly:
   - Install the necessary Android Auto developer tools from Google
   - Enable developer mode (as described in Step 5, slightly different instructions from the documentation since you can't directly open the app)
   - Start up the DHU dev server from the three dots in the top right corner. [It should look like this](./screenshots/screenshot-4.png)
   - `cd ~/Library/android/sdk/extras/google/auto`
   - Port forward 5277 `adb forward tcp:5277 tcp:5277`.
   - Startup the DHU with `./desktop-head-unit`
   - Enable permissions for the various native applications in the simulator + desktop head unit. At this point the wizard should guide you through what's left to be done.

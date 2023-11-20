package com.caresmartzagency;

import android.app.Application;

import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.imagepicker.ImagePickerPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactNativeHost;
import java.util.Arrays;
import java.util.List;

import com.facebook.react.bridge.JSIModulePackage;
//import com.swmansion.reanimated.ReanimatedJSIModulePackage;
//import com.intercom.reactnative.IntercomModule; //  <-- Add this line
import com.microsoft.codepush.react.CodePush;

//import com.reactnativecommunity.viewpager.RNCViewPagerPackage;
//import com.reactnativecommunity.viewpager.RNCViewPagerPackage;

public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost =
      new DefaultReactNativeHost(this) {
                
                @Override
                public boolean getUseDeveloperSupport() {
                    return BuildConfig.DEBUG;
                }

                @Override
                protected List<ReactPackage> getPackages() {
                    @SuppressWarnings("UnnecessaryLocalVariable")
                   List<ReactPackage> packages = new PackageList(this).getPackages();
                   return packages;
                   
                }

                @Override
                protected String getJSMainModuleName() {
                    return "index";
                }

                @Override
                protected String getJSBundleFile() {
                    return CodePush.getJSBundleFile();
                }
 @Override
        protected boolean isNewArchEnabled() {
          return BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
        }
        @Override
        protected Boolean isHermesEnabled() {
          return BuildConfig.IS_HERMES_ENABLED;
        }
                // @Override
                // protected JSIModulePackage getJSIModulePackage() {
                //     return new ReanimatedJSIModulePackage(); // <- add
                // }
            };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
        //IntercomModule.initialize(this, "android_sdk-e9ddd47fee3b6566803503b09c9a126e633972b5", "opcqxai9"); // <-- Add this line

if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
      // If you opted-in for the New Architecture, we load the native entry point for this app.
      DefaultNewArchitectureEntryPoint.load();
    }
    }

 
}

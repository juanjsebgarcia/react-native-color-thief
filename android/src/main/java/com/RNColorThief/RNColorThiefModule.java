
package com.RNColorThief;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;


public class RNColorThiefModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNColorThiefModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNColorThief";
  }

  @ReactMethod
  public void getColor(String imageUrl, int quality, boolean ignoreWhite, Promise promise) {
    int[] rgb = RNColorThief.getColor(imageUrl, quality, ignoreWhite);

    WritableMap resultData = new WritableNativeMap();
    resultData.putInt("r", rgb[0]);
    resultData.putInt("g", rgb[1]);
    resultData.putInt("b", rgb[2]);

    promise.resolve(resultData);
  }
}
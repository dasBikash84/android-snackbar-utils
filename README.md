# snackbar-ext

Utility wrapper library on Android [`Snackbar`](https://developer.android.com/reference/com/google/android/material/snackbar/Snackbar).


[![](https://jitpack.io/v/dasBikash84/snackbar-ext.svg)](https://jitpack.io/#dasBikash84/snackbar-ext)

## Dependency

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
        maven { url "https://jitpack.io" }
    }
}
```

Then, add the library to your module `build.gradle`
```gradle
dependencies {
    implementation 'com.github.dasBikash84:snackbar-ext:latest.release.here'
}
```

## Features
- Snackbar can be [`launched`](https://github.com/dasBikash84/snackbar-ext/blob/master/snackbar-utils/src/main/java/com/dasbikash/android_snackbar_utils/SnackBarUtils.kt) using `AppCompatActivity/Activity/Fragment/Any view`.
- Extension function provided for calling from `inside` of AppCompatActivity/Activity/Fragment.
- When launched from/using AppCompatActivity/Activity/Fragment Scackbar will be shown only if subject component is in `Resumed` state.
- Action text and corresponding `action task` can be added to Snackbar.
- Action task will run on `main thread`.
- Action text color and case can be customized.
- If called with a view that has to active root view, then will show `Toast` with supplied message as fall-back.

## Usage example

##### Show `short` snack from inside of `AppCompatActivity` / `Activity` / `Fragment` class body without attaching `action`
```
    showShortSnack("Snack message")
    		//or
    showShortSnack(this,"Snack message")
    		//or
    showShortSnack(snackMessageId) // snackMessageId is a String resource Id
    		//or
    SnackBarUtils.showShortSnack(this,snackMessageId) // snackMessageId is a String resource Id 
```

##### Show `long` snack from inside of `AppCompatActivity` / `Activity` / `Fragment` class body without attaching `action`
```
    showLongSnack("Snack message")
    		//or
    showLongSnack(this,"Snack message")
    		//or
    showLongSnack(snackMessageId) // snackMessageId is a String resource Id
    		//or
    SnackBarUtils.showLongSnack(this,snackMessageId) // snackMessageId is a String resource Id
```
##### Show snack from inside of `AppCompatActivity` / `Activity` / `Fragment` class body with `action`
```
    showShortSnack(message = "Snack message",actionText = "Action",
                    action = { println("Short snack with default action format")})
        
    		//or
		
    SnackBarUtils.showLongSnack(message = "Snack message",actionText = "Action",
                                action = { println("Long snack with white upper case action text")},
                                actionTextColor = Color.WHITE,
                                actionTextUpperCase = true)
```

##### Show snack from any class with a `view` instance (without attaching `action`)
```
    SnackBarUtils.showShortSnack(view,"Snack message") // 'view' is an instance of 'View'
    		//or
    SnackBarUtils.showLongSnack(view,snackMessageId) // snackMessageId is a String resource Id
```
##### Show snack from any class with a `view` instance (with `action`)
```
    SnackBarUtils.showShortSnack(view = view,message = "Snack message",actionText = "Action",
                    action = { println("Short snack with default action format")}) // 'view' is an instance of 'View'
                    
    		//or
		
    SnackBarUtils.showLongSnack(view = view,messageId = snackMessageId,actionText = "Action",
                    action = { println("Long snack with blue lower case action text")},
                    actionTextColor = Color.BLUE,
                    actionTextUpperCase = false) // snackMessageId is a String resource Id
```

License
--------

    Copyright 2020 Bikash Das(das.bikash.dev@gmail.com)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

# android-snackbar-utils

<h4>Android library for [`Snackbar`](https://developer.android.com/reference/com/google/android/material/snackbar/Snackbar).</h4>


[![](https://jitpack.io/v/dasBikash84/android-snackbar-utils.svg)](https://jitpack.io/#dasBikash84/android-snackbar-utils)

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
    implementation 'com.github.dasBikash84:android-snackbar-utils:latest.release.here'
}
```

## Features
- Snackbar can be launched using AppCompatActivity/Activity/Fragment/Any view.
- Extension function provided for calling from inside of AppCompatActivity/Activity/Fragment.
- When launched from/using AppCompatActivity/Activity/Fragment Scackbar will be shown only if subject component is in Resumed state.
- Action text and corresponding action task can be added to Snackbar.
- Action task will run on main thread.
- Action text color and case can be customized.

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

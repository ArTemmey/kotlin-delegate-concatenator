Kotlin library for concatenating delegates.

# Installation

In your root `build.gradle`:
```gradle
allprojects {
   repositories {
      ...
      maven { url 'https://jitpack.io' }
   }
}
```
In your `app/build.gradle`:
```gradle
dependencies {
   implementation 'com.github.ArtemiyDmtrvch.kotlin-delegate-concatenator:kotlin-delegate-concatenator:+'
}
```

# Usage

```kotlin
var multiDelegatedVar by delegate1(initialValue) + delegate2(initialValue)
```
`multiDelegatedVar` will be delegated by the class returned by the `+` method. In the `getValue` method this class will take the value from `delegate1` and in the `setValue` method it will cause setting the value in `delegate1` and in `delegate2`.
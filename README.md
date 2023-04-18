# custom-actions-demo
The demo repository about custom actions on sharesheet which is new feature on API 34.
https://developer.android.com/about/versions/14/features#add-custom-actions

## Demo video
new custom action (**super util action** with Android robot icon) is added on sharesheet.

<img src="https://user-images.githubusercontent.com/7840108/232821633-58dd4571-3a05-481c-ab88-4f7b5cbc8d6e.gif" width="300" />


## How to configure API 34.
Use `compileSdkPreview`, `targetSdkPreview` and `minSdkPreview` parameters with "UpsideDownCake".

```build.gradle.kts (:app)
android {
    compileSdkPreview = "UpsideDownCake"
    ...
    
    defaultConfig {
        targetSdkPreview = "UpsideDownCake"
        minSdkPreview = "UpsideDownCake"
        ...
    }
    ...
}
```

## How to use custom actions?
Pass `ChooserAction` with `EXTRA_CHOOSER_CUSTOM_ACTIONS` flag. `ChooserAction` can build by `ChooserAction.Builder`.
When you pass the `chooserAction` as intent extra, need to pass as `Array<ChooserAction>`.

```kotlin
val chooserAction = ChooserAction.Builder(...).build()
val chooser = Intent.createChooser(intent, "Share").apply {
    putExtra(Intent.EXTRA_CHOOSER_CUSTOM_ACTIONS, arrayOf(chooserAction))
}
startActivity(chooser)
```

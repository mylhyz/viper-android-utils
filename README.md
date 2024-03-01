# vUtils

添加远程依赖

```gradle
        maven {
            url "https://maven.pkg.github.com/mylhyz/vUtils"
            credentials {
                username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_USERNAME")
                password = project.findProperty("gpr.key") ?: System.getenv("GITHUB_TOKEN")
            }
        }
```

添加依赖库版本

```gradle
    implementation "com.viper.android.vutils:utils:${rootProject.ext.vUtils_version}"
    implementation "com.viper.android.vutils:system:${rootProject.ext.vUtils_version}"
    implementation "com.viper.android.vutils:views:${rootProject.ext.vUtils_version}"
```

版本号定义

```gradle
ext {
    vUtils_version = "1.1.2"
}
```

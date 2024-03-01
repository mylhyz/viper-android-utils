# viper-android-utils

添加远程依赖

```gradle
        maven {
            url "https://maven.pkg.github.com/mylhyz/viper-android-utils"
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
    implementation "co.lujun.androidtagview:core:${rootProject.ext.AndroidTagView_version}"
```

版本号定义

```gradle
ext {
    vUtils_version = "1.1.2"
    AndroidTagView_version = "1.1.7"
}
```

# LICENSE

```
Copyright [2024] mylhyz

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
# viper-android-utils

添加远程依赖 - Gradle

```gradle
maven {
    url "https://maven.pkg.github.com/mylhyz/viper-android-utils"
    credentials {
        username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_USERNAME")
        password = project.findProperty("gpr.key") ?: System.getenv("GITHUB_TOKEN")
    }
}
```

添加远程依赖 - Gradle KTS

```kts
maven {
    url = uri("https://maven.pkg.github.com/mylhyz/viper-android-utils")
    credentials {
        username = System.getenv("GITHUB_USERNAME")
        password = System.getenv("GITHUB_TOKEN")
    }
}
```

添加依赖库版本

| artifact                                     | version                                                         |
|----------------------------------------------|-----------------------------------------------------------------|
| com.viper.android.vutils:utils:${version}    | ![version](https://img.shields.io/badge/gpr-1.1.4-blue)         |
| com.viper.android.vutils:system:${version}   | ![version](https://img.shields.io/badge/gpr-1.1.4-blue)         |
| com.viper.android.vutils:views:${version}    | ![version](https://img.shields.io/badge/gpr-1.1.4-blue)         |
| co.lujun.androidtagview:core:${version}      | ![version](https://img.shields.io/badge/gpr-1.1.8--beta.0-blue) |
| com.github.tony19:logback-android:${version} | ![version](https://img.shields.io/badge/gpr-1.3.1--beta.1-blue) |
| com.nononsenseapps:filepicker:${version}     | ![version](https://img.shields.io/badge/gpr-4.3.0--beta.0-blue) |
| com.bydauto.oip:sdk-v1:${version}            | ![version](https://img.shields.io/badge/gpr-0.0.1-blue)         |

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

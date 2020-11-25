# Android-System-Info
get KeyHash, get phone width and height, use restart app and use full screen

## Import Library to Gradle

1 - Download SysInfo.zip and extract it

https://cdn.xtsmm.com/android/libraries/SysInfo.zip

2 - Import Module

```
File -> New -> Import Module -> select Downloaded "Android JSON" Folder
```

3 - Add Library at App gradle

```
dependencies {
   implementation project(path: ':SysInfo')
}
```

## Usage

###### 1. getPhoneWidth() and  getPhoneHeight()

```
SysInfo sysInfo=new SysInfo(this);
int phWidth=sysInfo.getPhoneWidth();
int phHeight=sysInfo.getPhoneHeight();
```

###### 2. restartApp()

```
SysInfo sysInfo=new SysInfo(this);
sysInfo.restartApp();
```

###### 3. restartApp()

```
SysInfo sysInfo=new SysInfo(this);
sysInfo.restartApp();
```

###### 4. restartApp()

```
SysInfo sysInfo=new SysInfo(this);
String keyhash=sysInfo.getKeyHash();
```

###### 5. xFullScreen()

```
SysInfo sysInfo=new SysInfo(this);
sysInfo.xFullScreen();
```

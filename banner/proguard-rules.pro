# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in F:\android\studio-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}


-dontskipnonpubliclibraryclasses # 不忽略非公共的库类
-optimizationpasses 5            # 指定代码的压缩级别
-dontusemixedcaseclassnames      # 是否使用大小写混合
-dontpreverify                   # 混淆时是否做预校验
-verbose                         # 混淆时是否记录日志
-keepattributes *Annotation*     # 保持注解
-ignorewarning                   # 忽略警告
-dontoptimize                    # 优化不优化输入的类文件

-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*  # 混淆时所采用的算法

#保持哪些类不被混淆
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService


#生成日志数据，gradle build时在本项目根目录输出
-dump class_files.txt            #apk包内所有class的内部结构
-printseeds seeds.txt            #未混淆的类和成员
-printusage unused.txt           #打印未被使用的代码
-printmapping mapping.txt        #混淆前后的映射

-keep public class * extends android.support.** #如果有引用v4或者v7包，需添加
#-libraryjars libs/xxx.jar        #混淆第三方jar包，其中xxx为jar包名
#-keep class com.xxx.**{*;}       #不混淆某个包内的所有文件
#-dontwarn com.xxx**              #忽略某个包的警告
-keepattributes Signature        #不混淆泛型
-keepnames class * implements java.io.Serializable #不混淆Serializable

#如果引用了v4或者v7包
-dontwarn android.support.**

#不混淆资源类
-keepclassmembers class **.R$* {
    public static <fields>;
}
-keepclasseswithmembernames class * {  # 保持 native 方法不被混淆
    native <methods>;
}
-keepclasseswithmembers class * {      # 保持自定义控件类不被混淆
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {      # 保持自定义控件类不被混淆
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class * extends android.app.Activity { # 保持自定义控件类不被混淆
    public void *(android.view.View);
}
-keepclassmembers enum * {             # 保持枚举 enum 类不被混淆
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keep class * implements android.os.Parcelable {         # 保持 Parcelable 不被混淆
    public static final android.os.Parcelable$Creator *;
}

-keepnames class * implements java.io.Serializable      #保持 Serializable 不被混淆

-keepclassmembers class * implements java.io.Serializable {#保持 Serializable 不被混淆并且enum 类也不被混淆
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

############################涉及到javabean不能混淆 start##############################################
##address
-keep class com.voctex.banner.bean.**{*;}
-keep class com.voctex.banner.interfac.**{*;}
#-keep class com.yidont.address.table.**{*;}
##app
#-keep class com.yidont.cafe.bean.**{*;}
#-keep class com.yidont.cafe.item.**{*;}
#-keep class com.yidont.cafe.apk.bean.**{*;}
#-keep class com.yidont.cafe.apk.item.**{*;}
#-keep class com.yidont.cafe.person.bean.**{*;}
#-keep class com.yidont.cafe.person.item.**{*;}
#-keep class com.yidont.cafe.signdate.bean.**{*;}
##fragment
#-keep class com.yidont.fm.bean.**{*;}
#-keep class com.yidont.fm.perms.**{*;}
##game
#-keep class com.yidont.cafe.game.bean.**{*;}
#-keep class com.yidont.cafe.game.item.**{*;}
#-keep class com.yidont.cafe.game.table.**{*;}
##gift
#-keep class com.yidont.cafe.gift.bean.**{*;}
#-keep class com.yidont.cafe.gift.item.**{*;}
##porder
#-keep class com.yidont.cafe.porder.bean.**{*;}
#-keep class com.yidont.cafe.porder.adapter.**{*;}
##push
#-keep class com.yidont.push.bean.**{*;}
#-keep class com.yidont.push.item.**{*;}
#-keep class com.yidont.push.table.**{*;}
##scan
#-keep class com.yidont.cafe.scan.bean.**{*;}
#-keep class com.zbar.lib.**{*;}
##tool
#-keep class com.yidont.bean.**{*;}
##这个包内有些东西不能混淆，具体没测试哪些不能混淆，要是混淆它们的话，会出现调用不了支付宝api的问题
#-keep class com.yidont.payment.**{*;}
#-keep class com.yidont.tool.glide.GlideConfiguration{*;}
##video
#-keep class com.yidont.cafe.video.bean.**{*;}
#-keep class com.yidont.cafe.video.item.**{*;}
#-keep class com.yidont.cafe.video.table.**{*;}
#-keep class com.yidont.cafe.video.util.holder.**{*;}
##wifi
#-keep class com.yidont.cafe.wifi.bean.**{*;}
#-keep class com.yidont.cafe.wifi.item.**{*;}
##login
#-keep class com.yidont.cafe.login.bean.**{*;}


############################涉及到javabean不能混淆 end################################################


####################################与js交互的混淆 start############################################
#-keepclassmembers class * extends com.yidont.fm.util.JavaScriptObject {
#  public *;
#}
#-keepattributes *Annotation*
#-keepattributes *JavascriptInterface*
####################################与js交互的混淆 end##############################################



##############################第三方包的混淆 start####################################################
##### gson的混淆
#-keep class com.google.gson.**{
#    *;
#}
#
##### glide
#-keep class com.bumptech.glide.**{
#    *;
#}
#-keep class com.yidont.tool.glide.**{
#    *;
#}




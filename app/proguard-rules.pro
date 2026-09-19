# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /tools/proguard/proguard-android.txt
# You can edit the include line and the file paths to fit your project.

# Keep Kotlin metadata and annotations
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod

# Keep Room Database generated code
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-dontwarn androidx.room.paging.**

# Keep Jetpack Compose classes
-keep class androidx.compose.** { *; }

# Keep Kotlin Coroutines
-keepclassmembers class * {
    @kotlinx.coroutines.** <fields>;
    @kotlinx.coroutines.** <methods>;
}

# Retain line numbers in crash logs for easier debugging
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable

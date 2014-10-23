#include "ro_mole_ro_test_MainAdmin.h"
/* Header for class ro_mole_ro_test_MainAdmin */


JNIEXPORT jstring JNICALL Java_ro_mole_ro_test_MainAdmin_getStringFromNative
  (JNIEnv * env, jobject obj)
  {
    return (*env)->NewStringUTF(env, "Hello From JNI !");
  }
package com.whs.utils;

public class OJUtils {

    public static String mergeCode(String requestCode, String testCode) {
        // 1. 先从 requestCode 中找到末尾的 } , 并且截取出前面的代码
        int pos = requestCode.lastIndexOf("}");
        if (pos == -1) {
            return null;
        }
        // 2. 把 testCode 拼接到后面, 并再拼接上一个 } 就好了
        return requestCode.substring(0, pos) + testCode + "}";
    }
}

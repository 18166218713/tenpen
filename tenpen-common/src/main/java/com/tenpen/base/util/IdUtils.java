package com.tenpen.base.util;

import java.util.UUID;

/**
 * Created by x00376013 on 2019/9/25.
 */
public class IdUtils {

    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

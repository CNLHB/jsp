package com.lhb.jsp.common.utils;

import java.util.List;

/**
 * @author:
 * @create: 2018-04-24 17:20
 **/
public class ListUtils {

    //json化
    public static Boolean contains(List<String> pathList, String path) {
        for (String p : pathList){
            if (path.startsWith(p)){
                return true;
            }
        }
        return false;
    }
}

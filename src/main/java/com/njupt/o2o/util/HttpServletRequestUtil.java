package com.njupt.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestUtil {
    public static int getInt(HttpServletRequest httpServletRequest,String key){
        return Integer.decode(httpServletRequest.getParameter(key));
    }

    public static Long getLong(HttpServletRequest httpServletRequest,String key){
        return Long.valueOf(httpServletRequest.getParameter(key));
    }
    public static Double getDouble(HttpServletRequest httpServletRequest,String key){
        return Double.valueOf(httpServletRequest.getParameter(key));
    }
    public static Boolean getBoolean(HttpServletRequest httpServletRequest,String key){
        return Boolean.valueOf(httpServletRequest.getParameter(key));
    }

    public static String getString(HttpServletRequest httpServletRequest,String key){
        try{
            String result = httpServletRequest.getParameter(key);
            if (result != null){
                result = result.trim();
            }
            if("".equals(result)){
                result = null;
            }
            return  result;
        }catch (Exception e){
            return null;
        }
    }



}

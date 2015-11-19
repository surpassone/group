package com.ssm.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author chao
 */
public class DateUtil {
    public static String getNowTime(){
           Date d=new Date();
           SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss");
           return sdf.format(d);
    }
    
    public static String getOrderNO(){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");//设置日期格式
      return sdf.format(new Date());// new Date()为获取当前系统时间
    }

    public static String getDate(){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
      return sdf.format(new Date());// new Date()为获取当前系统时间
    }

    
    public static String getNowDate(){
           Date d=new Date();
           SimpleDateFormat sdf =new SimpleDateFormat("yyyy年MM月dd日");
           return sdf.format(d);
    }
}
    
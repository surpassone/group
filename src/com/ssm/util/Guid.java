package com.ssm.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Guid {
	  private String valueBeforeMD5 = "";
	  private String valueAfterMD5 = "";
	  private static Random myRand;
	  private static SecureRandom mySecureRand = new SecureRandom();
	  private static String s_id;
	  private static final int PAD_BELOW = 16;
	  private static final int TWO_BYTES = 255;
	  
	  static
	  {
	    long secureInitializer = mySecureRand.nextLong();
	    
	    myRand = new Random(secureInitializer);
	    try
	    {
	      s_id = InetAddress.getLocalHost().toString();
	    }
	    catch (UnknownHostException e)
	    {
	      e.printStackTrace();
	    }
	  }
	  
	  public Guid()
	  {
	    getRandomGUID(false);
	  }
	  
	  private void getRandomGUID(boolean secure)
	  {
	    MessageDigest md5 = null;
	    StringBuffer sbValueBeforeMD5 = new StringBuffer(128);
	    try
	    {
	      md5 = MessageDigest.getInstance("MD5");
	    }
	    catch (NoSuchAlgorithmException e)
	    {
	    }
	    try
	    {
	      long time = System.currentTimeMillis();
	      long rand = 0L;
	      if (secure) {
	        rand = mySecureRand.nextLong();
	      } else {
	        rand = myRand.nextLong();
	      }
	      sbValueBeforeMD5.append(s_id);
	      sbValueBeforeMD5.append(":");
	      sbValueBeforeMD5.append(Long.toString(time));
	      sbValueBeforeMD5.append(":");
	      sbValueBeforeMD5.append(Long.toString(rand));
	      
	      this.valueBeforeMD5 = sbValueBeforeMD5.toString();
	      
	      md5.update(this.valueBeforeMD5.getBytes());
	      byte[] array = md5.digest();
	      StringBuffer sb = new StringBuffer(32);
	      for (int j = 0; j < array.length; j++)
	      {
	        int b = array[j] & 0xFF;
	        if (b < 16) {
	          sb.append('0');
	        }
	        sb.append(Integer.toHexString(b));
	      }
	      this.valueAfterMD5 = sb.toString();
	    }
	    catch (Exception e)
	    {
	    }
	  }
	  
	  private String toStandardString()
	  {
	    String raw = this.valueAfterMD5.toUpperCase();
	    StringBuffer sb = new StringBuffer(64);
	    sb.append(raw.substring(0, 8));
	    sb.append("-");
	    sb.append(raw.substring(8, 12));
	    sb.append("-");
	    sb.append(raw.substring(12, 16));
	    sb.append("-");
	    sb.append(raw.substring(16, 20));
	    sb.append("-");
	    sb.append(raw.substring(20));
	    return sb.toString();
	  }
	  
	  public static String create()
	  {
	    return create(true);
	  }
	  
	  public static String create(boolean standard)
	  {
	    Guid myGUID = new Guid();
	    if (standard) {
	      return myGUID.toStandardString();
	    }
	    return myGUID.valueAfterMD5.toUpperCase();
	  }
}

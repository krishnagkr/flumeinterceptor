package com.cloan.data.interceptor;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Author: Krishna Gandra
 * 
 */

public enum HeadersEnum 
{

	HOSTNAME
	{
		@Override
		public String getName()
		{
			return "hostName";
		}
		
		@Override
		public String getValue() throws Exception
		{
			return InetAddress.getLocalHost().getHostName();
			
		}
	},
	
	HOSTIP
	{
		@Override
		public String getName()
		{
			return "hostIp";
		}
		
		@Override
		public String getValue() throws Exception
		{
			return InetAddress.getLocalHost().getHostAddress();
		}
		
	},
	
	TIMESTAMP
	{
		@Override
		public String getName()
		{
			return "timeStamp";
		}
		
		@Override
		public String getValue() throws Exception
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy:HH:mm:SS Z");
			return  sdf.format(new Date());
		}
		
	};

	public abstract String getName();
	public abstract String getValue() throws Exception;
	
	public static boolean contains(String header) 
	{
	    for (HeadersEnum headerEnum : HeadersEnum.values()) 
	    {
	        if (headerEnum.name().equals(header)) 
	        {
	            return true;
	        }
	    }

	    return false;
	}
	
}

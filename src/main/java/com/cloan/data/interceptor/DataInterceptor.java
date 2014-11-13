package com.cloan.data.interceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import lombok.extern.slf4j.Slf4j;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

/*
 * Author: Krishna Gandra
 * 
 */

@Slf4j
public class DataInterceptor implements Interceptor
{
	private static String headers;
	private static Map<String,String> headersMap = new HashMap<String,String>();

	public void close() 
	{

	}

	public void initialize()
	{
		try 
		{
			 addNewHeadersToMapfromGivenString(headers,headersMap);
		} 
		catch (Exception e) 
		{
			log.error("HostIP exception " + e.getMessage());
		}
	}

	public void addNewHeadersToMapfromGivenString(String headers, Map<String,String> headersMap) throws Exception {
		String header;
		StringTokenizer stHeaders = new StringTokenizer(headers,"|");
		while (stHeaders.hasMoreTokens())
		{
			header = stHeaders.nextToken().trim();
			if (HeadersEnum.contains(header))
			{
				headersMap.put(HeadersEnum.valueOf(header).getName(), HeadersEnum.valueOf(header).getValue());
			}
		}
		
	}

	public Event intercept(final Event event) 
	{
		event.getHeaders().putAll(headersMap);
		return event;
	}

	public List<Event> intercept(List<Event> events) 
	{
		for (Event event: events)
		{
			intercept(event);
		}
		
		return events;
	}
	
	public static class DataInterceptorBuilder implements Interceptor.Builder
	{
		
		public void configure(Context ctxt) 
		{
			headers = ctxt.getString("headers");
		}

		public Interceptor build() 
		{
			return new DataInterceptor();
		}
		
	}
	

}

package com.cloan.data.interceptor;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 * Author: Krishna Gandra
 * 
 */
public class DataInterceptorTest {

	@Test
	public void givenHeadersTextWithAllexistingHeaders_WhenCalladdNewHeadersToMapfromGivenString_AddAllGivenValuesInHeadersText() throws Exception 
	{
		String headersText = "HOSTIP | HOSTNAME | TIMESTAMP";
		DataInterceptor di = new DataInterceptor();
		Map<String, String> headersMap = new HashMap<String,String>();
		di.addNewHeadersToMapfromGivenString(headersText, headersMap );
		assertEquals(3,  headersMap.size());		
	}
	
	@Test
	public void givenHeadersTextWithOnlyTwoExistingHeaders_WhenCalladdNewHeadersToMapfromGivenString_AddOnlyExistingEnumValuesInHeadersText() throws Exception 
	{
		String headersText = "HOSTIP | HOSTNAME | NOTINENUM";
		DataInterceptor di = new DataInterceptor();
		Map<String, String> headersMap = new HashMap<String,String>();
		di.addNewHeadersToMapfromGivenString(headersText, headersMap );
		assertEquals(2,  headersMap.size());		
	}	
	
	@Test
	public void givenNoHeadersInText_WhenCalladdNewHeadersToMapfromGivenString_ReturnEmptyMap() throws Exception 
	{
		String headersText = "";
		DataInterceptor di = new DataInterceptor();
		Map<String, String> headersMap = new HashMap<String,String>();
		di.addNewHeadersToMapfromGivenString(headersText, headersMap );
		assertEquals(0,  headersMap.size());		
	}	
	
	
	
}

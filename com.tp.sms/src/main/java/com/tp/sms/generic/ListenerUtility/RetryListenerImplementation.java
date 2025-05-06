package com.tp.sms.generic.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImplementation implements IRetryAnalyzer {

	int count =0;
	int limitCount =2;
	public boolean retry(ITestResult result) {
		if(count<limitCount)
		{
			count++;
			System.out.println("retry Listener..");
			return true;
		}
			 return false;
	}

}

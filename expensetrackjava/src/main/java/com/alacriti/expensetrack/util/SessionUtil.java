package com.alacriti.expensetrack.util;

import javax.servlet.http.HttpSession;

public class SessionUtil {
	public boolean checkForSession(HttpSession session)
	{
	System.out.println("the status of session is:");
	System.out.println(session);
	if(session==null)
	return false;
	else 
	return true;
	}

}

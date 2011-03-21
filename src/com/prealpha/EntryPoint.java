package com.prealpha;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.prealpha.objects.Comment;
import com.prealpha.objects.Thread;

import com.prealpha.writers.Json;
import com.prealpha.writers.Xml;;

public class EntryPoint
{
	public static void main(String[] args) throws MalformedURLException, IOException 
	{	
		//Thread thread = Thread.parseThread(new URL("http://localhost:8000/prettyThread.html"));
		Thread thread = Thread.parseThread(new URL("http://boards.4chan.org/c/res/1659403"));
		//Xml.threadToXml(thread); 
		Json.threadToJson(thread);
		
	}
}

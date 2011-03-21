package com.prealpha;

import java.io.PrintStream;

public class Utili 
{
	static PrintStream outs = System.out;
	
	public static void println(Object o,int tabNum)
	{
		String tabs = "";
		for(int i=0;i<tabNum;i++)
		{
			tabs += "\t";
		}
		outs.println(tabs+o.toString());
	}
	public static void print(Object o)
	{
		outs.print(o.toString());
	}
}

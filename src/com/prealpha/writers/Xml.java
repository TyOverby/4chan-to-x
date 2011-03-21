package com.prealpha.writers;

import com.prealpha.objects.Comment;
import com.prealpha.objects.Thread;

import com.prealpha.Utili;

public class Xml 
{
	public static boolean threadToXml(Thread thread)
	{
		try
		{
			Utili.println("<thread num=\""+thread.getComments().get(0).number+"\">",0);
			for(Comment c : thread.getComments())
			{
				String name = (c.name != null) ? " name =\""+c.name+"\"" : "";
				String trip = (c.trip != null) ? " trip =\""+c.trip+"\"" : "";
				String email = (c.email != null) ? " email =\""+c.email+"\"" : "";
				
				Utili.println("<comment"+name+trip+email+">",1);
				
				if(c.image.isImage)
				{
					Utili.println("<image>",2);
					Utili.println("<url href=\""+c.image.url+"\"/>",3);
					Utili.println("<size est=\""+c.image.size+"\">",3);
					Utili.println("<dimensions width=\""+escapeXML(c.image.width)+"\" height=\""+escapeXML(c.image.height)+"\">",3);
					Utili.println("</image>",2);
				}
				if(c.bodyText != null && c.bodyText.size() != 0)
				{
					Utili.println("<text length = \""+c.bodyText.size()+"\">" ,2);
						for(String s:c.bodyText)
						{
							Utili.println(escapeXML(s),3);
						}
					Utili.println("</text>",2);
				}
				
				Utili.println("</comment>",1);
			}

			Utili.println("</thread>",0);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public static String escapeXML(Object input)
	{
		return input.toString().replace("<", "&lt").replace(">", "&gt");
	}
}

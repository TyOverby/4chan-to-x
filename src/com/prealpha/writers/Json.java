package com.prealpha.writers;

import com.prealpha.Utili;
import com.prealpha.objects.Comment;
import com.prealpha.objects.Thread;

public class Json 
{
	public static boolean threadToJson(Thread thread)
	{
		try
		{
			Utili.println("{", 0);
				Utili.println("\"comment\":", 1);
				Utili.println("[",1);
				for(Comment c:thread.getComments())
				{
					Utili.println("{", 2);
						Utili.println("\"number\": "+c.number+",", 3);
						if(c.name != null)
						{
						Utili.println("\"name\": \""+c.name+"\",", 3);
						}
						if(c.trip != null)
						{
						Utili.println("\"trip\": \""+c.trip+"\",",3);
						}
						if(c.email != null)
						{
						Utili.println("\"email\": \""+c.email+"\",", 3);
						}
						if(c.image.isImage)
						{
						Utili.println("\"image\":",3);
						Utili.println("{", 3);
							Utili.println("\"name\": \""+c.image.fileName+"\",", 4);
							Utili.println("\"url\": \""+c.image.url+"\",", 4);
							Utili.println("\"size\": \""+c.image.size+"\",", 4);
							Utili.println("\"width\": "+c.image.width+",", 4);
							Utili.println("\"height\": "+c.image.height, 4);
						String comma = (c.bodyText != null && c.bodyText.size()>0) ? ",":"";
						Utili.println("}"+comma, 3);
						}
						if(c.bodyText != null && c.bodyText.size()>0)
						{
							Utili.println("\"text\":", 3);
							Utili.println("[", 3);
							for(String s: c.bodyText)
							{
								String comma = (c.bodyText.indexOf(s)!=c.bodyText.size()-1) ? ",":"";
								Utili.println("\""+s+"\""+comma, 4);
							}
							Utili.println("]", 3);
						}
					String comma = (thread.getComments().indexOf(c)!=thread.getComments().size()-1)? ",":"";
					Utili.println("}"+comma, 2);
				}
				Utili.println("]",1);
				
			Utili.println("}",0);
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}

import java.util.*;
import java.io.*;
import java.net.*;

public class Server
{
    public static void main(String args[]) throws Exception
    {
    	ServerSocket ss= new ServerSocket(1234);
	try
	{
		while(true)
		{
       		 	Socket s = ss.accept();	
			new MyThread(s).start();
		}
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		try{
			if(ss!=null)
			{
			    ss.close();		
			}
                   }
		catch(IOException e)
		{
			e.printStackTrace();	
		}
	}
    }
}
class MyThread extends Thread
{
	Socket mys;
	MyThread(Socket s)
	{
		mys=s;	
	}
	public void run()
	{
		DataInputStream din=null;
		DataOutputStream dout=null;
		try
		{
        		din = new DataInputStream(mys.getInputStream());
        		dout = new DataOutputStream(mys.getOutputStream());
        		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        		String str="";
        		String str2="";
        		while(!str.equals("stop"))
        		{
        	    		str=din.readUTF();
        	    		System.out.println("Client "+mys.getInetAddress().getHostAddress()+" says =>"+str);
        	    		str2=br.readLine();
        	    		dout.writeUTF(str2);
        	    		dout.flush();
        		}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{	
			try
			{		
				if(din!=null)
				{
        				din.close();
				}
				if(mys!=null)
				{
       					mys.close();
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();	
			}
		}
	}	
}



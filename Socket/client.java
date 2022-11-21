import java.util.*;
import java.io.*;
import java.net.*;

public class Client
{
    public static void main(String args[]) throws Exception
    {
        Socket s = new Socket("192.168.1.202",1234);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str="";
        String str2="";
        while(!str.equals("stop"))
        {
            str=br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str2=din.readUTF();
            System.out.println("Server says =>"+str2);
        }
        dout.close();
        s.close();
    }
}

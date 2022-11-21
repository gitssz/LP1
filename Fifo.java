package SPOS;

import java.io.*;
import java.util.Scanner;
public class fifo
{
	public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int nframe, pointer = 0, h = 0, f = 0,str_len;
        int buffer[];
        int str[];
        int memory_layout[][];

        System.out.println("Please enter the number of Frames: ");
        nframe = sc.nextInt();

        System.out.println("Please enter the length of the Reference string: ");
        str_len = sc.nextInt();

        str = new int[str_len];
        memory_layout = new int[str_len][nframe];
        buffer = new int[nframe];
        for(int j = 0; j < nframe; j++)
        {
            buffer[j] = -1;
        }
        System.out.println("Please enter the reference string: ");
        for(int i = 0; i < str_len; i++)
        {
            str[i] = sc.nextInt();
        }
        System.out.println();
        for(int i = 0; i < str_len; i++)
        {
        	int search = -1;
        	for(int j = 0; j < nframe; j++)
        	{
        		if(buffer[j] == str[i])
        		{
        			search = j;
        			h++;
        			break;
        		}
        	}
	        if(search == -1)
	        {
	        	buffer[pointer] = str[i];
	        	f++;
	        	pointer++;
	        	if(pointer == nframe)
	        	{
	        		pointer = 0;
	        	}
	        }
	        for(int j = 0; j < nframe; j++)
	        {
	        	memory_layout[i][j] = buffer[j];
	        }
        }

        for(int i = 0; i < nframe; i++)
        {
        	System.out.print("Frame "+(i+1)+":\t\t");
        	for(int j = 0; j < str_len; j++)
            {
            	System.out.print(memory_layout[j][i]+"\t");
            }
            System.out.println();
        }
        
        System.out.println("The number of Faults: " + f);
        System.out.println("The number of Hits: " + h);
        System.out.println("Hit Ratio: " +(float)((float)h/str_len));
        sc.close();
    }
}

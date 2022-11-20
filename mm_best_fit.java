import java.util.*;

public class mm_best_fit 
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of jobs: ");
		int n=sc.nextInt();
		int req[]=new int[n];
		int job[]=new int[n];
		System.out.println("Enter no. of blocks: ");
		int m=sc.nextInt();
		int b[]=new int[m];
		int avl[]=new int[m];
		int f[]=new int[m];
		int temp;
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter memory requirement for job "+(i+1)+" : ");
			req[i]=sc.nextInt();
			job[i]=(i+1);
		}
		
		System.out.println();
		for(int i=0;i<m;i++)
		{
			System.out.println("Enter memory available for block "+(i+1)+" : ");
			avl[i]=sc.nextInt();
			b[i]=(i+1);
		}
		
		System.out.println("MEMORY REQUIREMENT:");
		System.out.println("JOB\t M_REQUIREMENT");
		for(int i=0;i<n;i++)
		{
			System.out.print(job[i]+"\t"+req[i]);
			System.out.println();
		}
		
		System.out.println();
		System.out.println("MEMORY AVAILABLE:");
		System.out.println("BLOCK\t M_AVAILABLE");
		for(int i=0;i<m;i++)
		{
			System.out.print(b[i]+"\t"+avl[i]);
			System.out.println();
		}
		
		for (int i=0;i<n;i++)
	    {
	    	f[i]= 0;
	    }
		
		for(int i = 0 ; i <n; i++)
		{
			for(int  j=0;  j < n-(i+1) ; j++)
			{
				if(avl[j] > avl[j+1])
				{
					temp=avl[j];
					avl[j]=avl[j+1];
					avl[j+1]=temp;
					temp=b[j];
					b[j]=b[j+1];
					b[j+1]=temp;
				}
			}
		}
		
		System.out.println("JOB\t\t BLOCK");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(req[i]<=avl[j] && f[j]==0) 
				{
					f[j]=1;
					System.out.println(job[i]+"\t-->"+b[j]);
					break;
				}
			}
		}
		sc.close();
		
	}
}
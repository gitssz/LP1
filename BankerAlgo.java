package ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class deadlock_avoidance
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of processes: ");
		int m=sc.nextInt();
		System.out.println("Enter no. of resources: ");
		int n=sc.nextInt();
		int [][]max=new int[m][n];
		int [][]allocation=new int[m][n];
		int [][]need=new int[m][n];
		int [][]new_available=new int[1][n];
		int f[]=new int[m];
		Queue<String>  safe = new LinkedList<>();
		
		for(int i=0;i<m;i++)
		{
			f[i]=0;
		}
		for(int i=0;i<m;i++)
		{
			System.out.println("Enter no. of max resources required for process"+(i+1)+" : ");
			for(int j=0;j<n;j++)
			{
				System.out.print("\t");
				System.out.print(" R"+(j+1)+" : ");
				max[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0;i<m;i++)
		{
			System.out.println("Enter no. of resources allocated for process "+(i+1)+":");
			for(int j=0;j<n;j++)
			{
				System.out.print("\t");
				System.out.print(" R"+(j+1)+" : ");
				allocation[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0;i<1;i++)
		{
			System.out.println("Enter no. of resources available :");
			for(int j=0;j<n;j++)
			{
				System.out.print("\t");
				System.out.print(" R"+(j+1)+" : ");
				new_available[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				need[i][j]=max[i][j]-allocation[i][j];
			}
		}
		
		System.out.println("Need Matrix:");
		for(int i=0;i<n;i++)
		{
			System.out.print("\tR"+(i+1));
		}
		System.out.println();
		for(int i=0;i<m;i++)
		{
			System.out.print("P"+(i+1));
			for(int j=0;j<n;j++)
			{
				System.out.print("\t"+need[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		while(true)
		{
			for(int i=0;i<m;i++)
			{
				int flag=0;
				for(int j=0;j<n;j++)
				{
					flag=0;
					if(f[i]==0 && need[i][j]<=new_available[0][j])
					{
						flag=1;
					}
					else
					{
						flag=0;
						break;
					}
				}
					
				if(flag==1)
				{
					safe.add("P"+(i+1));
					System.out.println("P"+(i+1)+" is executed");
					System.out.println("New available after execution of P"+(i+1)+" is:");
					for(int j=0;j<n;j++)
					{
						{
							new_available[0][j]=new_available[0][j]+allocation[i][j];
							f[i]=1;
							System.out.print("\t"+new_available[0][j]);
						}
					}
					System.out.println();
				}	
			}
			
			int flag_f=0;
			for(int k=0;k<m;k++) 
			{
				flag_f=0;
				if(f[k]==1)
				{
					flag_f=1;
				}
				else
					break;
						
			}
			
			if(flag_f==1)
				break;
		}
		System.out.println("The safe sequence is : "+safe);
		sc.close();	
	}
}

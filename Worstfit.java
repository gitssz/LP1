package spos;
public class Worstfit{
		
	public static void main(String[] args)
	{
		int blockSize[] = {100, 500, 200, 300, 600};
		int processSize[] = {212, 417, 112, 426};
		int m = blockSize.length;
		int n = processSize.length;
		
		worstfit(blockSize, m, processSize, n);
	}
	static void worstfit(int blockSize[], int m, int processSize[],int n)
		{
			int allocation[] = new int[n];
		
			for (int i = 0; i < allocation.length; i++)
				allocation[i] = -1;
		
			for (int i=0; i<n; i++)
			{
				int worst = -1;
				for (int j=0; j<m; j++)
				{
					if (blockSize[j] >= processSize[i])
					{
						if (worst == -1)
							worst = j;
						else if (blockSize[worst] < blockSize[j])
							worst = j;
					}
				}
		
				if (worst != -1)
				{
					allocation[i] = worst;
		
					blockSize[worst] -= processSize[i];
				}
			}
		
			System.out.println("\nProcess No.\tProcess Size\tBlock no.");
			for (int i = 0; i < n; i++)
			{
				System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t");
				if (allocation[i] != -1)
					System.out.print(allocation[i] + 1);
				else
					System.out.print("Not Allocated");
				System.out.println();
			}
		}
		
}


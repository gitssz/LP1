package spos;

public class FirstFit {
	public static void main(String[] args) {
			int blockSize[] = {100,500,200,330,540};
			int processSize[] = {242,497,332,426};
			int m=blockSize.length;
			int n = processSize.length;
		firstfit(processSize,blockSize,m,n);
	}
	
	static void  firstfit(int processSize[],int blockSize[],int m, int n)
	{
		int allocation[]= new int[n];
		for(int i=0;i<allocation.length;i++) {
			allocation[i]=-1;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(blockSize[j]>=processSize[i])
				{
					allocation[i]=j;
				blockSize[j]-=processSize[i];
				break;
				}
			}
		}
		System.out.println("\nProcess No.\tProcess Size\tBlock no.");
		for(int i=0;i<n;i++) {
			System.out.print(" "+(i+1)+"\t\t" + processSize[i]+"\t\t");
			if(allocation[i]!=-1) {
				System.out.print(allocation[i]+1);
			}
			else
				System.out.print("Not Allocated");
			System.out.println();
		}
		
	}
	
}

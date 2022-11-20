package ;
import java.util.*;

public class Srtf {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.println("Enter no of process : ");
	int n=input.nextInt();
	int pid[] = new int[n];
	int at[] = new int[n];
	int bt[] = new int[n];
	int ct[] = new int[n];
	int tat[] = new int[n];
	int wt[] = new int[n];
	int f[] = new int[n];
	int k[]= new int[n];
    int i,temp, st=0, tot=0;
    float avg_wt=0, avg_tat=0;
    
    for(i=0;i<n;i++) {
    	pid[i]=i+1;
    	System.out.println("enter arival time: "+(i+1));
    	at[i]=input.nextInt();
    	System.out.println("enter burst time: "+(i+1));
    	k[i]=bt[i]=input.nextInt();
    	f[i]=0;
    }

    for(i=0;i<n;i++)
    {
    	for(int j=0;j<n-i-1;j++) {
    		if(at[j] > at[j+1]) {
    			temp=at[j];
    			at[j]=at[j+1];
    			at[j+1]=temp;
    			temp=bt[j];
    			bt[j]=bt[j+1];
    			bt[j+1]=temp;
    			temp=k[j];
    			k[j]=k[j+1];
    			k[j+1]=temp;
    			temp=pid[j];
    			pid[j]=pid[j+1];
    			pid[j+1]=temp;
    		}
    	}
    }    
    
    while(true) {
    	int min=99,c=n;
    	if(tot==n)		//all process completed
    		break;
    	for(i=0;i<n;i++) {
    		if(at[i]<=st && f[i]==0 && bt[i]<min ) {
    			min=bt[i];
    			c=i;
    		}
    	}
    	if(c==n) {
    		st++;
    		
    	}
    	else {
    		bt[c]--;
    		st++;
    		if(bt[c]==0) { 
    			ct[c]=st; 		 //bt==0, ct->st,flag=1
    			f[c]=1;
    			tot++;
    			
    		}
    	}
    	
    }
    for(i=0;i<n;i++) {
    	tat[i]=ct[i]-at[i];			//tat=ct-at
    	wt[i]=tat[i]-k[i];			//wt=tat-bt
    	avg_wt+=wt[i];
    	avg_tat+=tat[i];
    }
    System.out.println("Pid\tAT\tBT\tCT\tTAT\tWT\n");
    for(i=0;i<n;i++
    		)
    {
    	System.out.println(pid[i] +"\t"+ at[i]+"\t"+k[i] +"\t"+ ct[i] +"\t"+ tat[i] +"\t"+ wt[i]);
    }
    
    System.out.println("\nAverage TAT(TURN AROUND TIME) is : "+(avg_tat/n));
    System.out.println("\nAverage WT(WAITING TIME) is : "+ (avg_wt/n));
    
    input
    .close();
}
}

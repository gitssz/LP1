package pattern;

public class fcfs {
    public static void main(String[] args){
int[] process={1,2,3};
int n =process.length;
int bt[]={10,5,8};
//int[] wt,tat[];
findAvgWt(process,n,bt);

    }
    public static void findWaitingTime(int[] process , int n , int[] bt , int[] wt){
        wt[0]=0;
        for(int i=1;i<n;i++){
            wt[i]=bt[i-1]+wt[i-1];
        }
    }
    public static void findTurnAroundTime(int[] process, int n, int[] bt,int[] tat, int[] wt){
        //tat=ct-bt, wt-at
    for(int i=0;i<n;i++) {
        tat[i]=bt[i]+wt[i];
        }
    }

public static void findAvgWt(int[] process, int n, int [] bt){
         int wt[] = new int[n];
         int tat[] = new int[n];
         int total_wt = 0, total_tat=0;
         findWaitingTime(process,n,bt,wt);
         findTurnAroundTime(process,n,bt,tat,wt);
System.out.println("burst time " + "waiting time "+ "turn around time ");


      for(int i=0;i<n;i++){
        total_wt= total_wt+wt[i];
        total_tat=total_tat+tat[i];
        System.out.println( bt[i] + "           "+ wt[i]+ "           "  + tat[i]);

      }

        for(int i=0;i<n;i++){
            total_wt+=wt[i];
        }
        System.out.println("avg waiting time: "+ flost(total_wt)/float(n);

    for(int i=0;i<n;i++){
        total_tat+=tat[i];
    }
    System.out.println("avg turn around time: "+ total_tat/n);
    }



}

package spos;
import java.util.*;
public class Banker {
    public static void main(String[] args)
    {
    
        int avail[] = {3,1,1,2};

        int max[][] = {{3,3,2,2},
                {1,1,3,4},
                {1,3,5,0}};

        int allot[][] = {
                {1,2,2,1},
                {1,0,3,3},
                {1,2,1,0}};

        isSafe( avail, max, allot);
    }
        static int P = 3;
        static int R = 4;
        static void calculateNeed(int need[][], int max[][], int allot[][])
        {
            for (int i = 0 ; i < P ; i++)
                for (int j = 0 ; j < R ; j++)

                    need[i][j] = max[i][j] - allot[i][j];
        }
        static boolean isSafe( int avail[], int max[][],
                              int allot[][])
        {
            int [][]need = new int[P][R];
            calculateNeed(need, max, allot);
            boolean []finish = new boolean[P];
            int []safeSeq = new int[P];
            int []work = new int[R];
            for (int i = 0; i < R ; i++)
                work[i] = avail[i];
            int count = 0;
            while (count < P)
            {
                boolean found = false;
                for (int p = 0; p < P; p++)
                {
                    if (finish[p] == false)
                    {
                        int j;
                        for (j = 0; j < R; j++)
                            if (need[p][j] > work[j])
                                break;

                        if (j == R)
                        {

                            for (int k = 0 ; k < R ; k++)
                                work[k] += allot[p][k];

                            safeSeq[count++] = p;

                            finish[p] = true;

                            found = true;
                        }
                    }
                }


                System.out.println("availble matrix: ");
                for(int i=0;i<avail.length;i++) {
                	System.out.print(avail[i]+" ");
                }
                System.out.println("\n\nmax matrix: ");
                for(int i=0;i<P;i++) {
                	for(int j=0;j<R;j++) {
                		System.out.print(max[i][j]+ " ");
                	}
                	System.out.println();
                }
                System.out.println("\nneed matrix: ");
                for(int i=0;i<P;i++) {
                	for(int j=0;j<R;j++) {
                		System.out.print(need[i][j]+ " ");
                	}
                	System.out.println();
                }
                System.out.println("\nallocation matrix: ");
                for(int i=0;i<P;i++) {
                	for(int j=0;j<R;j++) {
                		System.out.print(allot[i][j]+ " ");
                	}
                	System.out.println();
                }
                
                
                if (found == false)
                {
                    System.out.print("\nSystem is not in safe state");
                    return false;
                }
            }

            System.out.print("System is in safe state.\nSafe"
                    +" sequence is: ");
            for (int i = 0; i < P ; i++)
                System.out.print(safeSeq[i] + " ");

            return true;
        }


    }

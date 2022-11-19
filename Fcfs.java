import java.util.*;

public class Fcfs {

	public static void main(String[] args) {

		int n;
		Scanner in = new Scanner(System.in);
		System.out.println("enter no of process: ");
		n = in.nextInt();
		int p_no[] = new int[n];
		int at[] = new int[n];
		int bt[] = new int[n];
		int wt[] = new int[n];
		int tat[] = new int[n];
		int ct[] = new int[n];
		int temp;
		float avgwt = 0, avgtat = 0;

		for (int i = 0; i < n; i++) {
			p_no[i]=i+1;
			System.out.println("enter arival time" + (i + 1)+" ");
			at[i] = in.nextInt();
			System.out.println("enter burst time" + (i + 1)+" ");
			bt[i] = in.nextInt();

		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (at[j] > at[j + 1]) {

					temp = at[j];
					at[j] = at[j + 1];
					at[j + 1] = temp;
					temp = bt[j];
					bt[j] = bt[j + 1];
					bt[j + 1] = temp;
					temp = p_no[j];
					p_no[j] = p_no[j + 1];
					p_no[j + 1] = temp;

				}
			}
		}

		for (int i = 0; i < n; i++) {

			if (i == 0) {
				ct[i] = at[i] + bt[i];
			} else {
				if (at[i] > ct[i - 1]) {
					ct[i] = at[i] + bt[i];
				} else {
					ct[i] = ct[i - 1] + bt[i];
				}
			}
			tat[i] = ct[i] - at[i];
			wt[i] = tat[i] - bt[i];
			avgwt += wt[i];
			avgtat += tat[i];
		}

		System.out.println("p_no\tat\tbt\tct\ttat\twt\n");
		for (int i = 0; i < n; i++) {
			System.out.println(p_no[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i] + "\n");
		}
		System.out.println("avg wt: " + avgwt/n);
		System.out.println("avg tat: " + avgtat/n);

	}

}

package spos;
import java.util.Scanner;

public class BankerAlgo {

	public static void main(String[] args) {
		new BankerAlgo().isSafe();
	}
	
	private int need[][], allocate[][], max[][], avail[][], no_of_process, no_of_resources;

	private void input() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter no. of processes : ");
		no_of_process = input.nextInt(); 
		System.out.print("Enter no. of resources : ");
		no_of_resources = input.nextInt(); 
		need = new int[no_of_process][no_of_resources]; 
		max = new int[no_of_process][no_of_resources];
		allocate = new int[no_of_process][no_of_resources];
		avail = new int[1][no_of_resources];
		System.out.println("Enter allocation matrix: ");
		for (int i = 0; i < no_of_process; i++)
			for (int j = 0; j < no_of_resources; j++)
				allocate[i][j] = input.nextInt(); 
		System.out.println("Enter max matrix: ");
		for (int i = 0; i < no_of_process; i++)
			for (int j = 0; j < no_of_resources; j++)
				max[i][j] = input.nextInt(); 
		System.out.println("Enter available matrix: ");
		for (int j = 0; j < no_of_resources; j++)
			avail[0][j] = input.nextInt(); 
		input.close();
	}
	
	private int[][] calc_need() {
		for (int i = 0; i < no_of_process; i++)
			for (int j = 0; j < no_of_resources; j++) 
				need[i][j] = max[i][j] - allocate[i][j];
		return need;
	}

	private boolean check(int i) {
		for (int j = 0; j < no_of_resources; j++)
			if (avail[0][j] < need[i][j])
				return false;
		return true;
	}

	public void isSafe() {
		input();
		calc_need();
		boolean done[] = new boolean[no_of_process];
		int j = 0;
		while (j < no_of_process) { // until all process allocated
			boolean allocated = false;
			for (int i = 0; i < no_of_process; i++)
				if (!done[i] && check(i)) { // trying to allocate
					for (int k = 0; k < no_of_resources; k++)
						avail[0][k] = avail[0][k] - need[i][k] + max[i][k];
					System.out.println("Allocated process : " + i);
					allocated = done[i] = true;
					j++;
				}
			if (!allocated)
				break;
		}
		if (j == no_of_process) 
			System.out.println("\nAllocated safely");
		else
			System.out.println("All proceess weren't allocated");
	}

}
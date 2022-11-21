package spos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Optimal {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner in= new Scanner(System.in);
		int frames, pointer = 0, hit = 0, fault = 0, ref_len;
		boolean isFull = false;
		int buffer[];
		int reference[];
		int mem_layout[][];
		System.out.println("Please enter the number of Frames: ");
		frames = in.nextInt();
		System.out.println("Please enter the length of the Reference string:");
		ref_len = in.nextInt();
		reference = new int[ref_len];
		mem_layout = new int[ref_len][frames];
		buffer = new int[frames];
		for (int j = 0; j < frames; j++)
			buffer[j] = -1;
		System.out.println("Please enter the reference string: ");
		for (int i = 0; i < ref_len; i++) {
			reference[i] = in.nextInt();
		}
		System.out.println();
		for (int i = 0; i < ref_len; i++) {
			int search = -1;
			for (int j = 0; j < frames; j++) {
				if (buffer[j] == reference[i]) {
					search = j;
					hit++;
					break;
				}
			}
			if (search == -1) {
				if (isFull) {
					int index[] = new int[frames];
					boolean index_flag[] = new boolean[frames];
					for (int j = i + 1; j < ref_len; j++) {
						for (int k = 0; k < frames; k++) {
							if ((reference[j] == buffer[k]) && (index_flag[k] == false)) {
								index[k] = j;
								index_flag[k] = true;
								break;
							}
						}
					}
					int max = index[0];
					pointer = 0;
					if (max == 0)
						max = 200;
					for (int j = 0; j < frames; j++) {
						if (index[j] == 0)
							index[j] = 200;
						if (index[j] > max) {
							max = index[j];
							pointer = j;
						}
					}
				}
				buffer[pointer] = reference[i];
				fault++;
				if (!isFull) {
					pointer++;
					if (pointer == frames) {
						pointer = 0;
						isFull = true;
					}
				}
			}
			for (int j = 0; j < frames; j++)
				mem_layout[i][j] = buffer[j];
		}
		System.out.println("1st frame\t 2nd frame\t 3rd frame");
		for (int j = 0; j < ref_len; j++) {
			for (int i = 0; i < frames; i++) {
//				Thread.sleep(1500);
				System.out.printf("%3d \t\t", mem_layout[j][i]);
			}
			System.out.println();
		}
		System.out.println("The number of Hits: " + hit);
		System.out.println("Hit Ratio: " + (float) ((float) hit / ref_len));
		System.out.println("The number of Faults: " + fault);
	}
}
package spos;
import java.util.ArrayList;
public class Lru {
	

	public static void main(String[] args) {
		int capacity = 3;
		int arr[] = {2 ,3 ,2 ,1 ,5 ,2 ,4 ,5 ,3 ,2 ,5 ,2 };
		
		
		ArrayList<Integer> s=new ArrayList<>(capacity);
		int count=0;
		int page_faults=0;
		for(int i:arr)
		{
			// Insert it into set if not present
			if(!s.contains(i))
			{
			
			// Check if the set can hold equal pages
			if(s.size()==capacity)
			{
				s.remove(0);
				s.add(capacity-1,i);
			}
			else
				s.add(count,i);
				page_faults++;
				++count;
		
			}
			else
			{

				s.remove((Object)i);
				s.add(s.size(),i);		
			}
		
		}
		System.out.println("page faults: " + page_faults);
	}
}

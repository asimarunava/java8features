/// Java 8 List Sorting
package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortListElelments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> mylist = Arrays.asList(10,6,87,5,90,0,22,50);
	
		       Comparator<String> cmpStringLength = Comparator.comparingInt(String::length)
		                  .thenComparing(String.CASE_INSENSITIVE_ORDER);
		       
		       Comparator<Integer> cmpIntValue = Comparator.comparingInt(Integer::intValue);
		       mylist.sort(cmpIntValue);
		       System.out.println(mylist);
		       
		      }

	}



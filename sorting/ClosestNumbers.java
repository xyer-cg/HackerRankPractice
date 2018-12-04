package sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClosestNumbers
{
	static int [] closestNumbers (int [] arr)
	{
		List <Integer> numbers = new ArrayList <Integer> ();
		
		Arrays.sort (arr);
		int smallest = arr [1] - arr [0];
		numbers.add (arr [0]);
		numbers.add (arr [1]);
		
		for (int i = 2; i < arr.length; ++ i)
		{
			int diff = arr [i] - arr [i - 1];
			
			if (diff <= smallest)
			{
				if (diff < smallest)
				{
					numbers.clear ();
					smallest = diff;
				}
				
				numbers.add (arr [i - 1]);
				numbers.add (arr [i]);
			}
		}
		
		return numbers.stream ().mapToInt (i -> i).toArray ();
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		int n = scanner.nextInt ();
		scanner.skip ("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int [] arr = new int [n];

		String [] arrItems = scanner.nextLine ().split (" ");
		scanner.skip ("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i ++)
		{
			int arrItem = Integer.parseInt (arrItems [i]);
			arr [i] = arrItem;
		}

		int [] result = closestNumbers (arr);

		for (int i = 0; i < result.length; i ++)
		{
			bufferedWriter.write (String.valueOf (result [i]));

			if (i != result.length - 1)
			{
				bufferedWriter.write (" ");
			}
		}

		bufferedWriter.newLine ();

		bufferedWriter.close ();

		scanner.close ();
	}
}

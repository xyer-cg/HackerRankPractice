package search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Pairs
{
	static int pairs (int k, int [] arr)
	{
		Arrays.sort (arr);
		
		int count = 0;
		int i = 0, j = 1;
		
		while (j < arr.length)
		{
			int difference = arr [j] - arr [i];
			if (difference < k) j ++;
			else if (difference > k) i ++;
			else
			{
				i ++;
				j ++;
				count ++;
			}
		}
		
		return count;
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		String [] nk = scanner.nextLine ().split (" ");

		int n = Integer.parseInt (nk [0]);

		int k = Integer.parseInt (nk [1]);

		int [] arr = new int [n];

		String [] arrItems = scanner.nextLine ().split (" ");
		scanner.skip ("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i ++)
		{
			int arrItem = Integer.parseInt (arrItems [i]);
			arr [i] = arrItem;
		}

		int result = pairs (k, arr);

		bufferedWriter.write (String.valueOf (result));
		bufferedWriter.newLine ();

		bufferedWriter.close ();

		scanner.close ();
	}
}

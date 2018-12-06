package search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MissingNumbers
{
	static int [] missingNumbers (int [] arr, int [] brr)
	{
		Map <Integer, Integer> aMap = new HashMap <Integer, Integer> ();
		for (int a : arr)
		{
			int value = aMap.getOrDefault (a, 0);
			aMap.put (a, ++ value);
		}

		Map <Integer, Integer> bMap = new HashMap <Integer, Integer> ();
		for (int b : brr)
		{
			int value = bMap.getOrDefault (b, 0);
			bMap.put (b, ++ value);
		}

		Set <Integer> set = new LinkedHashSet <Integer> ();
		for (int key : bMap.keySet ())
		{
			int value = aMap.getOrDefault (key, 0);
			if (value < bMap.get (key)) set.add (key);
		}

		return set.stream ().sorted ().mapToInt (i -> i).toArray ();
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

		int m = scanner.nextInt ();
		scanner.skip ("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int [] brr = new int [m];

		String [] brrItems = scanner.nextLine ().split (" ");
		scanner.skip ("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i ++)
		{
			int brrItem = Integer.parseInt (brrItems [i]);
			brr [i] = brrItem;
		}

		int [] result = missingNumbers (arr, brr);

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

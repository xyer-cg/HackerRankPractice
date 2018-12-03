package search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MissingNumbers
{
	static int [] missingNumbers (int [] arr, int [] brr)
	{
		Map <Integer, Integer> aMap = new HashMap <Integer, Integer> ();
		for (int a : arr)
		{
			if (aMap.get (a) != null) aMap.put (a, aMap.get (a) + 1);
			else aMap.put (a, 1);
		}

		Map <Integer, Integer> bMap = new HashMap <Integer, Integer> ();
		for (int b : brr)
		{
			if (bMap.get (b) != null) bMap.put (b, bMap.get (b) + 1);
			else bMap.put (b, 1);
		}

		List <Integer> list = new ArrayList <Integer> ();
		for (int i : bMap.keySet ())

			if (aMap.get (i) == null || bMap.get (i) > aMap.get (i))

				if (!list.contains (i)) list.add (i);

		return list.stream ().sorted ().mapToInt (i -> i).toArray ();
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

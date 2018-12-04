package search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IceCreamParlor
{
	static int [] icecreamParlor (int m, int [] arr)
	{	
		for (int i = 0; i < arr.length - 1; ++ i)
		{
			for (int j = i + 1; j < arr.length; ++ j)
			{
				if (arr [i] + arr [j] == m)
					
					return new int [] {Math.min (i + 1, j + 1), Math.max (i + 1, j + 1)};
			}
		}
		
		return new int [] {};
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		int t = scanner.nextInt ();
		scanner.skip ("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr ++)
		{
			int m = scanner.nextInt ();
			scanner.skip ("(\r\n|[\n\r\u2028\u2029\u0085])?");

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

			int [] result = icecreamParlor (m, arr);

			for (int i = 0; i < result.length; i ++)
			{
				bufferedWriter.write (String.valueOf (result [i]));

				if (i != result.length - 1)
				{
					bufferedWriter.write (" ");
				}
			}

			bufferedWriter.newLine ();
		}

		bufferedWriter.close ();

		scanner.close ();
	}
}
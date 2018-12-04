package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort2
{
	static void insertionSort2 (int n, int [] arr)
	{
		for (int i = 1; i < n; ++ i)
		{
			int j = i;
			while (j > 0 && arr [j] < arr [j - 1])
			{
				arr [j] = (arr [j] + arr [j - 1]) - (arr [j - 1] = arr [j]);
				j --;
			}
			
			System.out.println (Arrays.toString (arr).replaceAll ("[\\[\\],]", ""));
		}
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args)
	{
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

		insertionSort2 (n, arr);

		scanner.close ();
	}
}

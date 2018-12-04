package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort1
{

	static void insertionSort1 (int n, int [] arr)
	{
		if (n > 0)
		{	
			n --;
			int current = arr [n];
			int i = n - 1;
			
			while (i >= 0 && arr [i] > current)
			{
				arr [i + 1] = arr [i];
				System.out.println (Arrays.toString (arr).replaceAll ("[\\[\\],]", ""));
				i --;
			}
			
			if (i != n - 1)
			{
				arr [i + 1] = current;
				System.out.println (Arrays.toString (arr).replaceAll ("[\\[\\],]", ""));
			}

			insertionSort1 (n, arr);
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

		insertionSort1 (n, arr);

		scanner.close ();
	}
}

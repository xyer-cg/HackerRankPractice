package sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IntroToTutorialChallenges
{
	static int introTutorial (int V, int [] arr)
	{
		return Arrays.stream (arr).boxed ().collect (Collectors.toList ()).indexOf (V);
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		int V = scanner.nextInt ();
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

		int result = introTutorial (V, arr);

		bufferedWriter.write (String.valueOf (result));
		bufferedWriter.newLine ();

		bufferedWriter.close ();

		scanner.close ();
	}
}

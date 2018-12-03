package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Anagram
{
	static int anagram (String s)
	{
		if (s.length () % 2 == 1) return -1;
		
		int mid = s.length () / 2;
		
		String left = s.substring (0, mid);
		String right = s.substring (mid);
		
		for (int i = 0; i < left.length (); ++ i)
		{
			if (right.contains (left.substring (i, i + 1)))
				
				right = right.replaceFirst (left.substring (i, i + 1), "");
		}
		
		return right.length ();
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		int q = scanner.nextInt ();
		scanner.skip ("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr ++)
		{
			String s = scanner.nextLine ();

			int result = anagram (s);

			bufferedWriter.write (String.valueOf (result));
			bufferedWriter.newLine ();
		}

		bufferedWriter.close ();

		scanner.close ();
	}
}
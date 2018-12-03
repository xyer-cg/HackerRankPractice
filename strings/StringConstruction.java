package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringConstruction
{
	static int stringConstruction (String s)
	{
		char [] chars = s.toCharArray ();
		Set <Character> set = new HashSet <Character> ();
		for (char c : chars) set.add (c);
		return set.size ();
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

			int result = stringConstruction (s);

			bufferedWriter.write (String.valueOf (result));
			bufferedWriter.newLine ();
		}

		bufferedWriter.close ();

		scanner.close ();
	}
}

package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters
{
	static int alternatingCharacters (String s)
	{
		int result = 0;

		char [] chars = s.toCharArray ();

		for (int i = 0, j = 1; j < chars.length; i = j, ++ j)
		{
			while (j < chars.length && chars [i] == chars [j])
			{
				result ++;
				j ++;
			}
		}

		return result;
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

			int result = alternatingCharacters (s);

			bufferedWriter.write (String.valueOf (result));
			bufferedWriter.newLine ();
		}

		bufferedWriter.close ();

		scanner.close ();
	}
}

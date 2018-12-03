package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoveLetterMystery
{
	static int theLoveLetterMystery (String s)
	{
		char [] chars = s.toCharArray ();
		
		int i = 0, j = chars.length - 1, result = 0;
		
		while (i < j)
			
			result += Math.abs (chars [j --] - chars [i ++]);
		
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

			int result = theLoveLetterMystery (s);

			bufferedWriter.write (String.valueOf (result));
			bufferedWriter.newLine ();
		}

		bufferedWriter.close ();

		scanner.close ();
	}
}

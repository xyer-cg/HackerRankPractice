package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FunnyString
{
	static String funnyString (String s)
	{
		char [] sArr = s.toCharArray ();
		char [] rArr = new StringBuilder (s).reverse ().toString ().toCharArray ();
		
		for (int i = 0; i < sArr.length - 1; ++ i)
		{
			int sDiff = Math.abs (sArr [i] - sArr [i + 1]);
			int rDiff = Math.abs (rArr [i] - rArr [i + 1]);
			
			if (sDiff != rDiff) return "Not Funny";
		}
		
		return "Funny";
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

			String result = funnyString (s);

			bufferedWriter.write (result);
			bufferedWriter.newLine ();
		}

		bufferedWriter.close ();

		scanner.close ();
	}
}

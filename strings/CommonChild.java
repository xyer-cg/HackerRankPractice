package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CommonChild
{
	static int commonChild (String s1, String s2)
	{
		int [][] table = new int [s1.length () + 1][s2.length () + 1];

		for (int i = 0; i < s1.length () + 1; ++ i)
		{
			for (int j = 0; j < s2.length () + 1; ++ j)
			{
				if (i == 0 || j == 0) table [i][j] = 0;
				else if (s1.charAt (i - 1) == s2.charAt (j - 1)) table [i][j] = table [i - 1][j - 1] + 1;
				else table [i][j] = Math.max (table [i - 1][j], table [i][j - 1]);
			}
		}
		
		return table [s1.length ()][s2.length ()];
	}
	
	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		String s1 = scanner.nextLine ();

		String s2 = scanner.nextLine ();

		int result = commonChild (s1, s2);

		bufferedWriter.write (String.valueOf (result));
		bufferedWriter.newLine ();

		bufferedWriter.close ();

		scanner.close ();
	}
}

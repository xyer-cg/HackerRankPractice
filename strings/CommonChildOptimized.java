package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CommonChildOptimized
{
	static int commonChild (String s1, String s2)
	{
		int start = 0;
		int end1 = s1.length ();
		int end2 = s2.length ();
		
		while (start < end1 && start < end2 && s1.charAt (start) == s2.charAt (start)) start ++;
		while (start < end1 && start < end2 && s1.charAt (end1 - 1) == s2.charAt (end2 - 1))
		{
			end1 --;
			end2 --;
		}
		
		int [][] table = new int [end1 - start + 1][end2 - start + 1];
		
		for (int i = 0; i < table.length; ++ i)
		{
			for (int j = 0; j < table [0].length; ++ j)
			{
				if (i == 0 || j == 0) table [i][j] = 0;
				else if (s1.charAt (start + i - 1) == s2.charAt (start + j - 1)) table [i][j] = table [i - 1][j - 1] + 1;
				else table [i][j] = Math.max (table [i - 1][j], table [i][j - 1]);
			}
		}
		
		return table [table.length - 1][table [0].length - 1] + start + (s1.length () - end1);
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

package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MarsExploration
{
	static int marsExploration (String s)
	{
		int result = 0;
		for (int i = 0; i < s.length (); i += 3)
		{
			char [] sos = s.substring (i, i + 3).toCharArray ();
			if (sos [0] != 'S') result ++;
			if (sos [1] != 'O') result ++;
			if (sos [2] != 'S') result ++;
		}
		
		return result;
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		String s = scanner.nextLine ();

		int result = marsExploration (s);

		bufferedWriter.write (String.valueOf (result));
		bufferedWriter.newLine ();

		bufferedWriter.close ();

		scanner.close ();
	}
}

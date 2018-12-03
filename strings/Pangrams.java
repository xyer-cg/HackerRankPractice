package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangrams
{
	static String pangrams (String s)
	{
		s = s.replaceAll ("[^a-zA-Z]", "").toUpperCase ();

		Set <Character> set = new HashSet <Character> ();
		for (char c : s.toCharArray ()) set.add (c);

		return set.size () == 26 ? "pangram" : "not pangram";
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		String s = scanner.nextLine ();

		String result = pangrams (s);

		bufferedWriter.write (result);
		bufferedWriter.newLine ();

		bufferedWriter.close ();

		scanner.close ();
	}
}
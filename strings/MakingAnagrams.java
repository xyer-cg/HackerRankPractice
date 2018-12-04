package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MakingAnagrams
{
	static int makingAnagrams (String s1, String s2)
	{
		int [] s1Count = new int [26];
		int [] s2Count = new int [26];
		
		for (char c : s1.toCharArray ()) s1Count [c - 'a'] ++;
		for (char c : s2.toCharArray ()) s2Count [c - 'a'] ++;
		
		int result = 0;
		for (int i = 0; i < s1Count.length; ++ i) result += Math.abs (s1Count [i] - s2Count [i]);
		
		return result;
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		String s1 = scanner.nextLine ();

		String s2 = scanner.nextLine ();

		int result = makingAnagrams (s1, s2);

		bufferedWriter.write (String.valueOf (result));
		bufferedWriter.newLine ();

		bufferedWriter.close ();

		scanner.close ();
	}
}

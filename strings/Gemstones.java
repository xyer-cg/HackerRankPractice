package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Gemstones
{
	static int gemstones (String [] arr)
	{
		Set <Character> gems = new HashSet <Character> ();
		for (char c : arr [0].toCharArray ()) gems.add (c);
		
		for (int i = 1; i < arr.length; ++ i)
		{
			Set <Character> current = new HashSet <Character> ();
			for (char c : gems)
			
				if (arr [i].indexOf (c) != -1) current.add (c);
			
			gems = current;
		}
		
		return gems.size ();
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		int n = scanner.nextInt ();
		scanner.skip ("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String [] arr = new String [n];

		for (int i = 0; i < n; i ++)
		{
			String arrItem = scanner.nextLine ();
			arr [i] = arrItem;
		}

		int result = gemstones (arr);

		bufferedWriter.write (String.valueOf (result));
		bufferedWriter.newLine ();

		bufferedWriter.close ();

		scanner.close ();
	}
}

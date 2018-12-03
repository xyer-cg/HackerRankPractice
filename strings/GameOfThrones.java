package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameOfThrones
{
	static String gameOfThrones (String s)
	{
		Map <Character, Integer> map = new HashMap <Character, Integer> ();
		
		for (char c : s.toCharArray ())
		{
			int value = map.getOrDefault (c, 0);
			map.put (c, ++ value);
		}
		
		int countOdd = 0;
		for (int i : map.values ())
		{
			if (i % 2 == 1)
			{
				countOdd ++;
				if (countOdd == 2) return "NO";
			}
		}
		
		return "YES";
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		String s = scanner.nextLine ();

		String result = gameOfThrones (s);

		bufferedWriter.write (result);
		bufferedWriter.newLine ();

		bufferedWriter.close ();

		scanner.close ();
	}
}

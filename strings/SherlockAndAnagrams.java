package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndAnagrams
{
	static int sherlockAndAnagrams (String s)
	{
		Map <String, Integer> map = new HashMap <String, Integer> ();
		int result = 0;

		for (int i = 0; i < s.length (); i ++)
		{
			for (int j = i + 1; j <= s.length (); j ++)
			{	
				char [] chars = s.substring (i, j).toCharArray ();
				Arrays.sort (chars);
				String substring = String.valueOf (chars);
				
				int value = map.getOrDefault (substring, 0);
				result += value;
				map.put (substring, ++ value);
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

			int result = sherlockAndAnagrams (s);

			bufferedWriter.write (String.valueOf (result));
			bufferedWriter.newLine ();
		}

		bufferedWriter.close ();

		scanner.close ();
	}
}

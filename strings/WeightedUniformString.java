package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WeightedUniformString
{
	static String [] weightedUniformStrings (String s, int [] queries)
	{
		Set <Integer> weights = new HashSet <Integer> ();
		
		int i = 0, j = 1;
		char [] chars = s.toCharArray ();

		while (i < chars.length)
		{
			weights.add (chars [i] - 'a' + 1);
			while (j < chars.length && chars [i] == chars [j])
			{
				weights.add ((chars [i] - 'a' + 1) * (j - i + 1));
				j ++;
			}

			i = j ++;
		}

		List <String> results = new ArrayList <String> ();

		for (int query : queries) results.add (weights.contains (query) ? "Yes" : "No");
		return results.toArray (new String [0]);
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		String s = scanner.nextLine ();

		int queriesCount = scanner.nextInt ();
		scanner.skip ("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int [] queries = new int [queriesCount];

		for (int i = 0; i < queriesCount; i ++)
		{
			int queriesItem = scanner.nextInt ();
			scanner.skip ("(\r\n|[\n\r\u2028\u2029\u0085])?");
			queries [i] = queriesItem;
		}

		String [] result = weightedUniformStrings (s, queries);

		for (int i = 0; i < result.length; i ++)
		{
			bufferedWriter.write (result [i]);

			if (i != result.length - 1)
			{
				bufferedWriter.write ("\n");
			}
		}

		bufferedWriter.newLine ();

		bufferedWriter.close ();

		scanner.close ();
	}
}

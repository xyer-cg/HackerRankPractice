package strings;

import java.util.Scanner;

public class SeparateTheNumbers
{
	static void separateNumbers (String s)
	{
		boolean result = false;
		long first = 0;

		int i = 1;
		while (!result && i <= s.length () / 2)
		{
			first = Long.parseLong (s.substring (0, i ++));
			StringBuilder sb = new StringBuilder ().append (first);

			long next = first;
			while (sb.length () < s.length ()) sb.append (++ next);

			if (sb.toString ().equals (s)) result = true;
		}

		System.out.println (result ? "YES " + first : "NO");
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args)
	{
		int q = scanner.nextInt ();
		scanner.skip ("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr ++)
		{
			String s = scanner.nextLine ();

			separateNumbers (s);
		}

		scanner.close ();
	}
}

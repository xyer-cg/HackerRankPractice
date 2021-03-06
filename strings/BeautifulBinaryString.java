package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BeautifulBinaryString
{
	static int beautifulBinaryString (String b)
	{
		return b.replaceAll ("010", "x").replaceAll ("[01]", "").length ();
	}

	private static final Scanner scanner = new Scanner (System.in);

	public static void main (String [] args) throws IOException
	{
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		scanner.nextInt ();
		scanner.skip ("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String b = scanner.nextLine ();

		int result = beautifulBinaryString (b);

		bufferedWriter.write (String.valueOf (result));
		bufferedWriter.newLine ();

		bufferedWriter.close ();

		scanner.close ();
	}
}
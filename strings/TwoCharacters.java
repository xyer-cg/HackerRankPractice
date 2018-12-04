package strings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class TwoCharacters
{
	static int alternate (String s)
	{
		Character [] distinct = s.chars ().mapToObj (c -> (char) c).collect (Collectors.toSet ()).toArray (new Character [0]);
		
		int max = 0;
		for (int i = 0; i < distinct.length - 1; ++ i)
		{
			for (int j = i + 1; j < distinct.length; ++ j)
			{
				char first = distinct [i];
				char second = distinct [j];
				
				char [] eval = s.replaceAll ("[^" + first + second + "]", "").toCharArray ();
				
				int k = 1;
				while (k < eval.length)
				{
					if (eval [k] == eval [k - 1])
						
						k = eval.length;
					
					k ++;
				}
				
				if (k == eval.length) max = Math.max (max, k);
			}
		}
		
		return max;
	}

	public static void main (String [] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (System.in));
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

		int l = Integer.parseInt (bufferedReader.readLine ().trim ());

		String s = bufferedReader.readLine ();

		int result = alternate (s);

		bufferedWriter.write (String.valueOf (result));
		bufferedWriter.newLine ();

		bufferedReader.close ();
		bufferedWriter.close ();
	}
}

package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CamelCase
{
    static int camelcase (String s)
    {
        int count = 1;
        for (char c : s.toCharArray ()) if (Character.isUpperCase (c)) count ++;

        return count;
    }

    private static final Scanner scanner = new Scanner (System.in);

    public static void main (String[] args) throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

        String s = scanner.nextLine ();

        int result = camelcase (s);

        bufferedWriter.write (String.valueOf (result));
        bufferedWriter.newLine ();

        bufferedWriter.close ();

        scanner.close ();
    }
}

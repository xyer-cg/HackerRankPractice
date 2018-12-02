import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperReducedString
{
    static String superReducedString (String s)
    {
        StringBuilder result = new StringBuilder ();
        for (char c : s.toCharArray ())
        {
            int length = result.length ();
            if (length > 0 && result.charAt (length - 1) == c) result.deleteCharAt (length - 1);
            else result.append (c);
        }

        return result.length () == 0 ? "Empty String" : result.toString ();
    }

    public static void main (String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (System.in));
        BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System.getenv ("OUTPUT_PATH")));

        String s = bufferedReader.readLine ();

        String result = superReducedString (s);

        bufferedWriter.write (result);
        bufferedWriter.newLine ();

        bufferedReader.close ();
        bufferedWriter.close ();
    }
}

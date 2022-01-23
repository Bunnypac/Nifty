
import java.net.*;
import java.io.*;


public class Nifty
{
    public static void main(String[] args)
    {
        String output  = getUrlContents("https://www.nseindia.com/api/equity-stockIndices?index=NIFTY%20BANK");
        System.out.println(output);
    }

    private static String getUrlContents(String theUrl)
    {
        StringBuilder content = new StringBuilder();
        // Use try and catch to avoid the exceptions
        try
        {
            URL url = new URL(theUrl); // creating a url object
            URLConnection urlConnection = url.openConnection(); // creating a urlconnection object
            urlConnection.setRequestProperty("accept-encoding","gzip, deflate, br");
            urlConnection.setRequestProperty("accept-language","en-US,en;q=0.9");
            urlConnection.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.99 Safari/537.36 Edg/97.0.1072.69");
            urlConnection.setRequestProperty("cookie","F88FD4A93257606B404145B6286FF5B0~bj6rTwu4hrKdt5Vwxrtnj7JBouXz9dtbqmQYkJbHXHNlgKtLVoCrOCqVpN3qIVREsvjM8BUWu2rzZsMlDqOPustbPBzanQt9k7axrA7mcq7mltonNawlvOPK1K/nzv6pcb2zMKzXVXIwmOYb97IeumXQ1mSCCOcN+33cSGOukLk=");
            urlConnection.setRequestProperty("content-type","text/html; charset=utf-8");

            // wrapping the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // reading from the urlconnection using the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
}
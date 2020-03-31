package smith_problem2;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class DuplicateCounter 
{
	HashMap<String, Integer> wordCounter= new HashMap<String, Integer>();
	int i;
	public void count (String dataFile)
	{
		try
		{
			File p1s = new File(dataFile);
			Scanner scanner = new Scanner(p1s);
			
			while(scanner.hasNextLine())
			{
				//using scanner to iterate through file
				String line = scanner.nextLine();
				String[] wC = line.split(" ");
				
				for (String word : wC)
					{
					//setting to lowercase and removing punctuation
					  String lcra = wC[i].toLowerCase().replaceAll("\\p{Punct}", "");
					  
					  if (wordCounter.containsKey(lcra))
					  {
						  wordCounter.put(lcra, wordCounter.get(lcra) + 1);
					  }
					  else
					  {
						  wordCounter.put(lcra, 1);
					  }
					}
			}
			scanner.close();
			//System.out.println(wordCounter);
		}
		catch (Exception e)
		{
			System.out.printf("Hey bud, I'm afraid I gotta let you know that we ran into a bit of an error, check it out.\n");
			System.out.println(e);
			return;
		}
	}
	public void write (String outputFile)
	{
		try
		{
			//using an iterator to iterate through hashset and write to file
			FileWriter writer = new FileWriter(outputFile);
			for (HashMap.Entry<String, Integer> entry : wordCounter.entrySet())
			{
				writer.write(entry.getKey() + " occurs " + entry.getValue() + " times. ");
				writer.write(" \n");
			}
			writer.close();
		}
		catch (Exception e)
		{
			System.out.printf("Hey bud, I'm afraid I gotta let you know that we ran into a bit of an error, check it out.\n");
			System.out.println(e);
			//writer.close();
			return;
		}
	}

}

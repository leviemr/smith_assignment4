
//Library imports here
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover 
{
	//declaring variables
	int i;
	Set <String>uniqueWords = new HashSet<>();

	
	public void remove(String dataFile)
	{
		try 
		{
			//declaring file to be read, and scanner object
			File p1s = new File(dataFile);
			Scanner scanner = new Scanner(p1s);
			while(scanner.hasNextLine())
			{
				//using scanner to iterate through file
				String line = scanner.nextLine();
				String[] uW = line.split(" ");
				for (i = 0; i < uW.length; i++)
					{
					//setting to lowercase and removing punctuation
					  String lcra = uW[i].toLowerCase().replaceAll("\\p{Punct}", "");
					  //adding to hashset
					  uniqueWords.add(lcra);
					}
				
			}
			scanner.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.printf("Hey bud, I'm afraid I gotta let you know that we ran into a bit of an error, check it out.\n");
			System.out.println(e);
			return;
			
		}
		//Needs to use a Set of Strings to eliminate duplicate words
		//from file referenced by dataFile
		
	}
	
	public void write(String outputFile)
	{
		try
		{
			//using an iterator to iterate through hashset and write to file
			Iterator<String> it = uniqueWords.iterator();
			FileWriter writer = new FileWriter(outputFile);
			while(it.hasNext())
			{
				writer.write(it.next());
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

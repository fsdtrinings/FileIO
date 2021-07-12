package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandlingDemo {

	public static void main(String[] args) {
		
		String path = "C:\\Users\\ashis\\OneDrive\\Desktop\\FIS Global\\Workspace\\JavaDemo\\src\\p1\\Account.java";
		
		try {
		
			File f = new File(path);
			File f2 = new File("d:\\fisTest.txt");
			new FileHandlingDemo().readFile(f);
			new FileHandlingDemo().printFile(f2);
			
			
		} catch (Exception e) {
				System.out.println(e);
		}
		
	}//end main
	
	
	public void printFile(File f2)throws Exception
	{
		System.out.println(" Printing ....");
		PrintWriter pw = new PrintWriter(f2);
		pw.append("dfverg");
		pw.close();
		System.out.println("done ---");
	}
	
	public void readFile(File f)throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String line = null;
		
		while((line = br.readLine())!=null)
		{
			System.out.println(line);
		}
	}
}//end class












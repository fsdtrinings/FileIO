package day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class SerializationDemo {

	String basepath = "C:\\Users\\ashis\\OneDrive\\Desktop\\FIS Global\\dump\\";
	String fileName = "oldapproach.txt";
	String fileName2 = "SerApproach.txt";
	
	
	public static void main(String[] args) {
		
		SerializationDemo obj = new SerializationDemo();
		try {
			//obj.oldApproach();
			
			String filePath = obj.basepath+""+obj.fileName2;
			
			Account a = new Account(101, "Ramesh", 2000);
			File serFile = new File(filePath);
			obj.saveSerializableAccount(serFile,a);
			
			
			obj.readSerializableAccount(serFile);
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public void saveSerializableAccount(File serfile,Account account) throws Exception
	{
		
		FileOutputStream fos = new FileOutputStream(serfile);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(account);  // List<Account>
		oos.close();
		
	}
	
	public void readSerializableAccount(File serfile) throws Exception
	{
		 FileInputStream fis = new FileInputStream(serfile);
		 ObjectInputStream ois = new ObjectInputStream(fis);
		 
		 //// read List<Account> balance based on r1-r2
		 Account account = (Account)ois.readObject(); 
		 // List<Account> list = (List<Account>) ois.readObject();
		 System.out.println(account.getAccountHolderName());
		 System.out.println(account.getBalance());
		 System.out.println(account.fundTransfer(200));
		 
		 
		 
	}
	
	
	
	public void oldApproach() throws Exception// working with data
	{
		File f = new File(basepath+""+fileName);
		PrintWriter pw = new PrintWriter(new FileWriter(f,true));
		
		Account a = new Account(101, "Ramesh", 2000);
		// cannot work with Object
		//pw.append(a); // error
		pw.append(a.getAccountNumber()+" - "+a.getAccountHolderName()+" - "+a.getBalance());
		pw.close();
	}

}//end class

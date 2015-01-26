package threadpoolexample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task implements Runnable{
	
	@Override
	public void run() {		
		
		try {
			File f = null; 
			FileReader fr = null;
			f = new File("C:\\Users\\Niravkumar\\Desktop\\Temp.txt");
			fr = new FileReader(f);
			String line = null;
			BufferedReader bf = new BufferedReader(fr);
			while((line = bf.readLine())!=null){
				//System.out.println(Thread.currentThread().getId()+"::"+line);
			}
			System.out.println("Done");
			bf.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

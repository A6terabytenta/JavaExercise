package example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {

	/**
	 * @author TA
	 * @param resource
	 * @throws IOException
	 * Execute: read file input and print contents
	 */
	public static void readFile(String resource) {
		FileInputStream fis = null;
		try {
			File file = new File(resource);
			fis = new FileInputStream(file);
			int i;
			while ((i = fis.read()) != -1) {
				System.out.print((char) i);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		readFile("input.txt");
		System.out.println("done!");
	}
}

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
	public static void readFile(String resource) throws IOException {
		File file = new File(resource);
		FileInputStream fis = new FileInputStream(file);
		int i;
		while ((i = fis.read()) != -1) {
			System.out.print((char) i);
		}

		fis.close();
	}

	public static void main(String[] args) throws IOException {
		readFile("input.txt");
		System.out.println("done!");
	}
}

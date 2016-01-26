package example;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamExample {
	public static void readFile(String resource) throws IOException {
		File file = new File(resource);
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		bis.skip(7);
		int i;
		while ((i = bis.read()) != -1) {
			System.out.print((char) i);
		}
		fis.close();
	}

	public static void main(String[] args) throws IOException {
		readFile("input.txt");
		System.out.println();
		System.out.println("done!");
	}
}
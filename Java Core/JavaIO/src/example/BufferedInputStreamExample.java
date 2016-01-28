package example;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamExample {

	/**
	 * @author TA
	 * @param resource
	 * @throws IOException
	 *             Execute: read file index.txt
	 */
	public static void readFile(String resource) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			File file = new File(resource);
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bis.skip(7);
			int i;
			while ((i = bis.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		readFile("input.txt");
		System.out.println();
		System.out.println("done!");
	}
}

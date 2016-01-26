package example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamExample {

	/**
	 * @author TA
	 * @param source
	 * @param target
	 * @throws IOException
	 * Execute: Write contents of file input to file output
	 */
	public static void writeFile(String source, String target)
			throws IOException {
		File fileInput = new File(source);
		File fileOutput = new File(target);
		FileInputStream fis = new FileInputStream(fileInput);
		FileOutputStream fos = new FileOutputStream(fileOutput);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bis.skip(7);

		int i;

		while ((i = bis.read()) != -1) {
			bos.write(i);
			bos.flush();
		}

		bis.close();
		bos.close();
	}

	public static void main(String[] args) throws IOException {
		writeFile("input.txt", "output.txt");
		System.out.println("done!");
	}
}

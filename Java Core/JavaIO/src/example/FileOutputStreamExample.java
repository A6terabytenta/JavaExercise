package example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
	/**
	 * @author TA
	 * @param source
	 * @param target
	 * @throws IOException
	 *             Execute: Write contents of file input to file output
	 */
	public static void writeFile(String source, String target) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			File fileInput = new File(source);
			File fileOutput = new File(target);
			fis = new FileInputStream(fileInput);
			fos = new FileOutputStream(fileOutput);

			int i;

			while ((i = fis.read()) != -1) {
				fos.write(i);
				fos.flush();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		writeFile("input.txt", "output.txt");
		System.out.println("done!");
	}
}

package example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	public static void writeFile(String source, String target) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			File fileInput = new File(source);
			File fileOutput = new File(target);
			FileInputStream fis;
			fis = new FileInputStream(fileInput);
			FileOutputStream fos = new FileOutputStream(fileOutput);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			bis.skip(7);

			int i;

			while ((i = bis.read()) != -1) {
				bos.write(i);
				bos.flush();
			}

			bis.close();
			bos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		writeFile("input.txt", "output.txt");
		System.out.println("done!");
	}
}

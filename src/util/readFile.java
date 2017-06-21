package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class readFile {

	public static double[][] readFiles(String path, int line, int column) {

		double file[][] = new double[line][column];

		try {
			BufferedReader lerArq = new BufferedReader(new FileReader(path));

			for (int j = 0; j < line; j++) {
				String aux = lerArq.readLine();
				StringTokenizer tokens = new StringTokenizer(aux);

				for (int i = 0; i < column; i++) {
					file[j][i] = Double.parseDouble(tokens.nextToken().trim());
				}

			}
			lerArq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}

}

package Network.SimpleNetwork;

import Config.AdalineConfig;
import util.readFile;

public class MainAdaline {

	static Adaline ad = new Adaline();

	public static void Start(String Path1, String Path2) {

		double Samples[][] = readFile.readFiles(Path1, AdalineConfig.NUMBER_SAMPLES, AdalineConfig.NUMBER_INPUT);
		double Result[][] = readFile.readFiles(Path2, AdalineConfig.NUMBER_SAMPLES, AdalineConfig.NUMBER_OUTPUT);

		ad.trainer(Samples, Result);
	}

	public static void InputToPrint(double[] value) {
		double[] result = ad.execution(value);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
	
	public static void InputToPrint(double[][] value) {

		for (int i = 0; i < value.length; i++) {
			double[] result = ad.execution(value[i]);

			for (int j = 0; j < result.length; j++) {
				System.out.print(result[j] + " ");
			}
			System.out.println();
		}

	}
	
}

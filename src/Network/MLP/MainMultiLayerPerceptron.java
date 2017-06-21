package Network.MLP;

import Config.MultiplayerPerceptronConfig;
import util.readFile;

public class MainMultiLayerPerceptron {

	static MultilayerPerceptron mlp = new MultilayerPerceptron();

	public static void Start(String Path1, String Path2) {

		double Samples[][] = readFile.readFiles(Path1, MultiplayerPerceptronConfig.NUMBER_SAMPLES,
				MultiplayerPerceptronConfig.NUMBER_INPUT);
		double Result[][] = readFile.readFiles(Path2, MultiplayerPerceptronConfig.NUMBER_SAMPLES,
				MultiplayerPerceptronConfig.NUMBER_OUTPUT);

		mlp.trainer(Samples, Result);
	}

	public static void InputToPrint(double[] value) {

		double[] result = mlp.execution(value);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}

	public static void InputToPrint(double[][] value) {

		for (int i = 0; i < value.length; i++) {
			double[] result = mlp.execution(value[i]);

			for (int j = 0; j < result.length; j++) {
				System.out.print(result[j] + " ");
			}
			System.out.println();
		}

	}

	
	
}

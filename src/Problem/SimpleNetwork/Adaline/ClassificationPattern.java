package Problem.SimpleNetwork.Adaline;

import Config.AdalineConfig;
import Network.SimpleNetwork.MainAdaline;

public class ClassificationPattern {

	public static void main(String[] args) {

		AdalineConfig.NUMBER_SAMPLES = 35;
		AdalineConfig.NUMBER_INPUT = 4;

		String Path1 = ClassificationPattern.class.getResource("../../../Samples/SimpleNetwork/projeto2.txt").getPath();
		String Path2 = ClassificationPattern.class.getResource("../../../Samples/SimpleNetwork/projeto2Results.txt")
				.getPath();

		double value1[] = { 0.4329, -1.3719, 0.7022, -0.8535 };
		double value2[] = { 0.3024, 0.2286, 0.8630, 2.7909 };
		double value3[] = { 0.1349, -0.6445, 1.0530, 0.5687 };
		double value4[] = { 1.1434, -0.0485, 0.6637, 1.2606 };

		MainAdaline.Start(Path1, Path2);
		MainAdaline.InputToPrint(value1);
		MainAdaline.InputToPrint(value2);
		MainAdaline.InputToPrint(value3);
		MainAdaline.InputToPrint(value4);

	}

}

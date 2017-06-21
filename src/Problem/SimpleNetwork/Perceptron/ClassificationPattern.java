package Problem.SimpleNetwork.Perceptron;

import Config.PerceptronConfig;
import Network.SimpleNetwork.MainPerceptron;

public class ClassificationPattern {

	public static void main(String[] args) {

		PerceptronConfig.NUMBER_SAMPLES = 30;
		PerceptronConfig.NUMBER_INPUT = 3;

		String Path1 = ClassificationPattern.class.getResource("../../../Samples/SimpleNetwork/projeto1.txt").getPath();
		String Path2 = ClassificationPattern.class.getResource("../../../Samples/SimpleNetwork/projeto1Results.txt")
				.getPath();

		double value1[] = { -0.6508, 0.1097, 4.0009 };
		double value2[] = { -1.4492, 0.8896, 4.4005 };
		double value3[] = { 2.0850,	0.6876,	12.0710 };
		
		MainPerceptron.Start(Path1, Path2);
		MainPerceptron.Input(value1);
		MainPerceptron.Input(value2);
		MainPerceptron.Input(value3);

	}
}

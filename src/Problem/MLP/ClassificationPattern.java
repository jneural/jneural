package Problem.MLP;

import Config.MultiplayerPerceptronConfig;
import Network.MLP.*;

public class ClassificationPattern {

	public static void main(String[] args) {

		MultiplayerPerceptronConfig.NUMBER_SAMPLES = 130;
		MultiplayerPerceptronConfig.NUMBER_INPUT = 4;
		MultiplayerPerceptronConfig.NUMBER_OUTPUT = 3;
		MultiplayerPerceptronConfig.ERROR = 0.05;

		String Path1 = ClassificationPattern.class.getResource("../../Samples/MLP/projeto2.txt").getPath();
		String Path2 = ClassificationPattern.class.getResource("../../Samples/MLP/projeto2Results.txt").getPath();
	
		double value1[] = {0.1765,  0.1613,  0.3401,  0.0843};
		double value2[] = {0.3170,  0.5786,  0.3387,  0.4192};
		double value3[] = {0.7030,  0.7784,  0.7482,  0.6562};

		MainMultiLayerPerceptron.Start(Path1, Path2);
		MainMultiLayerPerceptron.InputToPrint(value1);
		MainMultiLayerPerceptron.InputToPrint(value2);
		MainMultiLayerPerceptron.InputToPrint(value3);

	}

}

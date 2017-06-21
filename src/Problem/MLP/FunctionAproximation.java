package Problem.MLP;

import Config.MultiplayerPerceptronConfig;
import Network.MLP.*;

public class FunctionAproximation {

	public static void main(String[] args) {

		MultiplayerPerceptronConfig.NUMBER_SAMPLES = 195;
		MultiplayerPerceptronConfig.NUMBER_INPUT = 3;
		MultiplayerPerceptronConfig.NUMBER_OUTPUT = 1;
		MultiplayerPerceptronConfig.ERROR = 0.0001;
		//MultiplayerPerceptronConfig.PRINTERROR = true;

		String Path1 = FunctionAproximation.class.getResource("../../Samples/MLP/projeto1.txt").getPath();
		String Path2 = FunctionAproximation.class.getResource("../../Samples/MLP/projeto1Results.txt").getPath();
		
		
		double value1[] = {0.8799,  0.7998,  0.3972};
		double value2[] = {0.5700,  0.5111,  0.2418};
		double value3[] = {0.6796,  0.4117,  0.3370};
		double value4[] = {0.3567,  0.2967,  0.6037};
		double value5[] = {0.3866,  0.8390,  0.0232};
		
		MainMultiLayerPerceptron.Start(Path1, Path2);
		MainMultiLayerPerceptron.InputToPrint(value1);
		MainMultiLayerPerceptron.InputToPrint(value2);
		MainMultiLayerPerceptron.InputToPrint(value3);
		MainMultiLayerPerceptron.InputToPrint(value4);
		MainMultiLayerPerceptron.InputToPrint(value5);

		
	}

}

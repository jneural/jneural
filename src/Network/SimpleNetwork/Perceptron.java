package Network.SimpleNetwork;

import Config.MultiplayerPerceptronConfig;
import Config.PerceptronConfig;
import Network.NeuralSupervised;
import Structure.Layer;
import util.Equation;

public class Perceptron implements NeuralSupervised {

	Layer layer;

	public Perceptron() {
//		layer = new Layer(PerceptronConfig.NUMBER_NEURONE, PerceptronConfig.NUMBER_INPUT + 1, PerceptronConfig.FUNCTION,
//				new HebbAdjust());
	}

	@Override
	public void trainer(double[][] samples, double[][] result) {

		double[][] resultNetwork = new double[PerceptronConfig.NUMBER_SAMPLES][PerceptronConfig.NUMBER_OUTPUT];

		do {

			for (int a = 0; a < samples.length; a++) {
				resultNetwork[a] = layer.output(samples[a],true);
				PerceptronAdjust(result[a], resultNetwork[a], samples[a]);
			}

		} while (Equation.eqm(resultNetwork, result, PerceptronConfig.NUMBER_SAMPLES) >= PerceptronConfig.ERROR);

	}

	@Override
	public double[] execution(double[] value) {
		double result[] = layer.output(value,true);

		return result;
	}

	void PerceptronAdjust(double result[], double out[], double sample[]) {

		double[] error = new double[MultiplayerPerceptronConfig.NUMBER_OUTPUT];

		for (int i = 0; i < PerceptronConfig.NUMBER_OUTPUT; i++) {
			error[i] = (result[i] - out[i]);
		}

		layer.adjustLayer(error, sample);

	}

}

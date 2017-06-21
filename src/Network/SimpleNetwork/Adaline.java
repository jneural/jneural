package Network.SimpleNetwork;

import AdjustFunction.DeltaAdjust;
import Config.AdalineConfig;
import Config.MultiplayerPerceptronConfig;
import Network.NeuralSupervised;
import Structure.Layer;
import util.Equation;

public class Adaline implements NeuralSupervised {

	Layer layer;

	public Adaline() {

		layer = new Layer(AdalineConfig.NUMBER_NEURONE, AdalineConfig.NUMBER_INPUT + 1, AdalineConfig.FUNCTION,
				new DeltaAdjust());

	}

	@Override
	public void trainer(double[][] samples, double[][] result) {

		double[][] resultNetwork = new double[AdalineConfig.NUMBER_SAMPLES][AdalineConfig.NUMBER_OUTPUT];

		do {

			for (int a = 0; a < samples.length; a++) {
				resultNetwork[a] = layer.output(samples[a],true);
				AdalineAdjust(result[a], resultNetwork[a], samples[a]);
			}

		} while (Equation.eqm(resultNetwork, result, AdalineConfig.NUMBER_SAMPLES) >= AdalineConfig.ERROR);

	}

	@Override
	public double[] execution(double[] value) {

		double result[] = layer.output(value,true);

		return result;
	}

	void AdalineAdjust(double result[], double out[], double sample[]) {

		double[] error = new double[MultiplayerPerceptronConfig.NUMBER_OUTPUT];

		for (int i = 0; i < AdalineConfig.NUMBER_OUTPUT; i++) {
			error[i] = (result[i] - out[i]);
		}

		layer.adjustLayer(error, sample);

	}

}

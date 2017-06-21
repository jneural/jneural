package Network.MLP;

import AdjustFunction.DeltaAdjust;
import Config.MultiplayerPerceptronConfig;
import Network.NeuralSupervised;
import Structure.Layer;
import util.Equation;

public class MultilayerPerceptron implements NeuralSupervised {

	Layer[] hiddenLayer;
	Layer outputlayer;
	double resultLayers[][];

	MultilayerPerceptron() {

		hiddenLayer = new Layer[MultiplayerPerceptronConfig.NUMBER_LAYER];

		for (int i = 0; i < hiddenLayer.length; i++) {
			if (i == 0) {
				hiddenLayer[i] = new Layer(MultiplayerPerceptronConfig.NUMBER_NEURONE,
						MultiplayerPerceptronConfig.NUMBER_INPUT + 1, MultiplayerPerceptronConfig.FUNCTIONHID,
						new DeltaAdjust());
			} else {

				hiddenLayer[i] = new Layer(MultiplayerPerceptronConfig.NUMBER_NEURONE,
						MultiplayerPerceptronConfig.NUMBER_WEIGHT + 1, MultiplayerPerceptronConfig.FUNCTIONHID,
						new DeltaAdjust());

			}
		}

		outputlayer = new Layer(MultiplayerPerceptronConfig.NUMBER_OUTPUT,
				MultiplayerPerceptronConfig.NUMBER_WEIGHT + 1, MultiplayerPerceptronConfig.FUNCTIONOUT,
				new DeltaAdjust());

	}

	@Override
	public void trainer(double samples[][], double result[][]) {

		resultLayers = new double[MultiplayerPerceptronConfig.NUMBER_LAYER][MultiplayerPerceptronConfig.NUMBER_WEIGHT];
		double[][] resultNetwork = new double[MultiplayerPerceptronConfig.NUMBER_SAMPLES][MultiplayerPerceptronConfig.NUMBER_OUTPUT];

		do {
			for (int a = 0; a < samples.length; a++) {
				double out[] = middleLayer(samples[a]);
				out = outputlayer.output(out, true);
				backPropagation(result[a], samples[a], out);
				out = middleLayer(samples[a]);
				out = outputlayer.output(out, true);
				resultNetwork[a] = out;
			}

			if (MultiplayerPerceptronConfig.PRINTERROR) {
				System.out.println("Error: "
						+ Equation.eqm(resultNetwork, result, MultiplayerPerceptronConfig.NUMBER_SAMPLES) + "\n");
			}
			
		} while (Equation.eqm(resultNetwork, result,
				MultiplayerPerceptronConfig.NUMBER_SAMPLES) >= MultiplayerPerceptronConfig.ERROR);

	}

	@Override
	public double[] execution(double value[]) {

		double result[] = middleLayer(value);
		result = outputlayer.output(result, true);

		return result;

	}

	private double[] middleLayer(double[] samples) {

		double out[] = samples;

		for (int i = 0; i < hiddenLayer.length; i++) {
			out = hiddenLayer[i].output(out, true);
			for (int j = 0; j < out.length; j++) {
				resultLayers[i][j] = out[j];
			}
		}
		return out;
	}

	private void backPropagation(double[] result, double[] samples, double[] out) {

		double[] errorOut = new double[MultiplayerPerceptronConfig.NUMBER_OUTPUT];
		double[][] errorHidden = new double[MultiplayerPerceptronConfig.NUMBER_LAYER][MultiplayerPerceptronConfig.NUMBER_NEURONE];
		double sum;

		for (int i = 0; i < MultiplayerPerceptronConfig.NUMBER_OUTPUT; i++) {
			errorOut[i] = (result[i] - out[i]) * (out[i] * (1 - out[i]));
		}

		outputlayer.adjustLayer(errorOut, resultLayers[MultiplayerPerceptronConfig.NUMBER_LAYER - 1]);

		for (int i = MultiplayerPerceptronConfig.NUMBER_LAYER - 1; i >= 0; i--) {

			for (int j = 0; j < MultiplayerPerceptronConfig.NUMBER_NEURONE; j++) {

				if (i == MultiplayerPerceptronConfig.NUMBER_LAYER - 1) {
					sum = outputlayer.sumWeightOut(errorOut, j);
				} else {
					sum = outputlayer.sumWeightOut(errorHidden[i], j);
				}

				errorHidden[i][j] = sum * resultLayers[i][j] * (1 - (resultLayers[i][j]));
			}

			if (i != 0) {
				hiddenLayer[i].adjustLayer(errorHidden[i], resultLayers[i]);
			} else {
				hiddenLayer[i].adjustLayer(errorHidden[i], samples);
			}
		}

	}

}

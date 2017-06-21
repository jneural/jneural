package Network.Kohonen;

import java.util.ArrayList;

import AdjustFunction.CompetitiveAdjust;
import Config.CompetitiveConfig;
import Network.NeuralNSupervised;
import Structure.Layer;
import Structure.Neurone;
import util.Equation;

public class Kohonen implements NeuralNSupervised {

	Layer layer;
	Layer auxLayer;
	ArrayList<Neurone>[] neighborhood;

	public Kohonen() {
		layer = new Layer(CompetitiveConfig.NUMBER_GROUPS, CompetitiveConfig.NUMBER_INPUT, CompetitiveConfig.FUNCTION,
				new CompetitiveAdjust());

		auxLayer = new Layer(CompetitiveConfig.NUMBER_GROUPS, CompetitiveConfig.NUMBER_INPUT,
				CompetitiveConfig.FUNCTION, new CompetitiveAdjust());
	}

	@Override
	public void trainer(double[][] samples) {

		int lowerNeurone = 0;

		do {
			auxLayer.copy(layer);

			for (int i = 0; i < CompetitiveConfig.NUMBER_SAMPLES; i++) {

				lowerNeurone = Equation.EuclidianeDistance(samples[i], layer);
				layer.adjust.adjust(samples, lowerNeurone, i, layer.getNeurone());

			}			
			
		} while (layer.compare(auxLayer));

	}

	@Override
	public double[] execution(double[] value) {
		// TODO Auto-generated method stub
		return null;
	}

}

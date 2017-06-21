package Network.Kohonen;

import AdjustFunction.CompetitiveAdjust;
import Config.CompetitiveConfig;
import Network.NeuralNSupervised;
import Structure.Layer;
import util.Equation;

public class Competitive implements NeuralNSupervised {

	Layer layer;
	Layer auxLayer;

	public Competitive() {
		layer = new Layer(CompetitiveConfig.NUMBER_GROUPS, CompetitiveConfig.NUMBER_INPUT, CompetitiveConfig.FUNCTION,
				new CompetitiveAdjust());

		auxLayer = new Layer(CompetitiveConfig.NUMBER_GROUPS, CompetitiveConfig.NUMBER_INPUT,
				CompetitiveConfig.FUNCTION, new CompetitiveAdjust());

//		for (int i = 0; i < CompetitiveConfig.NUMBER_GROUPS; i++) {
//			for (int j = 0; j < CompetitiveConfig.NUMBER_INPUT; j++) {
//				layer.addValue(value[i][j], i, j);
//			}
//		}

	}

	@Override
	public void trainer(double[][] samples) {

		int lowerNeurone = 0;

		do {
			auxLayer.copy(layer);

			for (int i = 0; i < CompetitiveConfig.NUMBER_SAMPLES; i++) {

				lowerNeurone = Equation.EuclidianeDistance(samples[i], layer);
				layer.adjust.adjust(samples, lowerNeurone, i, layer.getNeurone());
			//	System.out.println(menor+" "+i);

			}			
			
		} while (layer.compare(auxLayer));

	}

	@Override
	public double[] execution(double[] value) {
		
		double[] menor = new double[1];

		menor[0] = Equation.EuclidianeDistance(value, layer);

		return menor;
	}

}

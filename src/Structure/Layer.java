package Structure;

import java.text.DecimalFormat;
import java.util.ArrayList;
import ActivationFuction.Activation;
import AdjustFunction.Adjust;

public class Layer {

	ArrayList<Neurone> neurone;
	public Adjust adjust;

	public Layer(int numberNeurone, int numberInput, Activation function, Adjust funAdj) {

		neurone = new ArrayList<Neurone>();
		adjust = funAdj;

		for (int i = 0; i < numberNeurone; i++) {
			neurone.add(new Neurone(numberInput, function));
		}

	}

	public void addValueForWeight(double value, int posNeurone, int posWeight) {
		neurone.get(posNeurone).ChangeWeight(value, posWeight);
	}

	public double[] output(double[] value,boolean limiar) {

		double result[] = new double[neurone.size()];

		for (int i = 0; i < neurone.size(); i++) {
			result[i] = neurone.get(i).output(value,limiar);
		}

		return result;
	}

	public void adjustLayer(double[] error, double[] out) {

		adjust.adjust(error, out, neurone);

	}

	public double sumWeightOut(double[] out, int weight) {

		double sum = 0;

		for (int i = 0; i < neurone.size(); i++) {
			sum = neurone.get(i).weight.get(weight) * out[i];
		}

		return sum;
	}

	public void copy(Layer layer) {

		for (int i = 0; i < neurone.size(); i++) {
			for (int j = 0; j < neurone.get(0).weight.size(); j++) {
				neurone.get(i).ChangeWeight(layer.neurone.get(i).weight.get(j), j);
			}
		}

	}

	public boolean compare(Layer auxLayer) {

		boolean retorno = false;
		String teste1, teste2;
		DecimalFormat fmt = new DecimalFormat("0.00");

		for (int i = 0; i < neurone.size(); i++) {
			for (int j = 0; j < neurone.get(0).weight.size(); j++) {

				teste1 = fmt.format(auxLayer.neurone.get(i).weight.get(j));
				teste2 = fmt.format(neurone.get(i).weight.get(j));

				if (!teste1.equals(teste2)) {
					retorno = true;
					break;
				}

			}
		}
		return retorno;
	}

	public ArrayList<Neurone> getNeurone() {
		return neurone;
	}

}

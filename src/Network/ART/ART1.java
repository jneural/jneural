package Network.ART;

import java.util.ArrayList;

import ActivationFuction.Linear;
import Config.ARTConfig;
import Network.NeuralReforce;
import Structure.Layer;
import Structure.Neurone;

public class ART1 implements NeuralReforce {

	Layer layer;
	Layer outputlayer;
	ArrayList<Integer> desability;

	public ART1() {

		layer = new Layer(ARTConfig.NUMBER_INPUT, 1, new Linear(), null);
		outputlayer = new Layer(1, ARTConfig.NUMBER_INPUT, new Linear(), null);

		for (int i = 0; i < layer.getNeurone().size(); i++) {
			for (int j = 0; j < layer.getNeurone().get(0).weight.size(); j++) {
				layer.addValueForWeight(1, i, j);
			}
		}

		for (int i = 0; i < outputlayer.getNeurone().size(); i++) {
			for (int j = 0; j < outputlayer.getNeurone().get(0).weight.size(); j++) {
				outputlayer.addValueForWeight(1.0 / (1 + ARTConfig.NUMBER_INPUT), i, j);
			}
		}

	}

	public double operation(double[] sample) {

		desability = new ArrayList<Integer>();
		String vencedor = "";
		double classe = 0;

		do {
			int winner = winner(sample);
			double r = similarity(winner, sample);

			if (r > ARTConfig.MONITORING) {
				adjustWeight(winner, sample);
				vencedor = "aprovado";
				classe = winner;
			}

			if (r <= ARTConfig.MONITORING) {
				desability.add(winner);
				vencedor = "reprovado";
			}

			if (r <= ARTConfig.MONITORING && (outputlayer.getNeurone().size() == desability.size())) {

				int posicao = outputlayer.getNeurone().size();
				Neurone novo = new Neurone(ARTConfig.NUMBER_INPUT, new Linear());

				for (int i = 0; i < novo.weight.size(); i++) {
					novo.ChangeWeight(1.0 / (1 + ARTConfig.NUMBER_INPUT), i);
				}

				outputlayer.getNeurone().add(novo);
				adjustWeight(posicao, sample);
				classe = posicao;
				vencedor = "aprovado";
			}

		} while (vencedor != "aprovado");
		
		return classe;

	}

	private void adjustWeight(int winner, double[] sample) {

		double conc = 0;

		for (int i = 0; i < layer.getNeurone().size(); i++) {
			
			double valor_antigo = layer.getNeurone().get(i).getWeight(winner);
			layer.getNeurone().get(i).ChangeWeight(valor_antigo * sample[i], winner);
			conc += valor_antigo * sample[i];

		}

		for (int i = 0; i < layer.getNeurone().size(); i++) {

			outputlayer.getNeurone().get(winner)
					.ChangeWeight(layer.getNeurone().get(i).getWeight(winner) / (conc + 1.0 / 2), i);
			layer.getNeurone().get(i).weight.add(1.00);
		}

	}

	public int winner(double sample[]) {

		double result[] = outputlayer.output(sample, false);
		double maior = 0;
		int index = 0;

		for (int i = 0; i < result.length; i++) {
			if (result[i] > maior && !desability.contains(i)) {
				index = i;
				maior = result[i];
			}
		}

		return index;

	}

	public double similarity(int k, double sample[]) {

		double r = 0;
		double sum = 0;

		for (int i = 0; i < layer.getNeurone().size(); i++) {

			r += (double) layer.getNeurone().get(i).getWeight(k) * sample[i];
			sum += sample[i];
		}

		r = r / sum;

		return r;
	}

}

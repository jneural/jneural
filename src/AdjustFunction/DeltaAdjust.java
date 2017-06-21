package AdjustFunction;

import java.util.ArrayList;

import Structure.Neurone;

public class DeltaAdjust implements Adjust {

	
	@Override
	public void adjust(double[] error, double[] out,ArrayList<Neurone> neurone) {

		for (int i = 0; i < neurone.size(); i++) {
			for (int j = 0; j < neurone.get(0).weight.size(); j++) {
				if (j == 0) {
					//neurone[i].ChangeWeight(neurone[i].weight[j] + (0.1 * error[i] * (-1)), j);
					neurone.get(i).ChangeWeight(neurone.get(i).weight.get(j) + (0.1 * error[i] * (-1)), j);
				} else {
					//neurone[i].ChangeWeight(neurone[i].weight[j] + (0.1 * error[i] * (out[j - 1])), j);
					neurone.get(i).ChangeWeight(neurone.get(i).weight.get(j) + (0.1 * error[i] * (out[j - 1])), j);
				}
			}
		}
	}

	@Override
	public void adjust(double[][] val, int lassVal, int i, ArrayList<Neurone> neurone) {}


}

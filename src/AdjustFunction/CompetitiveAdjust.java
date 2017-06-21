package AdjustFunction;

import java.util.ArrayList;

import Structure.Neurone;

public class CompetitiveAdjust implements Adjust {

	@Override
	public void adjust(double[][] val, int lassVal, int i, ArrayList<Neurone> neurone) {

		for (int j = 0; j < neurone.get(0).weight.size(); j++) {
			// neurone[lassVal].ChangeWeight(neurone[lassVal].weight[j] +
			// 0.001*(val[i][j] - neurone[lassVal].weight[j]), j);
			neurone.get(lassVal).ChangeWeight(
					neurone.get(lassVal).weight.get(j) + 0.001 * (val[i][j] - neurone.get(lassVal).weight.get(j)), j);
		}
	}

	@Override
	public void adjust(double[] error, double[] out, ArrayList<Neurone> neurone) {
	}

}

package util;

import java.util.ArrayList;

import Structure.Layer;
import Structure.Neurone;

public class Equation {

	public static double eqm(double resultNetwork[][], double result[][], int nSamples) {

		double error = 0;

		for (int i = 0; i < nSamples; i++) {

			double e = 0;

			for (int j = 0; j < result[0].length; j++) {
				e += (Math.pow((result[i][j] - resultNetwork[i][j]), 2));
			}
			error = error + e / 2;
		}

		error = (error / nSamples);

		return error;

	}

	public static int EuclidianeDistance(double[] val, Layer layer) {

		ArrayList<Neurone> layerVec = layer.getNeurone();
		double[] dist_euc = new double[layerVec.size()];
		int menor = 0;

		for (int i = 0; i < layerVec.size(); i++) {

			for (int j = 0; j < layerVec.size(); j++) {
				dist_euc[i] = dist_euc[i] + Math.pow(val[j] - layerVec.get(i).getWeight(j), 2);
			}

			dist_euc[i] = Math.sqrt(dist_euc[i]);
		}

		for (int i = 0; i < layerVec.size(); i++) {

			if (dist_euc[menor] > dist_euc[i]) {

				menor = i;

			}
		}

		return menor;
	}
	
}

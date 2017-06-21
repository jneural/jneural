package Structure;

import java.util.ArrayList;
import java.util.Random;

import ActivationFuction.Activation;

public class Neurone {

	public ArrayList<Double> weight;
	private Activation Afunction;

	public Neurone(int numberWeight, Activation function) {

		this.weight = new ArrayList<Double>();
		Random Gerador = new Random();

		for (int i = 0; i < numberWeight; i++) {
			weight.add(Gerador.nextDouble());
		}

		Afunction = function;

	}

	double output(double value[], boolean limiar) {

		double result = 0;

		if (limiar == true) {

			result = weight.get(0) * (-1);

			for (int i = 0; i < value.length; i++) {
				result += weight.get(i+1) * value[i];
			}

		}else{
			
			for (int i = 0; i < value.length; i++) {
				result += weight.get(i) * value[i];
			}		
		}
		return Afunction.result(result);
	}

	public void ChangeWeight(double value, int positionWeight) {
		weight.set(positionWeight, value);
	}

	public double getWeight(int i) {
		return weight.get(i);
	}

}

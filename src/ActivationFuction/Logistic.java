package ActivationFuction;

public class Logistic implements Activation{

	@Override
	public double result(double value) {		
		return 1 / (1 + Math.exp(-1 * value));		
	}

}

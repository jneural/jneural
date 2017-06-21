package ActivationFuction;

public class HeavySide implements Activation {

	@Override
	public double result(double value) {

		if (value >= 0) {
			return 1;
		} else {
			return 0;
		}

	}

}

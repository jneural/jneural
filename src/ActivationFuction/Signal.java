package ActivationFuction;

public class Signal implements Activation {

	@Override
	public double result(double value) {

		if (value > 0) {
			return 1;
		} else if (value == 0) {
			return 0;
		} else {
			return -1;
		}

	}

}

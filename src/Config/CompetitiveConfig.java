package Config;

import ActivationFuction.Activation;
import ActivationFuction.Logistic;

public class CompetitiveConfig {

	public static int NUMBER_SAMPLES = 200;
	public static int  NUMBER_INPUT= 10;
	public static int  NUMBER_GROUPS = 3;
	
	public static final Activation FUNCTION = new Logistic();
	
	
}

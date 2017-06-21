package Config;

import ActivationFuction.Activation;
import ActivationFuction.Signal;

public class AdalineConfig {
	
	public static int NUMBER_SAMPLES = 100;
	public static int  NUMBER_INPUT= 3;
	public static int  NUMBER_LAYER = 1;
	public static int  NUMBER_NEURONE = 1;
	public static int  NUMBER_WEIGHT = NUMBER_INPUT;
	public static int  NUMBER_OUTPUT = 1;
	public static double  ERROR = 0.00001;
	
	public static Activation FUNCTION = new Signal();
	

}

package Config;

import ActivationFuction.Activation;
import ActivationFuction.Logistic;

public class MultiplayerPerceptronConfig {
	
	public static int NUMBER_SAMPLES = 200;
	public static int  NUMBER_INPUT= 3;
	public static int  NUMBER_LAYER = 1;
	public static int  NUMBER_NEURONE = 10;
	public static int  NUMBER_WEIGHT = NUMBER_NEURONE;
	public static int  NUMBER_OUTPUT = 1;
	public static double  ERROR = 0.00001;
	public static Boolean PRINTERROR = false;
	
	public static Activation FUNCTIONHID = new Logistic();
	public static Activation FUNCTIONOUT = new Logistic();
	
	

}

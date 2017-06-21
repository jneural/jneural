package AdjustFunction;

import java.util.ArrayList;

import Structure.Neurone;

public interface Adjust {
	
	void adjust(double[] error, double[] out, ArrayList<Neurone> neurone);

	void adjust(double[][] val, int lassVal, int i, ArrayList<Neurone> neurone);

}

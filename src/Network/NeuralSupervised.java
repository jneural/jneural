package Network;

public interface NeuralSupervised {
	
	void trainer(double[][] samples, double[][] result);
	double[] execution(double[] value);

}

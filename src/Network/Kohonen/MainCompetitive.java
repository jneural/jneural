package Network.Kohonen;

import Config.CompetitiveConfig;
import util.readFile;

public class MainCompetitive {

	static Competitive comp;

	public static void Start(String Path1) {

		double samples[][] = readFile.readFiles(Path1, CompetitiveConfig.NUMBER_SAMPLES,
				CompetitiveConfig.NUMBER_INPUT);

		comp = new Competitive();
		comp.trainer(samples);

	}

	public static void InputToPrint(double[] value) {

		double output[] = comp.execution(value);

		System.out.println(output[0]);

	}

}

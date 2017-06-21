package Problem.Kohonen;

import Config.CompetitiveConfig;
import Network.Kohonen.MainCompetitive;

public class ClassificationPattern {

	public static void main(String[] args) {

		CompetitiveConfig.NUMBER_SAMPLES = 120;
		CompetitiveConfig.NUMBER_INPUT = 3;
		CompetitiveConfig.NUMBER_GROUPS = 3;

		String Path1 = ClassificationPattern.class.getResource("../../Samples/Kohonen/projeto1.txt").getPath();

		double value1[] = { 0.2417, 0.2857, 0.2397 };
		double value2[] = { 0.7352,	0.2722,	0.6962 };
		double value3[] = { 0.5805,	0.7349,	0.4464 };

		MainCompetitive.Start(Path1);
		MainCompetitive.InputToPrint(value1);
		MainCompetitive.InputToPrint(value2);
		MainCompetitive.InputToPrint(value3);

	}
}

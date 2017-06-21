package Network.ART;

import Config.ARTConfig;
import util.readFile;

public class MainART1 {

	static ART1 art;

	public static void StartToPrint(String Path1) {

		double samples[][] = readFile.readFiles(Path1, ARTConfig.NUMBER_SAMPLES,
				ARTConfig.NUMBER_INPUT);

		art = new ART1();
		
		for (int i = 0; i < samples.length; i++) {
			System.out.println(art.operation(samples[i]));
		}
		
		
	}


}

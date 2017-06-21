package Problem.ART;

import Network.ART.MainART1;

public class ClassificationPattern {
	
	public static void main(String[] args) {
	
	String Path1 = ClassificationPattern.class.getResource("../../Samples/ART/projeto1.txt").getPath();
	
	MainART1.StartToPrint(Path1);
	
	}

}

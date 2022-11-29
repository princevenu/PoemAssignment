
public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("\tPoem Word Analysis");

        InputFile inputFile = new InputFile();              //Initializing InputFile.java as an object
        System.out.println("\tOpening input file...");

        inputFile.FileRead();                           //invoking Fileread method to read the input file from inputfile object
        Analysis analysis = new Analysis();             //Initializing Analyse.java as an object
        analysis.Analyse(inputFile.getListOfWords());    //invoking analyse method to analyse the inputfile object
        analysis.printOut();                            //prints the output from analysis class 

        System.out.println("\tEnd of results.");

    }
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputFile {
   public static ArrayList<String> listOfWords= new ArrayList<>();

    public static void FileRead() throws IOException {

        BufferedReader bufReader = new BufferedReader(new FileReader("inPoem.txt"));
        //using buffer to read the file

        String line = bufReader.readLine();  //open bufferreader to read the line

        while (line != null) {      //iterates till the end of the line.

            line = line.replace("\'", ""); //remove apestropies from the string
            line =line.replace("\"", "");  //remove double quotations from the string
            line.trim();
            while (line.charAt(line.length() - 1) == ',' || line.charAt(line.length() - 1) == '.' ||
                    line.charAt(line.length() - 1) == '?' || line.charAt(line.length() - 1) == '!') {
                line = line.substring(0, line.length() - 1);
            }                                                       // getting rid of end of sentence puntuations

            String strArray[] = line.split(" ");            //storing sentence in array of strings
            for (int i = 0; i < strArray.length; i++) {
                listOfWords.add(strArray[i].trim());
            }

            line = bufReader.readLine(); 
        }
        bufReader.close();   //close the buffer reader
    }

    public static void printfile(){              // method to print the contents of file word by word
        for (String s : listOfWords) {
            System.out.println(s);
        }
    }

    public ArrayList<String> getListOfWords() {  
        return this.listOfWords;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Analysis {

    public static class MyObject {

        String word;
        int count;
        boolean isPalindrome;

        /* created an object to store data in the required format */
    }

    public static List<MyObject> OutputList = new ArrayList<MyObject>();  //list of objects initialized globally

    public static void Analyse(ArrayList<String> listOfWords) {

        HashMap<String, Integer> hm = new HashMap<String, Integer>(); //used hashmap to get count of each word
        for (String s : listOfWords) {
            if (hm.containsKey(s)) {              //  if hashmap already contains the key the its value is increased by 1
                hm.put(s, hm.get(s) + 1);
            } else {
                hm.put(s, 1);              //else string is stored in the hashmap with default value 1
            }
        }

        Iterator<Map.Entry<String, Integer>> itr = hm.entrySet().iterator(); //initializing iterator to loop through hashmap

        while (itr.hasNext()) {                       //iterates until it reaches the last elemengt in the hashmap
            Map.Entry<String, Integer> entry = itr.next();

            MyObject temp = new MyObject();         //using a temporary object to store values  
            temp.count = entry.getValue();
            temp.word = entry.getKey();
            temp.isPalindrome = isPalindrome(entry.getKey());   //passing string to isPalindrome function
            OutputList.add(temp);                    // add my temporary object to list of objects
        }

    }

    public static boolean isPalindrome(String str) { // returns true if palindrome else false

        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;

        // While there are characters to compare
        while (i < j) {

            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }
        return true;
    }

    public void printOut() {                 // helper method to print the output
        SortMyObject();                        //sorts the list of objects bases on words
        System.out.print("Word \t");
            System.out.print( "count\t ");
            System.out.print( "isPalindrome\t  ");
            System.out.println("");                        //print the heading paramenters
        for (MyObject obj : OutputList) {
            System.out.print(obj.word + "\t\t");
            System.out.print(obj.count + "\t ");
            System.out.print(obj.isPalindrome + "\t ");
            System.out.println("");                            //printing the output parameters
        }
    }

    public static void SortMyObject() {

        for (int i = 0; i < OutputList.size() ; i++) {
            for (int j = i + 1; j < OutputList.size(); j++) {
                if (OutputList.get(i).word.compareToIgnoreCase(OutputList.get(j).word) > 0) {
                    MyObject temp = (MyObject)OutputList.get(i);
                    OutputList.set(i, OutputList.get(j));
                    OutputList.set(j,temp);
                }else{
                    if(!(OutputList.get(i).count>=OutputList.get(j).count)){
                        MyObject temp = (MyObject)OutputList.get(j);
                        OutputList.set(j, OutputList.get(i));
                        OutputList.set(i,temp);
                    }
                    
                }
            }
        }
        
    }
}

import java.util.List;
import java.util.ArrayList;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int total = 0;
        for (int num: L){
            total += num;
        }
        return total;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {

        List<Integer> evenlist = new ArrayList<>();
        for (int num: L){
            if (num%2==0){
                evenlist.add(num);
            }
        }
        return evenlist;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> commonlist = new ArrayList<>();
        for (int num: L1){
            if (L2.contains(num)){
                if (!commonlist.contains(num)) { // Avoid duplicates
                    commonlist.add(num);
                }
            }
        }
        return commonlist;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int count = 0;
        for (String word:words){
            if (word == null){
                continue;
            }
            else{
                for(int i=0;i<word.length();i++){
                    char currentChar = word.charAt(i);
                    if (currentChar == c){
                        count++;
                }
            }
        }
        return count;
    }
}

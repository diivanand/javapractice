package diiv.javapractice.util.miscellaneousquestions;

import java.util.*;

public class ComparatorPractice {


    public static void main(String[] args){
        Comparator<String> byLength = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                }else if (o1.length() < o2.length()) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        };

        String[] strings = new String[] {"zoo", "apple", "a", "bat", "bat", "battle", "z"};
        List<String> list = Arrays.asList(strings);
        list.sort(byLength);
        Arrays.sort(strings, byLength);

        for (String s : list)
        {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : strings)
        {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

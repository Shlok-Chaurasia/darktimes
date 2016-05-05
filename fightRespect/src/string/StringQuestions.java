package string;

import java.util.*;

/**
 * Created by shlok.chaurasia on 26/02/16.
 */
public class StringQuestions {
    HashMap<Integer, String> hashMap = new HashMap<>();

    private void printZigZag(int index, int maxN, String input) {
        if (index > maxN) {
            return;
        }
        int tempIndex = index;
        String outputString = "";
        while (tempIndex < input.length()) {
            outputString += input.charAt(tempIndex);
            tempIndex += maxN - index + 1;
        }
        hashMap.put(index, outputString);
        printZigZag(index + 1, maxN, input);
    }

    public void printReverse(int index, String input) {
        if (index == input.length())
            return;
        printReverse(index + 1, input);
        System.out.print(input.charAt(index));
    }

    public void printPermutations(int index, String oldString, String newString) {
        if (index == oldString.length()) {
            System.out.println(newString);

            return;
        }

        for (int i = 0; i < oldString.length(); i++) {
            String newString2 = newString + oldString.charAt(i);
            if (!newString.contains(oldString.charAt(i) + ""))
                printPermutations(index + 1, oldString, newString2);
        }
    }

    public void reverseWords(String input) {
        Stack<String> stack = new Stack<>();
        String word = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                if (word.length() > 0)
                    stack.push(word);
                stack.push(" ");
                word = "";
            } else {
                word += input.charAt(i);
            }

        }
        if (word.length() > 0)
            stack.push(word);
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }

    public void firstNonRepeating(String input) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (hashMap.containsKey(input.charAt(i)))
                hashMap.put(input.charAt(i), hashMap.get(input.charAt(i)) + 1);
            else
                hashMap.put(input.charAt(i), 1);
        }
    }

    public void printEncoding(String input) {
        if (input.length() > 0) {
            int currCount = 0;
            Character currChar = input.charAt(0);
            for (int i = 0; i < input.length(); i++) {
                if (currChar != input.charAt(i)) {
                    System.out.print(currChar.toString() + currCount);
                    currChar = input.charAt(i);
                    currCount = 1;
                } else {
                    currCount++;
                }
            }
            if (currCount > 0) {
                System.out.print(currChar.toString() + currCount);
            }

        }
    }

    public void printIDSeq(String input) {
        int[] output = new int[input.length() + 1];
        if (input.charAt(0) == 'I') {
            output[0] = 1;
            output[1] = 2;
        }
        if (input.charAt(0) == 'D') {
            output[0] = 2;
            output[1] = 1;
        }

        int lastIncreaseIndex = 0;
        int max=2;
        for(int i = 1; i<input.length();i++)
        {
            if(input.charAt(i) == 'I')
            {
                output[i+1] = max+1;
                lastIncreaseIndex =i+1;
                max = max+1;
                continue;
            }
            if(input.charAt(i) == 'D')
            {
                output[lastIncreaseIndex] = max+1;
                max=max+1;
                for(int j=lastIncreaseIndex+1;j<=i; j++){
                    output[j] = output[j] + 1;

                }
                output[i+1] = output[i]-1;

            }
        }
        for(int aa:output)
            System.out.print(aa);
    }

    public String isPanagram(String input)
    {        Set<Character> charactersA = new HashSet<>();
        input = input.toUpperCase();

        Boolean [] alphabets = new Boolean[26];
        for(Character character: input.toCharArray())
        {
            if(character!= ' ')
                alphabets[((int) character)-65] = true;
        }

        for(Boolean isOccuring: alphabets)
        {
            if(isOccuring==null || !isOccuring)
                return "not pangram";
        }
        return "pangram";

    }

    private static boolean isSubstring(String a,String b)
    {

        Set<Character> charactersA = new HashSet<>();
        for(Character character: a.toCharArray())
        {
            charactersA.add(character);
        }

        Set<Character> charactersB = new HashSet<>();
        for(Character character: b.toCharArray())
        {
            charactersB.add(character);
        }

        Set<Character> intersection = new HashSet<>(charactersA);
        intersection.retainAll(charactersB);
        return intersection.size()!=0;

    }

    public void subStringSearch(String pat, String text)
    {
        char[] patChar = pat.toCharArray();
        char[] textChar = text.toCharArray();
        HashMap<Character, Integer> countPat = new HashMap<>();
        HashMap<Character, Integer> countText = new HashMap<>();

        for(Character character: patChar)
        {
            if(!countPat.containsKey(character))
                countPat.put(character, 0);
            countPat.put(character, countPat.get(character)+1);
        }
        int index =0;
        while(index < pat.length())
        {
            char character = text.charAt(index);
            if(!countText.containsKey(character))
                countText.put(character, 0);
            countText.put(character, countText.get(character)+1);
            index++;
        }

        for(int i = pat.length(); i< text.length();i++)
        {
            if(compareHashMap(countText, countPat))
            {
                System.out.println("Found at index starting: "+ (i-pat.length()));
            }
            char characterAtStart = text.charAt(i-pat.length());
            if((countText.get(characterAtStart)-1) == 0)
                countText.remove(characterAtStart);
            else
                countText.put(characterAtStart, countText.get(characterAtStart)-1);
            if(!countText.containsKey(text.charAt(i)))
                countText.put(text.charAt(i), 0);
            countText.put(text.charAt(i), countText.get(text.charAt(i))+1);
        }

        if(compareHashMap(countText, countPat))
            System.out.println("Found at index starting: "+ (text.length()-pat.length()));
    }

    private boolean compareHashMap(HashMap<Character, Integer> largeCount, HashMap<Character, Integer> smallCount)
    {
        for(Character character: largeCount.keySet())
        {
            if(!smallCount.containsKey(character) && largeCount.get(character)!=0)
                return false;
            if(!largeCount.get(character).equals(smallCount.get(character)))
                return false;
        }

        return true;
    }
}

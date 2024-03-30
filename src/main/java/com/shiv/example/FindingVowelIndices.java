package com.shiv.example;

import java.util.*;
import java.util.stream.Collectors;

public class FindingVowelIndices{

    public static void main(String[] args) {
        String str ="Hello, World! This is an example string with vowels.";
        String str6=str.toLowerCase();
        char[] ch = str6.toCharArray();
        int count=1;
        HashMap<Character,Integer> hmap=new HashMap<>();
        for(int i=ch.length-1;i>=0;i--){
            if(hmap.containsKey(ch[i])){
                hmap.put(ch[i],hmap.get(ch[i])+1);
            }else {
                hmap.put(ch[i],1);
            }
        }

        str.replace(" ","");
        Map<String, Long> result = Arrays.stream(str.split("")).map(str1->str1.toLowerCase()).collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
        System.out.println(result);

        for(Map.Entry<Character,Integer> hm : hmap.entrySet()){
            System.out.println(hm.getKey()+" : "+hm.getValue());

        }



       String[] str1= str.split(" ");
        List<String> list = new ArrayList<>();
        for(int i=0;i<str1.length;i++){
            list.add(str1[i]);
        }
        System.out.println(list);
        Collections.reverse(list);
        String str3=list.toString();
        System.out.println(str3);




        for(int i=str.length()-1; i>=0; i--) {
            System.out.print(str.charAt(i));
        }
        for(int i=0; i<str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' ||
                    str.charAt(i) == 'i' || str.charAt(i) == 'o' ||
                    str.charAt(i) == 'u')

                System.out.println("\nGiven string contains " +
                        str.charAt(i) + " at the index " + i);
        }

        //a e i o u

        List<Character> strList = new ArrayList<>();
        strList.add('a');
        strList.add('e');
        strList.add('i');
        strList.add('o');
        strList.add('u');
        Map<String, Integer> map = new HashMap<>();

        List<Integer> intList = new ArrayList<>();
        intList.add(11);
        intList.add(52);
        intList.add(4);
        intList.add(89);
        intList.add(1);
Collections.sort(intList);
        System.out.println(intList);
        /*Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2)
                return 1;
                else return -1;
            }
        };
        Collections.sort(intList,com);
        System.out.println(intList);
*/

    }

    }


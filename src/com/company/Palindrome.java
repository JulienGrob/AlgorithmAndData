package com.company;

import java.util.LinkedList;

public class Palindrome {
    public boolean checkPalindrome(String str ){
        boolean isPalindrome=false;
        String[] splitEpression= str.split("");
        splitEpression=str.split("");
        LinkedList list=new LinkedList();
        for (int i=0;i<splitEpression.length;i++) {
            list.add(splitEpression[i]);
            //System.out.println(list.get(i));
        }
         if (list.size()%2==0){
             int i=0;
             while (i<((list.size())/2)+1 && list.get(i).equals(list.get(list.size()-i-1))){
                 i+=1;
             }
             if (i==(list.size()/2)+1){
                 isPalindrome=true;
             }

         }else{
             int j=0;
             while (j<((list.size())/2)+1 && list.get(j).equals(list.get(list.size()-j-1))){
                 j+=1;
             }
             if (j==(list.size()/2)+1){
                 isPalindrome=true;
             }
         }


    return isPalindrome;
    }
}

package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stook stk = new Stook();
       String[] tab= new String[4];
        //stk.Push(tab,13);
        //System.out.println(stk.IsEmpty(tab));
        String expression = "3"+"*"+"6"+"+"+"2";
        String expression1 = "("+"3"+"*"+"6"+"+"+"2"+")"+"+"+"("+"2"+"/"+"3"+"+"+"4"+")";
        String expression2 = "k"+"a"+"y"+"a"+"k"+"i";
        /*String[] splitEpression1= expression1.split("");
        for (int i=0; i<splitEpression1.length;i++){
            System.out.println(splitEpression1[i]);
        }*/
        //LinkedList str =new LinkedList();
        //str=expression2.split("");
        String[] convert = stk.converter(expression1);
       for (int i=0; i<convert.length;i++){
            System.out.println(convert[i]);
        }
        //System.out.println(stk.PopFiFo(convert));
        //stk.PopFiFo(stk.PopFiFo(convert));
        //stk.PopFiFo(convert);
        /*for (int i=0; i<convert.length;i++) {
            System.out.println(convert[i]);
        }*/
        //System.out.println(stk.findResult(convert));
Palindrome pld=new Palindrome();
//boolean response=pld.checkPalindrome(expression2);
        //System.out.println(response);
    }
}

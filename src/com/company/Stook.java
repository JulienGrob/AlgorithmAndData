package com.company;

import static java.lang.Float.parseFloat;

public class Stook {
    public String[] Push(String[] tab, String a) {
        int l = tab.length;
        int i = l - 1;
        if (this.IsEmpty(tab)) {
            tab[0] = a;
        } else {
            while (tab[i] == null) {
                //System.out.println(i);
                i -= 1;

            }
            if (i == l - 1) {
                System.out.println("Your array is full so nothing happend");
            } else {
                tab[i + 1] = a;
            }
        }
        return tab;
    }

    public float findResult(String[] tab) {// pas encore de prises en compte des parenthèses
        String[] result = new String[tab.length];
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].equals("+")) {
                float a = parseFloat(PopLiFo(result));
                float b = parseFloat(PopLiFo(result));
                this.Push(result, Float.toString(a + b));
            } else if (tab[i].equals("*")) {
                float a = parseFloat(PopLiFo(result));
                float b = parseFloat(PopLiFo(result));
                this.Push(result, Float.toString(a * b));
            } else if (tab[i].equals("/")) {
                float a = parseFloat(PopLiFo(result));
                float b = parseFloat(PopLiFo(result));
                this.Push(result, Float.toString(a / b));//Pas le bon résultat renvoyé au niveau des divisions
            } else {
                this.Push(result, tab[i]);
            }
        }

        return Float.parseFloat(PopLiFo(result));
    }

    public float findResultWithParentethese(String[] tab) {
        String[] result = new String[tab.length];
        int i = 0;
        while (i < tab.length) {
            if (tab[i].equals("+")) {
                float a = parseFloat(PopLiFo(result));
                float b = parseFloat(PopLiFo(result));
                this.Push(result, Float.toString(a + b));
                i += 1;
            } else if (tab[i].equals("*")) {
                float a = parseFloat(PopLiFo(result));
                float b = parseFloat(PopLiFo(result));
                this.Push(result, Float.toString(a * b));
                i += 1;
            } else if (tab[i].equals("/")) {
                float a = parseFloat(PopLiFo(result));
                float b = parseFloat(PopLiFo(result));
                this.Push(result, Float.toString(a / b));//Pas le bon résultat renvoyé au niveau des divisions
                i += 1;
            } else if (tab[i].equals("(")) {
                String[] resulttempo = new String[tab.length];
                i += 1;
                float resultTempo;
                while (tab[i].equals(")") == false) {
                    this.Push(resulttempo, tab[i]);
                }
                resultTempo = this.findResult(resulttempo);
                this.Push(result, Float.toString(resultTempo));
                i += 1;
            } else {
                this.Push(result, tab[i]);
            }

        }
        return Float.parseFloat(PopLiFo(result));
    }

    public String PopLiFo(String[] tab) { //Pop l'élément au dessus de la pile (le dernier push)
        int l = tab.length;
        int i = l - 1;
        String value = null;
        while (tab[i] == null) {
            i -= 1;
        }
        if (i == -1) {
            System.out.println("Your array is empty it is not possible to pop");
        } else {
            value = tab[i];
            tab[i] = null;
        }
        return value;
    }

    public String PopFiFo(String[] tab) {//Pop l'élément au dessous de la pile (le premier push)
        int l = tab.length;
        int i = 0;
        String value = null;
        if (this.IsEmpty(tab)) {
            System.out.println("Your array is empty it is not possible to pop");
        } else {
            value = tab[i];
            while (i != l - 1 || tab[i] == null) {
                tab[i] = tab[i + 1];
                i += 1;
            }
            tab[i] = null;
        }
        return value;
    }

    public boolean IsEmpty(String[] tab) {
        boolean statement = false;
        if (tab[0] == null) {
            statement = true;
        }
        return statement;
    }

    public String[] converter(String expression) {//Il faut considérer aussi les parenthèses dans l'écriture de la postfix notation
        String[] splitFixNotation = expression.split(""); //expression split
        String[] splitPostfixNotation = new String[splitFixNotation.length]; //nouvelle liste
        int j = 0;
        int i = 0;
        while (i < splitPostfixNotation.length-1) {
            if (splitFixNotation[i].equals("+") || splitFixNotation[i].equals("*") || splitFixNotation[i].equals("/")) {//Test sur l'exression split
                if (splitFixNotation[i-1].equals(")")||splitFixNotation[i+1].equals("(")){
                    //splitPostfixNotation[i]=(this.Push(splitPostfixNotation, splitFixNotation[i]))[i];
                    i+=1;

                }
                    if (j == 0) { //marche pour la première équation mais cv poser pb
                    // {
                    splitPostfixNotation[i - 1] = (this.Push(splitPostfixNotation, splitFixNotation[i - 1]))[i - 1];//un peu con ça expression compliqué pour rien
                    splitPostfixNotation[i + 1] = (this.Push(splitPostfixNotation, splitFixNotation[i + 1]))[i + 1];
                    splitPostfixNotation[i] = (this.Push(splitPostfixNotation, splitFixNotation[i]))[i];
                    j += 1;
                    i += 1;
                }else{
                    splitPostfixNotation[i + 1] = (this.Push(splitPostfixNotation, splitFixNotation[i + 1]))[i + 1];
                    splitPostfixNotation[i] = (this.Push(splitPostfixNotation, splitFixNotation[i]))[i];
                    i += 1;

                }
            } else if (splitFixNotation[i].equals("(")) {
                int k=0;
                splitPostfixNotation[i]=(this.Push(splitPostfixNotation, splitFixNotation[i]))[i];
                while (splitFixNotation[i].equals(")") == false) {
                    if (splitFixNotation[i].equals("+") || splitFixNotation[i].equals("*") || splitFixNotation[i].equals("/")) {
                        if (k == 0) { //marche pour la première équation mais cv poser pb
                            // {
                            splitPostfixNotation[i - 1] = (this.Push(splitPostfixNotation, splitFixNotation[i - 1]))[i - 1];
                            splitPostfixNotation[i + 1] = (this.Push(splitPostfixNotation, splitFixNotation[i + 1]))[i + 1];
                            splitPostfixNotation[i] = (this.Push(splitPostfixNotation, splitFixNotation[i]))[i];
                            k += 1;
                            i += 1;
                        } else {
                            splitPostfixNotation[i + 1] = (this.Push(splitPostfixNotation, splitFixNotation[i + 1]))[i + 1];
                            splitPostfixNotation[i] = (this.Push(splitPostfixNotation, splitFixNotation[i]))[i];
                            i += 1;
                        }
                    } else {
                        i+=1;
                    }
                }
                splitPostfixNotation[i]=(this.Push(splitPostfixNotation, splitFixNotation[i]))[i];
                i+=1;
            }
            else{// si c'est un chiffre on ne considère juste pas et on passe au terme suivant
                i+=1;
            }
                }
        splitPostfixNotation[i]=(this.Push(splitPostfixNotation, splitFixNotation[i]))[i];
        return splitPostfixNotation;
            }
        }



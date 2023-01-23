package com.finish;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};


        System.out.print("Введите выражение без пробелов: ");
        String res = scn.nextLine();



        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if(res.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        if(actionIndex==-1){
            System.out.println("Не верный формат!");
            return;
        }

        String[] data = res.split(regexActions[actionIndex]);

        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;

            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
                if(a < b){
                    System.out.println("В римской системе нет отрицательных чисел");
                    return;
                }

            }else
            {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            int numberStop = 0;
            if(a > 10) {
                numberStop = 1;
            }
            else if(b > 10){
                numberStop = 1;
            }
            else{
                numberStop = 0;
            }

            if(numberStop == 1){
                System.out.println("Число 1 или 2 большее 10");
                return;
            }


            int result;
            switch (actions[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }
            if(isRoman){
                System.out.println(converter.intToRoman(result));
            }
            else
            {
                System.out.println(result);
            }
        }else{
            System.out.println("Используются одновременно разные системы счисления");
        }

    }
}
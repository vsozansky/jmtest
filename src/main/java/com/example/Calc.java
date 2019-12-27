package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Calc {

    public String jobLine;

    public Calc(String jobLine) {
        this.jobLine = jobLine;
    }

    public static Calc getInstance(String line){
        Calc calc;
        if (CalcArab.test(line)) {
            calc = new CalcArab(line);
        } else if (CalcRoman.test(line)) {
            calc = new CalcRoman(line);
        } else {
            throw new RuntimeException("Входящая строка содержит ошибку");
        }
        return calc;
    }

    public int stingToInt(String str){
        return Integer.parseInt(str);
    }

    public String intToString(int num){
        return Integer.toString(num);
    }

    public String calculate(){

        //статья с примером как разделить строку чтобы разделитель также оставался
        //https://legkovopros.ru/questions/9439/regex-dlya-razdeleniya-stroki-s-odnim-ili-neskol-kimi-probelami-i-soxraneniya-ix-duplicate
        //https://www.regular-expressions.info/lookaround.html

        //Pattern pattern = Pattern.compile("((?<=\\+)|(?=\\+)|(?<=-)|(?=-)|(?<=\\*)|(?=\\*)|(?<=\\/)|(?=\\/))");
        //String[] jobSubline = pattern.split(jobLine);
        String[] jobSubline = jobLine.split("((?<=\\+)|(?=\\+)|(?<=-)|(?=-)|(?<=\\*)|(?=\\*)|(?<=\\/)|(?=\\/))");

        int num1 = stingToInt(jobSubline[0].trim());
        char oper = jobSubline[1].trim().toCharArray()[0];
        int num2 = stingToInt(jobSubline[2].trim());
        int result;

        switch (oper) {
            case  ('+'):
                result = num1 + num2;
                break;
            case ('-'):
                result = num1 - num2;
                break;
            case ('*'):
                result = num1 * num2;
                break;
            case ('/'):
                result = num1 / num2;
                break;
            default:
                throw new RuntimeException("Операция не распознана");
        }

        return intToString(result);
    }


}

package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcArab extends Calc{

    public CalcArab(String jobLine) {
        super(jobLine);
    }

    public static boolean test(String testString){
        Pattern p = Pattern.compile("^\\s*(1|2|3|4|5|6|7|8|9|10)\\s*(\\+|-|\\*|\\/)\\s*(1|2|3|4|5|6|7|8|9|10)\\s*$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

}

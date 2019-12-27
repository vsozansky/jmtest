package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcRoman extends Calc{

    public CalcRoman(String jobLine) {
        super(jobLine);
    }

    public static boolean test(String testString){
        Pattern p = Pattern.compile("^\\s*(I|II|III|IV|V|VI|VII|VIII|IX|X)\\s*(\\+|-|\\*|\\/)\\s*(I|II|III|IV|V|VI|VII|VIII|IX|X)\\s*$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    @Override
    public int stingToInt(String str){
        HashMap<String, Integer> mapStingToInteger = new HashMap<String, Integer>();
        mapStingToInteger.put("I",1);
        mapStingToInteger.put("II",2);
        mapStingToInteger.put("III",3);
        mapStingToInteger.put("IV",4);
        mapStingToInteger.put("V",5);
        mapStingToInteger.put("VI",6);
        mapStingToInteger.put("VII",7);
        mapStingToInteger.put("VIII",8);
        mapStingToInteger.put("IX",9);
        mapStingToInteger.put("X",10);
        return mapStingToInteger.get(str);
    }

    @Override
    public String intToString(int num){
        String tmpRes = "";
        int tmpNum = num;
        int num100 = tmpNum / 100;
        if (num100 > 0){
            tmpNum = tmpNum - num100*100;
            for (int i = num100; i>0; i--){
                tmpRes = tmpRes + "C";
            }
        }

        int num50 = tmpNum / 50;
        if (num50 > 0){
            tmpNum = tmpNum - num50*50;
            for (int i = num50; i>0; i--){
                tmpRes = tmpRes + "L";
            }
        }

        int num40 = tmpNum / 40;
        if (num40 > 0){
            tmpNum = tmpNum - num40*40;
            for (int i = num40; i>0; i--){
                tmpRes = tmpRes + "XL";
            }
        }

        int num10 = tmpNum / 10;
        if (num10 > 0){
            tmpNum = tmpNum - num10*10;
            for (int i = num10; i>0; i--){
                tmpRes = tmpRes + "X";
            }
        }

        int num5 = tmpNum / 5;
        if (num5 > 0){
            tmpNum = tmpNum - num5*5;
            for (int i = num5; i>0; i--){
                tmpRes = tmpRes + "V";
            }
        }

        int num4 = tmpNum / 4;
        if (num4 > 0){
            tmpNum = tmpNum - num4*4;
            for (int i = num4; i>0; i--){
                tmpRes = tmpRes + "IV";
            }
        }

        for (int i = tmpNum; i>0; i--){
            tmpRes = tmpRes + "I";
        }

        return tmpRes;
    }



}

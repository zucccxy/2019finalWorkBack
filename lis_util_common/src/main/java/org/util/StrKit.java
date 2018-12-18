package org.util;

public class StrKit {
    public static String codeAddOne(String code, int len){
        String strHao = code.toString();
        while (strHao.length() < len) {
            strHao = "0" + strHao;
        }
        return strHao;
    }

}

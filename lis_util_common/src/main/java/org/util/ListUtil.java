package org.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    public static String toStringList(List<?> list){
        StringBuffer sb = new StringBuffer("[");
        list.forEach(o ->{
            sb.append(o.toString());
            sb.append(",");
        });
        String result = sb.toString();

        return  result.substring(0,result.length()-1)+"]";
    }

    public static void main(String[]args){
        List<Long> longs = new ArrayList<>();
        longs.add(3L);
        longs.add(2L);
        System.err.println(toStringList(longs));
    }

}

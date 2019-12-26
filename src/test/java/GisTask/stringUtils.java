package GisTask;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author Jayce
 * @date 2019/11/10
 */
public class stringUtils {
    private String[] encoding = {"ASCII","UNICODE","UTF-8","UTF-16","GB2312","ISO-8859-1","BIG5","GB18030"};

    @Test
    public void IsoToUtf(){
        String s = "{\"dbcode\":\"ksjd\",\"exceltable\":[{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"鍦板尯\",\"leftline\":0,\"rightline\":0,\"row\":0,\"rowspan\":1,\"sort\":\"col\",\"topline\":1},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"鍦板尯鐢熶骇鎬诲€�(浜垮厓)\",\"leftline\":1,\"rightline\":0,\"row\":0,\"rowspan\":1,\"sort\":\"col\",\"topline\":1},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"鍖椾含甯�\",\"leftline\":0,\"rightline\":0,\"row\":1,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"15212.51\",\"leftline\":1,\"rightline\":0,\"row\":1,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"澶╂触甯�\",\"leftline\":0,\"rightline\":0,\"row\":2,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"10371.16\",\"leftline\":1,\"rightline\":0,\"row\":2,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"娌冲寳鐪�\",\"leftline\":0,\"rightline\":0,\"row\":3,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"17700.00\",\"leftline\":1,\"rightline\":0,\"row\":3,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"灞辫タ鐪�\",\"leftline\":0,\"rightline\":0,\"row\":4,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"8357.65\",\"leftline\":1,\"rightline\":0,\"row\":4,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"鍐呰挋鍙よ嚜娌诲尯\",\"leftline\":0,\"rightline\":0,\"row\":5,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"8266.70\",\"leftline\":1,\"rightline\":0,\"row\":5,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"杈藉畞鐪�\",\"leftline\":0,\"rightline\":0,\"row\":6,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"12043.37\",\"leftline\":1,\"rightline\":0,\"row\":6,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"鍚夋灄鐪�\",\"leftline\":0,\"rightline\":0,\"row\":7,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"6314.10\",\"leftline\":1,\"rightline\":0,\"row\":7,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"榛戦緳姹熺渷\",\"leftline\":0,\"rightline\":0,\"row\":8,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"6460.98\",\"leftline\":1,\"rightline\":0,\"row\":8,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"涓婃捣甯�\",\"leftline\":0,\"rightline\":0,\"row\":9,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"16409.94\",\"leftline\":1,\"rightline\":0,\"row\":9,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"姹熻嫃鐪�\",\"leftline\":0,\"rightline\":0,\"row\":10,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"48582.66\",\"leftline\":1,\"rightline\":0,\"row\":10,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"娴欐睙鐪�\",\"leftline\":0,\"rightline\":0,\"row\":11,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"28256.33\",\"leftline\":1,\"rightline\":0,\"row\":11,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"瀹夊窘鐪�\",\"leftline\":0,\"rightline\":0,\"row\":12,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"15663.98\",\"leftline\":1,\"rightline\":0,\"row\":12,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"绂忓缓鐪�\",\"leftline\":0,\"rightline\":0,\"row\":13,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"16640.15\",\"leftline\":1,\"rightline\":0,\"row\":13,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"姹熻タ鐪�\",\"leftline\":0,\"rightline\":0,\"row\":14,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"10757.24\",\"leftline\":1,\"rightline\":0,\"row\":14,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"灞变笢鐪�\",\"leftline\":0,\"rightline\":0,\"row\":15,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"41823.31\",\"leftline\":1,\"rightline\":0,\"row\":15,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"娌冲崡鐪�\",\"leftline\":0,\"rightline\":0,\"row\":16,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"24203.80\",\"leftline\":1,\"rightline\":0,\"row\":16,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"婀栧寳鐪�\",\"leftline\":0,\"rightline\":0,\"row\":17,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"19895.75\",\"leftline\":1,\"rightline\":0,\"row\":17,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"婀栧崡鐪�\",\"leftline\":0,\"rightline\":0,\"row\":18,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"17784.62\",\"leftline\":1,\"rightline\":0,\"row\":18,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"骞夸笢鐪�\",\"leftline\":0,\"rightline\":0,\"row\":19,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"50501.17\",\"leftline\":1,\"rightline\":0,\"row\":19,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"骞胯タ澹\uE1BD棌鑷\uE045不鍖�\",\"leftline\":0,\"rightline\":0,\"row\":20,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"8906.91\",\"leftline\":1,\"rightline\":0,\"row\":20,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"娴峰崡鐪�\",\"leftline\":0,\"rightline\":0,\"row\":21,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"2668.96\",\"leftline\":1,\"rightline\":0,\"row\":21,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"閲嶅簡甯�\",\"leftline\":0,\"rightline\":0,\"row\":22,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"10334.76\",\"leftline\":1,\"rightline\":0,\"row\":22,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"鍥涘窛鐪�\",\"leftline\":0,\"rightline\":0,\"row\":23,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"20517.21\",\"leftline\":1,\"rightline\":0,\"row\":23,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"璐靛窞鐪�\",\"leftline\":0,\"rightline\":0,\"row\":24,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"7212.94\",\"leftline\":1,\"rightline\":0,\"row\":24,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"浜戝崡鐪�\",\"leftline\":0,\"rightline\":0,\"row\":25,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"7957.43\",\"leftline\":1,\"rightline\":0,\"row\":25,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"瑗胯棌鑷\uE045不鍖�\",\"leftline\":0,\"rightline\":0,\"row\":26,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"681.69\",\"leftline\":1,\"rightline\":0,\"row\":26,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"闄曡タ鐪�\",\"leftline\":0,\"rightline\":0,\"row\":27,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"11625.57\",\"leftline\":1,\"rightline\":0,\"row\":27,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"鐢樿們鐪�\",\"leftline\":0,\"rightline\":0,\"row\":28,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"3771.82\",\"leftline\":1,\"rightline\":0,\"row\":28,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"闈掓捣鐪�\",\"leftline\":0,\"rightline\":0,\"row\":29,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"1278.18\",\"leftline\":1,\"rightline\":0,\"row\":29,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"瀹佸\uE634鍥炴棌鑷\uE045不鍖�\",\"leftline\":0,\"rightline\":0,\"row\":30,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"1742.60\",\"leftline\":1,\"rightline\":0,\"row\":30,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0},{\"bottomline\":1,\"col\":0,\"colspan\":1,\"data\":\"鏂扮枂缁村惥灏旇嚜娌诲尯\",\"leftline\":0,\"rightline\":0,\"row\":31,\"rowspan\":1,\"sort\":\"row\",\"topline\":0},{\"bottomline\":1,\"col\":1,\"colspan\":1,\"data\":\"5291.37\",\"leftline\":1,\"rightline\":0,\"row\":31,\"rowspan\":1,\"sort\":\"cell\",\"topline\":0}],\"htmltable\":\"鍦板尯鍦板尯鐢熶骇鎬诲€�(浜垮厓)鍖椾含甯�15212.51\\n澶╂触甯�10371.16\\n娌冲寳鐪�17700.00\\n灞辫タ鐪�8357.65\\n鍐呰挋鍙よ嚜娌诲尯8266.70\\n杈藉畞鐪�12043.37\\n鍚夋灄鐪�6314.10\\n榛戦緳姹熺渷6460.98\\n涓婃捣甯�16409.94\\n姹熻嫃鐪�48582.66\\n娴欐睙鐪�28256.33\\n瀹夊窘鐪�15663.98\\n绂忓缓鐪�16640.15\\n姹熻タ鐪�10757.24\\n灞变笢鐪�41823.31\\n娌冲崡鐪�24203.80\\n婀栧寳鐪�19895.75\\n婀栧崡鐪�17784.62\\n骞夸笢鐪�50501.17\\n骞胯タ澹\uE1BD棌鑷\uE045不鍖�8906.91\\n娴峰崡鐪�2668.96\\n閲嶅簡甯�10334.76\\n鍥涘窛鐪�20517.21\\n璐靛窞鐪�7212.94\\n浜戝崡鐪�7957.43\\n瑗胯棌鑷\uE045不鍖�681.69\\n闄曡タ鐪�11625.57\\n鐢樿們鐪�3771.82\\n闈掓捣鐪�1278.18\\n瀹佸\uE634鍥炴棌鑷\uE045不鍖�1742.60\\n鏂扮枂缁村惥灏旇嚜娌诲尯5291.37\\n\",\"memos\":[\"鏈\uE103〃鎸夊綋骞翠环鏍艰\uE178绠椼€�\"],\"title\":\"绱\uE21D\uE178鍦板尯鐢熶骇鎬诲€�\"}";
        String res = null;
        try {
            res = new String(s.getBytes("GBK"), StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("res = " + res);
    }

    @Test
    public void change(){
        String s = "倿";
        String res = null;
        try {
            res = new String(s.getBytes("UTF-8"), "Unicode");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("res = " + res);
    }

    @Test
    public void judge(){
        String out = "倿";
        String in = "值";
        boolean flag = false;
        for (int i = 0; i < encoding.length; i++) {
            for (int j = 0; j < encoding.length; j++) {
                try {
                    String res = new String(in.getBytes(encoding[i]),encoding[j]);
                    if(out.equals(res)){
                        flag = true;
                        System.out.println(encoding[i] + "---" + encoding[j]);
                    }
                    System.out.println(in + " : " + encoding[i] + " -> " + encoding[j] + " => " + res);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        if (flag){
            System.out.println("查询成功");
        }else {
            System.out.println("查询失败");
        }
    }

    @Test
    public void setEncoding(){
        String out = "倿";
        String in = "值";
        System.out.println(strTo16(in));
        for (int i = 0; i < encoding.length; i++) {
            String res = null;
            try {
                res = new String(in.getBytes(encoding[i]));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println("res = " + strTo16(res));
        }
    }

    public static String strTo16(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str.append(s4);
        }
        return str.toString();
    }
}

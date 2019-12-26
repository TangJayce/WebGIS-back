package GisTask.util;

import GisTask.domain.Point;

import java.util.ArrayList;

/**
 * @author Jayce
 * @date 2019/10/15
 */
public class StringUtils {
    private static final String introduction_default_str = "这个人很懒，没有介绍";
    private static final String hobby_default_str = "学习";
    private static final String realName_default_str = "未填写";

    public static String is_null(String str){
        if(str == null || str.trim().length() == 0)
            return null;
        return str;
    }

    public static String introduction_default(String str){
        if(str == null || str.trim().length() == 0)
            return introduction_default_str;
        return str;
    }

    public static String hobby_default(String str){
        if(str == null || str.trim().length() == 0)
            return hobby_default_str;
        return str;
    }

    public static String realName_default(String str){
        if(str == null || str.trim().length() == 0)
            return realName_default_str;
        return str;
    }

    public static Point StringToPoint(String str){
        str = str.replace("POINT","").replace("(","").replace(")","");
        String[] s = str.split(" ");
        return new Point(Double.parseDouble(s[0]),Double.parseDouble(s[1]));
    }

    public static ArrayList<Point> StringToPointArray(String str){
        str = str.replace("POLYGON","").replace("((","").replace("))","");
        String[] points = str.split(",");
        ArrayList<Point> pointArray = new ArrayList<>();
        for (String pointStr : points) {
            String[] s = pointStr.split(" ");
            pointArray.add(new Point(Double.parseDouble(s[0]),Double.parseDouble(s[1])));
        }
        return pointArray;
    }
}

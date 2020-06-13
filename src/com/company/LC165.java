package com.company;

public class LC165 {
    //版本号比较
    public static void main(String[] args) {
//        System.out.println(compareVersion2("com.sank.demo:1.1.0-r", "com.sank.demo:1.1.0-a"));
    }

    private static int compareVersion2(String version1, String version2) {
        int startDiffer = 0;
        for (int i = 0; i < Math.max(version1.length(), version2.length()); i++) {
            if (!Character.isDigit(version1.charAt(i))) {
                if (version1.charAt(i) != version2.charAt(i)) {
                    return 4;
                }
            } else {
                startDiffer = i;//是数字就返回下标
                break;
            }
        }
        String[] v1 = version1.substring(startDiffer).split("-");
        String[] v2 = version2.substring(startDiffer).split("-");
        String versionEnd1 = v1.length > 1 ? v1[1] : "a";
        String versionEnd2 = v2.length > 1 ? v2[1] : "a";
        String digit1 = v1[0];
        String digit2 = v2[0];
        //用来处理数字部分
        String[] di1 = digit1.split("\\.");
        String[] di2 = digit2.split("\\.");
        int c1, c2;
        for (int i = 0; i < Math.max(digit1.length(), digit2.length()); i++) {
            c1 = i < di1.length ? Integer.parseInt(di1[1]) : 0;
            c2 = i < di2.length ?Integer.parseInt(di2[1]) : 0;
            if(c1!=c2){
                return c1>c2?1:-1;
            }
        }
        if(versionEnd1!=null&&versionEnd2!=null){
            return versionEnd1.charAt(0)>versionEnd2.charAt(0)?1:-1;
        }
        return 0;
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int v1leng = v1.length;
        int v2leng = v2.length;
        int temp1, temp2; //保存比较的字串
        int maxlength = Math.max(v1leng, v2leng);
        for (int i = 0; i < maxlength; i++) {
            //不够补齐和算一起进行 只不过是先进行了补齐 后面算
            temp1 = i < v1leng ? Integer.parseInt(v1[i]) : 0;
            temp2 = i < v2leng ? Integer.parseInt(v2[i]) : 0;
            if (temp1 != temp2) {
                return temp1 > temp2 ? 1 : -1;
            }
        }

        return 0;
    }
}

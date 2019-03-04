package com.yunanbao.encrypt;

public class Util
{
    /**
     * 工具类不应该被初始化
     */
    private Util()
    {
        throw new IllegalStateException("Utility class");
    }

    public static String printHexFromByte(byte[] b){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<b.length;i++){
            String oneByte = Integer.toHexString(b[i] & 0xff).toUpperCase();
            if(oneByte.length() == 1){
                oneByte = "0" + oneByte;
            }
            if(i == 0)
            {
                res.append(oneByte);
            }else{
                res.append(" ").append(oneByte);
            }
        }
        return res.toString();
    }
}

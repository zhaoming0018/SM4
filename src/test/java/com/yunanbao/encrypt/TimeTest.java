package com.yunanbao.encrypt;

import org.junit.Test;

public class TimeTest {
    public byte[] getRandomBytes(int len){
        byte[] res = new byte[len];
        for(int i=0;i<len;i++)
            res[i] = (byte) (Math.random()*256);
        return res;
    }
    @Test
    public void time(){
        int[] lengths = new int[16];
        lengths[0] = 128;
        lengths[1] = 128;
        lengths[2] = 128;
        lengths[3] = 128;
        lengths[4] = 128;
        for(int i=4;i<lengths.length;i++)
            lengths[i] = 2 * lengths[i-1];
        for(int i=0;i<lengths.length;i++){
            System.out.println("length: "+String.valueOf(lengths[i]));
            long encodeTime = 0;
            long decodeTime = 0;
            for(int j=0;j<20;j++) {
                byte[] iv = getRandomBytes(16);
                byte[] key = getRandomBytes(16);
                byte[] plainText = getRandomBytes(lengths[i]);
                //System.out.println("plainText:");
                //System.out.println(Util.printHexFromByte(plainText));
                long startTime = System.nanoTime();
                byte[] cipherText = SM4Api.sm4Encode(iv, key, plainText);
                long endTime = System.nanoTime();
                encodeTime += endTime-startTime;
                //System.out.println("cipherText:");
                //System.out.println(Util.printHexFromByte(cipherText));
                startTime = System.nanoTime();
                byte[] decoded = SM4Api.sm4Decode(iv, key, cipherText);
                endTime = System.nanoTime();
                decodeTime += endTime-startTime;
                //System.out.println("decoded:");
                //System.out.println(Util.printHexFromByte(decoded));
                //System.out.println();
            }
            System.out.println("encodeTime: "+String.valueOf((double) encodeTime / 1e6)+" ms");
            System.out.println("decodeTime: "+String.valueOf(decodeTime / 1e6)+" ms");

        }
    }
}

package com.yunanbao.encrypt;



import org.junit.Test;

import java.util.Arrays;

public class SM4Test {

    @Test
    public void testApi()
    {
        byte[] key = {(byte)0x01, (byte)0x23, (byte)0x45, (byte)0x67, (byte)0x89, (byte)0xAB, (byte)0xCD, (byte)0xEF,
                (byte)0xFE, (byte)0xDC,(byte)0xBA, (byte)0x98,(byte)0x76, (byte)0x54,(byte)0x32, (byte)0x10};
        byte[] plainText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes();
        byte[] encrpyt = SM4Api.sm4Encode(key, key, plainText);
        System.out.println(Util.printHexFromByte(encrpyt));
        byte[] decrypt = SM4Api.sm4Decode(key, key, encrpyt);
        System.out.println(Util.printHexFromByte(decrypt));
        assert Arrays.equals(plainText, decrypt);
    }

    @Test
    public void capitalTest()
    {
        byte[] key = {(byte)0x01, (byte)0x23, (byte)0x45, (byte)0x67, (byte)0x89, (byte)0xAB, (byte)0xCD, (byte)0xEF,
                (byte)0xFE, (byte)0xDC,(byte)0xBA, (byte)0x98,(byte)0x76, (byte)0x54,(byte)0x32, (byte)0x10};
        byte[] plainText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes();
        SM4Utils sm4 = new SM4Utils();

        System.out.println("CBC mode");
        System.out.println("plain text:");
        System.out.println(Util.printHexFromByte(plainText));
        sm4.setSecretKey(key);
        sm4.setIv(key);
        byte[] cipherText = sm4.encryptDataCBC(plainText);
        System.out.println("cipher text:");
        System.out.println(Util.printHexFromByte(cipherText));
        sm4.setSecretKey(key);
        sm4.setIv(key);
        byte[] decrypt = sm4.decryptDataCBC(cipherText);
        System.out.println("decode :");
        System.out.println(Util.printHexFromByte(decrypt));
        assert Arrays.equals(plainText, decrypt);
    }

    @Test
    public void strangeLetterTest()
    {
        byte[] key = {(byte)0x01, (byte)0x23, (byte)0x45, (byte)0x67, (byte)0x89, (byte)0xAB, (byte)0xCD, (byte)0xEF,
                (byte)0xFE, (byte)0xDC,(byte)0xBA, (byte)0x98,(byte)0x76, (byte)0x54,(byte)0x32, (byte)0x10};
        byte[] plainText = "1234567890!@#$%^&*()_+-={}[]<>《》".getBytes();
        SM4Utils sm4 = new SM4Utils();

        System.out.println("CBC mode");
        System.out.println("plain text: ");
        System.out.println(Util.printHexFromByte(plainText));
        sm4.setSecretKey(key);
        sm4.setIv(key);
        byte[] cipherText = sm4.encryptDataCBC(plainText);
        System.out.println("cipher text:");
        System.out.println(Util.printHexFromByte(cipherText));
        sm4.setSecretKey(key);
        sm4.setIv(key);
        byte[] decrypt = sm4.decryptDataCBC(cipherText);
        System.out.println("decode : ");
        System.out.println(Util.printHexFromByte(decrypt));
        assert Arrays.equals(plainText, decrypt);
    }

    @Test
    public void ChineseTest()
    {
        byte[] key = {(byte)0x01, (byte)0x23, (byte)0x45, (byte)0x67, (byte)0x89, (byte)0xAB, (byte)0xCD, (byte)0xEF,
                (byte)0xFE, (byte)0xDC,(byte)0xBA, (byte)0x98,(byte)0x76, (byte)0x54,(byte)0x32, (byte)0x10};
        byte[] plainText = "第一章总纲第一条中华人民共和国是工人阶级领导的、以工农联盟为基础的人民民主专政的社会主义国家。社会主义制度是中华人民共和国的根本制度。中国共产党领导是中国特色社会主义最本质的特征。禁止任何组织或者个人破坏社会主义制度。第二条中华人民共和国的一切权力属于人民。人民行使国家权力的机关是全国人民代表大会和地方各级人民代表大会。人民依照法律规定，通过各种途径和形式，管理国家事务，管理经济和文化事业，管理社会事务".getBytes();
        SM4Utils sm4 = new SM4Utils();

        System.out.println("CBC mode");
        System.out.println("plain text: ");
        System.out.println(Util.printHexFromByte(plainText));
        sm4.setSecretKey(key);
        sm4.setIv(key);
        byte[] cipherText = sm4.encryptDataCBC(plainText);
        System.out.println("cipher text:");
        System.out.println(Util.printHexFromByte(cipherText));
        sm4.setSecretKey(key);
        sm4.setIv(key);
        byte[] decrypt = sm4.decryptDataCBC(cipherText);
        System.out.println("decode :");
        System.out.println(Util.printHexFromByte(decrypt));
        assert Arrays.equals(plainText, decrypt);
    }
}

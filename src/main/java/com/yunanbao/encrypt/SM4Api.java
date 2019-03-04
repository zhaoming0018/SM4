package com.yunanbao.encrypt;

public class SM4Api {

    private SM4Api(){
        throw new IllegalStateException("Util library!");
    }

    public static byte[] sm4Encode(byte[] iv, byte[] secret, byte[] plainText){
        SM4Utils sm4 = new SM4Utils();
        sm4.setSecretKey(secret);
        sm4.setIv(iv);
        return sm4.encryptDataCBC(plainText);
    }

    public static byte[] sm4Decode(byte[] iv, byte[] secret, byte[] cipherText){
        SM4Utils sm4 = new SM4Utils();
        sm4.setSecretKey(secret);
        sm4.setIv(iv);
        return sm4.decryptDataCBC(cipherText);
    }
}

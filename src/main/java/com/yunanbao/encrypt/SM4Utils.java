package com.yunanbao.encrypt;

public class SM4Utils
{
    private byte[] iv = new byte[16];

    private byte[] secretKey;

	public byte[] getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(byte[] secretKey) {
		this.secretKey = secretKey;
	}

	public byte[] getIv() {
		return iv;
	}

	public void setIv(byte[] iv) {
		System.arraycopy(iv, 0, this.iv, 0, iv.length);
	}

	public byte[] encryptDataCBC(byte[] plainText)
	{
		try
		{
			SM4Context ctx = new SM4Context();
			ctx.setPadding(true);
			ctx.setMode(SM4.SM4_ENCRYPT);
			SM4 sm4 = new SM4();
			sm4.sm4SetkeyEnc(ctx, secretKey);
			return sm4.sm4CryptCbc(ctx, iv, plainText);
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			return null;
		}
	}

	public byte[] decryptDataCBC(byte[] cipherText)
	{
		try
		{
			SM4Context ctx = new SM4Context();
			ctx.setPadding(true);
			ctx.setMode(SM4.SM4_DECRYPT);
			SM4 sm4 = new SM4();
			sm4.sm4SetkeyDec(ctx, secretKey);
			System.out.println("key is :"+Util.printHexFromByte(secretKey));
			return sm4.sm4CryptCbc(ctx, iv, cipherText);
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			return null;
		}
	}
}

package com.yunanbao.encrypt;

public class SM4Context
{
	private int mode;

	private long[] sk;

	private boolean isPadding;

	public int getMode(){
	    return this.mode;
    }

    public void setMode(int mode){
	    this.mode = mode;
    }

	public SM4Context()
	{
		this.mode = 1;
		this.isPadding = true;
		this.sk = new long[32];
	}

    public boolean isPadding() {
        return isPadding;
    }

    public void setPadding(boolean padding) {
        isPadding = padding;
    }

    public long[] getSk() {
        return sk;
    }

    public void setSk(long[] sk) {
        this.sk = sk;
    }
}

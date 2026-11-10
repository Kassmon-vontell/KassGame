package com.kassmon.asm.plugin;

public abstract class Plugin {
	
	protected int startMemoryAddress;
	
	public Plugin(int startMemoryAddress) {
		this.startMemoryAddress = startMemoryAddress;
	}
	
	public int getStartMemoryAddress() {
		return this.startMemoryAddress;
	}
	
	public abstract int read(int pointer);
	public abstract void write(int pointer, int value);
	
	
}

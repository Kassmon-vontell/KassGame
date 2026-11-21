package com.kassmon.asm.runtime.data;

import java.util.HashMap;

public class Memory {
	
	private final HashMap<Integer, Integer> memory;
	
	public Memory() {
		memory = new HashMap<>();
	}
	
	public void write(int address, int value) {
		memory.put(address, value);
	}
	
	public int read(int address) {
		return memory.getOrDefault(address, 0);
	}
	
	public void clear() {
		memory.clear();
	}
	
	public boolean contains(int address) {
		return memory.containsKey(address);
	}
	
	public void remove(int address) {
		memory.remove(address);
	}
	
}

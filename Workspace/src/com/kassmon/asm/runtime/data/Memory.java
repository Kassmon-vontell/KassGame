package com.kassmon.asm.runtime.data;

import java.util.HashMap;

import com.kassmon.asm.exceptions.MemoryOutOfBoundsException;

public class Memory {
	
	private final HashMap<Integer, Integer> memory;
	private final int size;
	
	public Memory(int size) {
		memory = new HashMap<>();
		this.size = size;
	}
	
	public void write(int address, int value) {
		if (address < 0 || address >= size) 
			throw new MemoryOutOfBoundsException("Address out of bounds: " + address);
		memory.put(address, value);
	}
	
	public int read(int address) {
		if (address < 0 || address >= size) 
			throw new MemoryOutOfBoundsException("Address out of bounds: " + address);
		return memory.getOrDefault(address, 0);
	}
	
	public void clear() {
		memory.clear();
	}
	
	public boolean contains(int address) {
		if (address < 0 || address >= size) 
			throw new MemoryOutOfBoundsException("Address out of bounds: " + address);
		return memory.containsKey(address);
	}
	
	public void remove(int address) {
		if (address < 0 || address >= size) 
			throw new MemoryOutOfBoundsException("Address out of bounds: " + address);
		memory.remove(address);
	}
	
}

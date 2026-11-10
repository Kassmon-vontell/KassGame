package com.kassmon.asm.runtime.data;

import java.util.HashMap;

public class LabelPointers {
	
	private HashMap<String, Integer> labelPointers;
	
	public LabelPointers() {
		this.labelPointers = new HashMap<>();
	}
	
	public void addLabelPointer(String label, int pointer) {
		this.labelPointers.put(label, pointer);
	}
	
	public int getLabelPointer(String label) {
		return this.labelPointers.get(label);
	}
	
	public boolean hasLabelPointer(String label) {
		return this.labelPointers.containsKey(label);
	}
	
}

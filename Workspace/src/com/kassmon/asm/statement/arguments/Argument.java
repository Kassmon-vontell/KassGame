package com.kassmon.asm.statement.arguments;

public class Argument {
	
	private final ArgumentType type;
	private final int value;
	
	public Argument(ArgumentType type, int value) {
		this.type = type;
		this.value = value; 
	}
	
	public ArgumentType getType() {
		return type;
	}
	
	public Integer getValue() {
		return value;
	}
	
}

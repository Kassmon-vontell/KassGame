package com.kassmon.asm.core.statement.arguments;

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
	
	@Override
	public String toString() {
		if (type == ArgumentType.LITERAL) return String.valueOf(value);
		return ("r" + value);
		
	}
	
}

package com.kassmon.asm.plugin;

import java.util.ArrayList;

import com.kassmon.asm.runtime.data.Registers;

@SuppressWarnings("unused")
public class PluginManager {
	
	private Registers registers;
	private ArrayList<Plugin> plugins;
	
	public PluginManager() {
		this.plugins = new ArrayList<>();
	}
	
	public void setRegisters(Registers registers) {
		this.registers = registers;
	}
	
	public int read() {
		//TODO: Implement reading from plugins
		return 0;
	}
	
	public void write(int value) {
		//TODO: Implement writing to plugins
	}
	
}

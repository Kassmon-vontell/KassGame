package com.kassmon.asm.plugin;

import java.util.ArrayList;

import com.kassmon.asm.runtime.data.Registers;

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
		for (Plugin plugin : this.plugins) {
			if (registers.getAddressRegister() >= plugin.getMemoryStartAddress() && registers.getAddressRegister() <= plugin.getMemoryEndAddress()) {
				return plugin.read(registers.getAddressRegister());
			}
		}
		return 0;
	}
	
	public void write(int value) {
		for (Plugin plugin : this.plugins) {
			if (registers.getAddressRegister() >= plugin.getMemoryStartAddress() && registers.getAddressRegister() <= plugin.getMemoryEndAddress()) {
				plugin.write(registers.getAddressRegister(), value);
				return;
			}
		}
	}
	
}

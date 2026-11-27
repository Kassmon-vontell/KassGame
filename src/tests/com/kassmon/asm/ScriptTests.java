package tests.com.kassmon.asm;

import com.kassmon.asm.core.runtime.RuntimeInterpreter;

public class ScriptTests{
	
	public static boolean runtimeTest() {
		String script = ":init\n mov r0 0x1\n :start\n add r0 1\n cmp r0 0x10\n jlt start\n";
		
		RuntimeInterpreter interpreter = new RuntimeInterpreter(script);
		
		interpreter.executeScript();
		if (interpreter.getRegisters().read(0) != 0x10)
			return false;
		
		return true;
	}
	
}

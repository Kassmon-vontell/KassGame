package tests.com.kassmon.asm;

import com.kassmon.asm.core.runtime.RuntimeInterpreter;

public class ScriptTests{
	
	public static boolean runtimeTest() {
		String script = "mov r0 0x1\n";
		
		RuntimeInterpreter interpreter = new RuntimeInterpreter(script);
		interpreter.executeScript();
		if (interpreter.getRegisters().read(0) != 1){
			System.out.println ("runtime test failed: r0 != 1");
			return false;
		}
		
		return true;
	}
	
}

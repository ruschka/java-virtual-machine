package enviroment;

import java.util.Arrays;

import object.ArrayObject;
import object.SimulatedString;

import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

/**
 * Hlavni ridici trida VM.
 * @author ruschka
 *
 */
public class Controller {
	
	private static final String MAIN_METHOD_NAME = "main";
	private static final String MAIN_METHOD_SIGNATURE = "([Ljava/lang/String;)V";
	
	private String[] args;
	/**
	 * Main class programu. VM se na ni pokusi najit metodu main() a tu spustit.
	 */
	private String mainClassName;
	private JavaClass mainClass;
	
	public Controller(String[] args) {
		super();
		this.args = args;
	}

	public void run() {
		mainClassName = args[0];
		mainClass = ClassLoader.loadClass(mainClassName);
		Method mainMethod = ClassLoader.getMethodByName(mainClass, MAIN_METHOD_NAME, MAIN_METHOD_SIGNATURE);
		Heap heap = new Heap();
		ArrayObject argsForProgram = getArgsForProgram(heap);
		Frame frame = new Frame(null, mainClass.getConstantPool(), mainMethod.getCode().getMaxLocals());
		frame.setLocal(0, argsForProgram);
		MethodRunner methodRunner = new MethodRunner(mainMethod, frame, heap);
		methodRunner.run();
	}
	
	private ArrayObject getArgsForProgram(Heap heap) {
		String[] newArgs = Arrays.copyOfRange(args, 1, args.length);
		ArrayObject arrayArgs = new ArrayObject(args.length - 1);
		heap.addObject(arrayArgs);
		for (int i = 0; i < newArgs.length; i++) {
			SimulatedString string = new SimulatedString(newArgs[i]);
			heap.addObject(string);
			arrayArgs.putValue(i, string);
		}
		return arrayArgs;
	}

}

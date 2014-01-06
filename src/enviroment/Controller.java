package enviroment;

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
	
	/**
	 * Main class programu. VM se na ni pokusi najit metodu main() a tu spustit.
	 */
	private String mainClassName;
	private JavaClass mainClass;
	
	public Controller(String mainClass) {
		super();
		this.mainClassName = mainClass;
	}

	public void run() {
		mainClass = ClassLoader.loadClass(mainClassName);
		Method mainMethod = ClassLoader.getMethodByName(mainClass, MAIN_METHOD_NAME, MAIN_METHOD_SIGNATURE);
		Frame frame = new Frame(null, mainClass.getConstantPool(), mainMethod.getCode().getMaxLocals());
		Heap heap = new Heap();
		MethodRunner methodRunner = new MethodRunner(mainMethod, frame, heap);
		methodRunner.run();
	}

}

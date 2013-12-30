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
		try {
			mainClass = ClassLoader.loadClass(mainClassName);
			Method mainMethod = getMainMethod();
			Frame frame = new Frame(null, mainClass.getConstantPool(), mainMethod.getCode().getMaxLocals());
			Heap heap = new Heap();
			MethodRunner methodRunner = new MethodRunner(mainMethod, frame, heap);
			methodRunner.run();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Method getMainMethod() {
		Method[] methods = mainClass.getMethods();
		for (Method method : methods) {
			if (MAIN_METHOD_NAME.equals(method.getName())) {
				return method;
			}
		}
		throw new IllegalStateException("Main method not found.");
	}

}

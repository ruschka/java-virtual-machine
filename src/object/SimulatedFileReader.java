package object;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import enviroment.Frame;
import enviroment.Heap;
import enviroment.MethodSimulator;

public class SimulatedFileReader extends SimulatedObject<FileReader> {
	
	public static String CLASS_NAME = "java/io/FileReader";
	
	public SimulatedFileReader() {
		addMethodSimulator(new ConstructorSimulator());
		addMethodSimulator(new ReadSimulator());
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}
	
	/**
	 * http://docs.oracle.com/javase/7/docs/api/java/io/FileReader.html#FileReader(java.lang.String)
	 * @author ruschka
	 *
	 */
	private class ConstructorSimulator extends MethodSimulator {

		private static final String METHOD_NAME = "<init>";
		private static final String METHOD_SIGNATURE = "(Ljava/lang/String;)V";
		
		@Override
		public void run(Frame frame, Heap heap, List<Reference> arguments) {
			if (arguments.size() != 1) {
				throw new IllegalStateException("Arguments size has to be 1");
			}
			StringObject stringObject = (StringObject) arguments.get(0).getObject();
			try {
				object = new FileReader(stringObject.getValue());
			} catch (FileNotFoundException e) {
				throw new IllegalStateException("Error while creating FileReader.");
			}
		}

		@Override
		protected String getMethodName() {
			return METHOD_NAME;
		}

		@Override
		protected String getMethodSignature() {
			return METHOD_SIGNATURE;
		}
		
	}
	
	/**
	 * http://docs.oracle.com/javase/7/docs/api/java/io/Reader.html#read()
	 * @author ruschka
	 *
	 */
	private class ReadSimulator extends MethodSimulator {
		
		private static final String METHOD_NAME = "read";
		private static final String METHOD_SIGNATURE = "()I";

		@Override
		public void run(Frame frame, Heap heap, List<Reference> arguments) {
			int value = 0;
			try {
				value = object.read();
			} catch (IOException e) {
				throw new IllegalStateException("Exception while reading file.", e);
			}
			IntegerObject integerObject = new IntegerObject(value);
			heap.addObject(integerObject);
			frame.push(integerObject);
		}

		@Override
		protected String getMethodName() {
			return METHOD_NAME;
		}

		@Override
		protected String getMethodSignature() {
			return METHOD_SIGNATURE;
		}
		
	}

}

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
		addMethodSimulator(new CloseSimulator());
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
				throw new IllegalStateException("Arguments size has to be 1.");
			}
			SimulatedString stringObject = (SimulatedString) arguments.get(0).getObject();
			try {
				object = new FileReader(stringObject.getObject());
			} catch (FileNotFoundException e) {
				throw new IllegalStateException("Error while creating FileReader.", e);
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
			if (arguments.size() != 0) {
				throw new IllegalStateException("Arguments size has to be 0.");
			}
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
	
	private class CloseSimulator extends MethodSimulator {
		
		private static final String METHOD_NAME = "close";
		private static final String METHOD_SIGNATURE = "()V";

		@Override
		public void run(Frame frame, Heap heap, List<Reference> arguments) {
			if (arguments.size() != 0) {
				throw new IllegalStateException("Arguments size has to be 0.");
			}
			try {
				object.close();
			} catch (IOException e) {
				throw new IllegalStateException("Errow while closing file.");
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

}

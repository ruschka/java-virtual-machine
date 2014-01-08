package object;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import enviroment.Frame;
import enviroment.Heap;
import enviroment.MethodSimulator;

public class SimulatedFileWriter extends SimulatedObject<FileWriter> {
	
	public static String CLASS_NAME = "java/io/FileWriter";
	
	public SimulatedFileWriter() {
		addMethodSimulator(new ConstructorSimulator());
		addMethodSimulator(new WriteSimulator());
		addMethodSimulator(new CloseSimulator());
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}
	
	/**
	 * http://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html#FileWriter(java.lang.String)
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
			StringObject stringObject = (StringObject) arguments.get(0).getObject();
			try {
				object = new FileWriter(stringObject.getValue());
			} catch (IOException e) {
				throw new IllegalStateException("Error while creating FileWriter.", e);
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
	 * http://docs.oracle.com/javase/7/docs/api/java/io/Writer.html#write(int)
	 * @author ruschka
	 *
	 */
	public class WriteSimulator extends MethodSimulator {
		
		private static final String METHOD_NAME = "write";
		private static final String METHOD_SIGNATURE = "(I)V";

		@Override
		public void run(Frame frame, Heap heap, List<Reference> arguments) {
			if (arguments.size() != 1) {
				throw new IllegalStateException("Arguments size has to be 1.");
			}
			IntegerObject integerObject = (IntegerObject) arguments.get(0).getObject();
			try {
				object.write(integerObject.getValue());
			} catch (IOException e) {
				throw new IllegalStateException("Error while writing to file.", e);
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

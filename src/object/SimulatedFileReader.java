package object;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import enviroment.Frame;
import enviroment.Heap;
import enviroment.MethodSimulator;

public class SimulatedFileReader extends SimulatedObject<FileReader> {
	
	public static String CLASS_NAME = "java/io/FileReader";
	
	public SimulatedFileReader() {
		addMethodSimulator(new ReadSimulator());
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}
	
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

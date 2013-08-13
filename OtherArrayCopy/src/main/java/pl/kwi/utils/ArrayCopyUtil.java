package pl.kwi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pl.kwi.entities.ExampleEntity;

public class ArrayCopyUtil {
	
	public final static String FILE_PATH = System.getProperty("java.io.tmpdir") + File.separator;
	public final static String FILE_NAME = "test.ser";
	
	/**
	 * Method makes copy of array of objects String.
	 * 
	 * @param source array of objects String
	 * @return copy of array of object String
	 */
	public static String[] arrayCopyString(String [] source) {
		
		String[] result = new String[source.length];
		System.arraycopy(source, 0, result, 0, source.length);
		return result;
		
	}
	
	/**
	 * Method makes copy of array of objects ExampleEntity.
	 * 
	 * @param source array of objects ExampleEntity
	 * @return copy of array of object ExampleEntity
	 */
	public static ExampleEntity[] arrayCopyExampleEntity(ExampleEntity [] source) {
		
		ExampleEntity[] result = new ExampleEntity[source.length];
		System.arraycopy(source, 0, result, 0, source.length);
		return result;
		
	}
	
	public static ExampleEntity[] deepCopyExampleEntity(ExampleEntity [] source) {
		
		File file = new File(FILE_PATH + FILE_NAME);
		
		serialize(source, file);
		ExampleEntity[] result = (ExampleEntity[])deserialize(file);
		
		return result;
		
	}
	
	// ******************************************************************************* //
	// ************************** HELP METHODS *************************************** //
	// ******************************************************************************* //
	
	public static void serialize(Object obj, File file){

		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(obj);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static Object deserialize(File file) {

		Object obj = null;

		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
			obj = is.readObject();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;

	}

}

package pl.kwi.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.kwi.entities.ExampleEntity;

public class ArrayCopyUtilTest {

	@Test
	public void arrayCopyString() {
		
		String[] source = {"text1", "text2", "text3"};
		
		String[] result = ArrayCopyUtil.arrayCopyString(source);		
		result[0] = "change";
		
		assertEquals("text1", source[0]);
		
	}
	
	@Test
	public void cloneExampleEntity() {
		
		ExampleEntity[] source = {new ExampleEntity("name1"), new ExampleEntity("name2"), new ExampleEntity("name3")};
		ExampleEntity[] result = source.clone();
		
		ExampleEntity entity = result[0];
		entity.setName("change");
		
		entity = source[0];
		
		assertEquals("change", entity.getName());
		
	}
	
	@Test
	public void arrayCopyExampleEntity() {
		
		ExampleEntity[] source = {new ExampleEntity("name1"), new ExampleEntity("name2"), new ExampleEntity("name3")};
		ExampleEntity[] result = ArrayCopyUtil.arrayCopyExampleEntity(source);
		
		ExampleEntity entity = result[0];
		entity.setName("change");
		
		entity = source[0];
		
		assertEquals("change", entity.getName());
		
	}
	
	@Test
	public void deepCopyExampleEntity() {
		
		ExampleEntity[] source = {new ExampleEntity("name1"), new ExampleEntity("name2"), new ExampleEntity("name3")};
		ExampleEntity[] result = ArrayCopyUtil.deepCopyExampleEntity(source);
		
		ExampleEntity entity = result[0];
		entity.setName("change");
		
		entity = source[0];
		
		assertEquals("name1", entity.getName());
		
	}

}

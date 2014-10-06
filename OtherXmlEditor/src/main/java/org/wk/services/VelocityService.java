package org.wk.services;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class VelocityService {
	
	
	public void transformTemplate(File vmFile, File xmlFile, List<Map<String, String>> valuesList) {
		
		try {
			
			
			String vmFileName = vmFile.getName();
			String vmFileRoot = vmFile.getAbsolutePath().replace(File.separator + vmFileName, "");
			
			Properties  props = new Properties();
		    props.setProperty( "resource.loader", "file" );
		    props.setProperty( "file.resource.loader.path", vmFileRoot );
			
			VelocityEngine ve = new VelocityEngine();
	        ve.init(props);
	        
	        Template t = ve.getTemplate(vmFileName);
	        VelocityContext context = new VelocityContext();
	        context.put("valuesList", valuesList);
	        Writer writer = new FileWriter(xmlFile);
	        t.merge( context, writer );
	        
	        writer.flush();
	        writer.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

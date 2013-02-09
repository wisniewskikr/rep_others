package pl.kwi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import pl.kwi.entities.UserEntity;


public class UserService {
	
	
	private Properties props;

	
	public UserService(){		
		props = System.getProperties();
	}

	
	public void create(UserEntity user){

		Long id = createId();
		user.setId(id);
		props.setProperty(user.getId().toString(), user.getName());

	}

	public UserEntity read(Long id){

		String name = props.getProperty(id.toString());
		UserEntity user = new UserEntity(id, name);
		return user;

	}

	public void update(UserEntity user){

		props.setProperty(user.getId().toString(), user.getName());

	}

	public void delete(UserEntity user){

		props.setProperty(user.getId().toString(), "");

	}
	
	public void delete(Long id){

		UserEntity user = read(id);
		props.setProperty(user.getId().toString(), "");

	}

	public List<UserEntity> getUsers(){

		List<UserEntity> users = new ArrayList<UserEntity>();

		String currentIdString = props.getProperty("currentId");
		if(currentIdString == null){
			return users;
		}

		UserEntity user = null;
		int last = Integer.valueOf(currentIdString);
		for (int i = 1; i <= last; i++) {
			String name = props.getProperty(String.valueOf(i));
			if(name == null || name == ""){
				continue;
			}
			user = new UserEntity(Long.valueOf(i), name);
			users.add(user);
		}

		return users;
	}
	
	
	// *********************************************************** //
	// ********************** HELP METHODS *********************** //
	// *********************************************************** //
	

	private Long createId(){

		String currentIdString = props.getProperty("currentId");

		if(currentIdString == null){
			props.setProperty("currentId", "0");
			currentIdString = "0";
		}

		Long currentId = Long.valueOf(currentIdString);
		currentId++;
		props.setProperty("currentId", currentId.toString());
		return currentId;

	}


}

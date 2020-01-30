package resources;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:Configuration/${ver}/${env}/config.properties",
	"classpath:Configuration/${ver}/${env}/config.properties" // mention the property file name
})
public interface Environment extends Config {

	String Key1();
	String Key2();
	String Key3();

	
	int PORT();
	
	@Key("HOST")
	String gethost();

	@Key("PATH")
	String getpath();
	


}
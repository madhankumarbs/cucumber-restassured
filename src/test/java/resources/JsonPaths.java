package resources;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:Configuration/${ver}/JsonPath/JsonPath.properties", "classpath:Configuration/${ver}/JsonPath/JsonPath.properties" // mention the
																									// property file
																									// name
})
public interface JsonPaths extends Config {

	String jpkey();

	String jpkeyc();

	String jpkeyd();



}

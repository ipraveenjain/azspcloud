package pbj.springmvc.prop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesCache {
	private final Properties configProp = new Properties();

	private static PropertiesCache pcache;

	private PropertiesCache() {
		// Private constructor to restrict new instances
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("app.properties");
		System.out.println("Read all properties from file");
		try {
			configProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static PropertiesCache getInstance() {
		if (pcache == null) {
			pcache = new PropertiesCache();
		}
		return pcache;
	}

	public String getProperty(String key) {
		return configProp.getProperty(key);
	}

	public void setProperty(String key, String value) {
		configProp.setProperty(key, value);
	}

	public Set<String> getAllPropertyNames() {
		return configProp.stringPropertyNames();
	}

	public boolean containsKey(String key) {
		return configProp.containsKey(key);
	}
}
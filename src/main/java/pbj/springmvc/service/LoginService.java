package pbj.springmvc.service;

import org.springframework.stereotype.Service;

import pbj.springmvc.prop.PropertiesCache;

@Service
public class LoginService {

	public boolean validateUser(String userid) {
		boolean success = false;
		try {
			System.out.println("in validate use " + userid);
			String password = PropertiesCache.getInstance().getProperty(userid);

			if (password != null) {
				success = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public boolean register(String user, String password) {
		try {
			PropertiesCache cache = PropertiesCache.getInstance();
			cache.setProperty(user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}

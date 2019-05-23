package kr.or.next.nextit.com.utils;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {
	
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	
	private static String charType = "UTF-8";
	
	public CookieBox(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
	}

	public CookieBox(Cookie[] cookies) {
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
	}
	
	public Cookie getCooke(String name) {
		return cookieMap.get(name);
	}
	
	public String getValue(String name) throws IOException {
		Cookie cookie = cookieMap.get(name);

		return cookie == null ? null : URLDecoder.decode(cookie.getValue(), charType);
	}
	
	public boolean exists(String name) {
		return cookieMap.containsKey(name);
	}
	
	public static Cookie createCookie(
		String name,
		String value
	) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, charType));
		cookie.setPath("/");
		return cookie;
	}
	
	public static Cookie createCookie(
			String name,
			String value,
			String path
		) throws IOException {
			Cookie cookie = new Cookie(name, URLEncoder.encode(value, charType));
			cookie.setPath(path);
			return cookie;
		}
	
	public static Cookie createCookie(
			String name,
			String value,
			String path,
			int maxAge
		) throws IOException {
			Cookie cookie = new Cookie(name, URLEncoder.encode(value, charType));
			cookie.setPath(path);
			cookie.setMaxAge(maxAge);
			return cookie;
		}
	
	public static Cookie createCookie(
			String name,
			String value,
			String path,
			int maxAge,
			String domain
		) throws IOException {
			Cookie cookie = new Cookie(name, URLEncoder.encode(value, charType));
			cookie.setPath(path);
			cookie.setMaxAge(maxAge);
			cookie.setDomain(domain);
			return cookie;
		}
	
}

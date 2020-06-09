package com.appsdeveloperblog.app.ws.security;

public class SecurityConstants {
	public static long EXPIRATION_TIME = 864000000; // 10 days
	public static String TOKEN_PREFIX = "Bearer ";
	public static String HEADER_STRING = "Authorization";
	public static String SIGN_UP_URL = "/users";
	public static String TOKEN_SECRET = "jf9i4jgu83nfl0";
}

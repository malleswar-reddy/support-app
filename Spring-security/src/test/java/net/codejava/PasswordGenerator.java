package net.codejava;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "sub123";
		String encodedPassword = encoder.encode(rawPassword);
		
		/*System.out.println(encodedPassword);*/


		BCryptPasswordEncoder



	}

}

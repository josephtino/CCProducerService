/**
 * © 2024 JTino Inc. Author: Joseph Tino.
 * Redistribution permitted with attribution. Provided "as is" without warranty.
 * No liability for damages. See full license for details.
 */
package com.org.material;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableScheduling  // uncomment to  enable the scheduler in the application else go with controller

public class CCProducerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CCProducerServiceApplication.class, args);
	}

}

/**
 * © 2024 JT Inc. Author: Joseph Tino.
 * Redistribution permitted with attribution. Provided "as is" without warranty.
 * No liability for damages. See full license for details.
 */

package com.org.material.util;

import java.util.Random;

public class CCUtility {

    /**
     * Generate Dummy Credit card Number
     * @return
     */
    public static String generateCreditCardNumber() {
        Random random = new Random();
        StringBuilder creditCardNumber = new StringBuilder();

        // Generate a 16-digit credit card number
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            creditCardNumber.append(digit);
        }

        return creditCardNumber.toString();
    }
}

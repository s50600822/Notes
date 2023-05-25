package hoa.can.code.diff;

import static java.lang.Character.isLetter;
import static java.lang.Character.isLowerCase;

//https://leetcode.com/problems/strong-password-checker/description/

/**
 * A password is considered strong if the below conditions are all met:
 * <p>
 * It has at least 6 characters and at most 20 characters.
 * It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
 * It does not contain three repeating characters in a row (i.e., "Baaabb0" is weak, but "Baaba0" is strong).
 * Given a string password, return the minimum number of steps required to make password strong. if password is already strong, return 0.
 * <p>
 * In one step, you can:
 * <p>
 * Insert one character to password,
 * Delete one character from password, or
 * Replace one character of password with another character.
 */
public class StrongPasswordChecker {
    public int strongPasswordChecker(String password) {
        int threesomeStep = 0;
        int addstep = 0;
        int removestep = 0;

        int prev = -1;

        boolean lowerK = false;
        boolean upperK = false;


        if (password.length() < 6) {
            addstep = 6 - password.length();
        } else if (password.length() > 20) {
            removestep = password.length() - 20;
        }

        for (int i = 0; i < password.length(); i++) {
            prev = i - 1;
            char curChar = password.charAt(i);
            if (isLetter(curChar)) {
                if (isLowerCase(curChar)) {
                    lowerK = true;
                } else {
                    upperK = true;
                }
            }
            if (prev > -1 && i < password.length() - 1) {
                char prevChar = password.charAt(prev);
                char nextChar = password.charAt(i + 1);
                if (prevChar == curChar && curChar == nextChar) {
                    threesomeStep += 1;
                    i = i + 2;
                }
            }
        }
        return fix(addstep, removestep, threesomeStep, !lowerK, !upperK);
    }

    int fix(int addNeeded, int removeNeeded, int threesome, boolean needL, boolean needU) {
        if (addNeeded > 0) {
            // ot long enough
            if (addNeeded > 1) {
                // needL, needU doesn't matter
            } else {
                if((needL && needU)){
                    addNeeded += 1;
                }
            }

            // adding can neutralize threesomes
            // eg: aaa12 -> a3aa12
            if(addNeeded < threesome){
                addNeeded += Math.abs(threesome-addNeeded);
            }
            return addNeeded;
        }
        if (removeNeeded > 0){
            // removing can neutralize threesomes
            // eg: xxxbaaa12 -> xxxbaa12,
            // if the sequence is long, WHAT TO DO????
            // xxxbaaaaaaaaaaaa12
            // xxbA aaa aaa aaa aaa aaa12
            if(removeNeeded < threesome){
                removeNeeded += Math.abs(threesome-addNeeded);
            }
            if(needL) removeNeeded +=1;
            if(needU) removeNeeded +=1;
            return removeNeeded;
        }
        // good length, now deal with group of three and missing L or U case
        if(threesome > 1)
            return threesome;
        if(threesome == 1 && needL && needU)
            return threesome+1;

        return threesome;
    }
}

package org.wiztools.util.javadocjarviewer;

import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author subwiz
 */
public final class RandomUtil {
    // Do not allow outsiders to instantiate this class:
    private RandomUtil(){}

    private static final char[] CHARS = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    public static final int STRING_DEFAULT_LENGTH = 4;

    public static String getRandomStr(){
        return getRandomStr(STRING_DEFAULT_LENGTH);
    }

    public static String getRandomStr(int len){
        if(len < 1){
            throw new IllegalArgumentException("The parameter value should be greater than 0.");
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            Random r = new SecureRandom();
            int rand = r.nextInt(CHARS.length);
            sb.append(CHARS[rand]);
        }
        return sb.toString();
    }
}

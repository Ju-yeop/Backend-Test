package kr.co.kcp.backendcoding.work.global.util;

import java.security.SecureRandom;

public class RandomStringGenerator {
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomValue = random.nextInt(62); // 숫자 + 알파벳 총 개수
            if (randomValue <= 9) {
                sb.append((char) ('0' + randomValue));
            } else if (randomValue <= 35) {
                sb.append((char) ('A' + randomValue - 10));
            } else {
                sb.append((char) ('a' + randomValue - 36));
            }
        }
        return sb.toString();
    }
}

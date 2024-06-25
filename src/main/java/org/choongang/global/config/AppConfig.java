package org.choongang.global.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 사이트 설정 로드 및 조회
 *
 */
public class AppConfig {
    private final static ResourceBundle bundle;
    private final static Map<String, String> configs; // 설정들을 모두 MAP 형태로 가공해서 넣음
    static {
        // 환경 변수 mode에 따라 설정파일을 분리 예) prod이면 application-prod.properties로 읽어온다.
        // 각 pc마다 설정이 다를 수 있기 때문임
        String mode = System.getenv("mode");
        mode = mode == null || mode.isBlank() ? "":"-" + mode;

        bundle = ResourceBundle.getBundle("application" + mode);
        configs = new HashMap<>();
        Iterator<String> iter = bundle.getKeys().asIterator();
        while(iter.hasNext()) {
            String key = iter.next();
            String value = bundle.getString(key);
            configs.put(key, value);
        }
    }

    public static String get(String key) {
        return configs.get(key);
    } // 설정들을 key 값을 활용해 조회
}

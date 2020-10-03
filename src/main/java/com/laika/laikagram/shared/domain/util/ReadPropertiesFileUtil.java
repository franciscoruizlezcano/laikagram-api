package com.laika.laikagram.shared.domain.util;

import java.io.IOException;
import java.util.Properties;

public final class ReadPropertiesFileUtil {
    public static Properties readPropertiesFile(String fileName) throws IOException {
        Properties properties = new Properties();
        try {
            properties.load(ReadPropertiesFileUtil.class.getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

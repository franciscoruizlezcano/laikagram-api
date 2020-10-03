package com.laika.laikagram.shared.infrastructure.persistence.hibernate;

import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public final class HibernateConfigurationFactory {
    public Configuration create() {
        Configuration configuration = new Configuration();

        try {
            List<Resource> resources = searchMappingFiles();

            configuration.setProperties(hibernateProperties());

            for (Resource resource : resources) {
                configuration.addFile(resource.getFile().getCanonicalFile());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return configuration;
    }

    private List<Resource> searchMappingFiles() throws IOException {
        List<String> modules   = subdirectoriesFor();
        List<String> goodPaths = new ArrayList<>();

        for (String module : modules) {
            String[] files = mappingFilesIn(module + "/infrastructure/persistence/hibernate/");

            for (String file : files) {
                goodPaths.add(module + "/infrastructure/persistence/hibernate/" + file);
            }
        }

        return goodPaths.stream().map(FileSystemResource::new).collect(Collectors.toList());
    }

    private List<String> subdirectoriesFor() throws IOException {
        String[] packages = getSourcePackageName();
        String   path     = String.format("./src/main/java/%s/%s/%s/", packages[0], packages[1], packages[2]);

        String[] files = new File(path).list((current, name) -> new File(current, name).isDirectory());

        if (null == files) {
            path  = String.format("./main/%s/%s/%s/", packages[0], packages[1], packages[2]);
            files = new File(path).list((current, name) -> new File(current, name).isDirectory());
        }

        if (null == files) {
            return Collections.emptyList();
        }

        String finalPath = path;

        return Arrays.stream(files).map(file -> finalPath + file).collect(Collectors.toList());
    }

    private String[] getSourcePackageName() {
        String[] packages = this.getClass().getPackageName().split("\\.");
        return new String[]{packages[0], packages[1], packages[2]};
    }

    private String[] mappingFilesIn(String path) {
        String[] files = new File(path).list((current, name) -> new File(current, name).getName().contains(".hbm.xml"));

        if (null == files) {
            return new String[0];
        }

        return files;
    }

    private Properties hibernateProperties() {
        Dotenv dotenv = Dotenv.load();

        return new Properties() {{

            put(Environment.DRIVER, "org.postgresql.Driver");

            put(Environment.DIALECT, "org.hibernate.dialect.PostgresPlusDialect");

            put(Environment.URL, dotenv.get("DATABASE_URL"));

            put(Environment.USER, dotenv.get("DATABASE_USERNAME"));

            put(Environment.PASS, dotenv.get("DATABASE_PASSWORD"));

            put(Environment.HBM2DDL_AUTO, "update");

            put(Environment.SHOW_SQL, "true");
        }};
    }
}

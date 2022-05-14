package com.logistics.demo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

@Component

public class BootstrapData implements CommandLineRunner{
    @Autowired
    private DataSource dataSource;

    public void createDefaultDB(DataSource dataSource) {
        Resource resource = new ClassPathResource("schema-postgresql.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.execute(dataSource);
    }

    @Override
    public void run(String... args) throws Exception {
        createDefaultDB(dataSource);
    }

}

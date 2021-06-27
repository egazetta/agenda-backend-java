package br.com.simplenetwork.agenda.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.simplenetwork.agenda")
@ComponentScan(basePackages = "br.com.simplenetwork")
public class MongoConfiguration extends AbstractMongoClientConfiguration implements InitializingBean {

    //public String mongoUri = "mongodb://localhost:27017";
    public String mongoUri = "mongodb+srv://cluster0.vfh7a.mongodb.net/agenda?retryWrites=true&w=majority";

    //public String userName = "";

    //public String password = "";

    public String userName = "user_2";

    public String password = "Xp13sg13";

    public String database = "agenda";


    @Bean
    public MongoClient mongoClient() {
        final MongoClientSettings.Builder settingsBuilder = MongoClientSettings.builder().
                applyConnectionString(new ConnectionString(mongoUri));

        if (! this.userName.isEmpty()) {
            settingsBuilder.credential(MongoCredential.createCredential(userName, database, password.toCharArray()));
        }

        return MongoClients.create(settingsBuilder.build());
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Autowired
    @Lazy
    private MappingMongoConverter mappingMongoConverter;

    @Override
    public void afterPropertiesSet() throws Exception {
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        final MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(), database);

        return mongoTemplate;
    }


}

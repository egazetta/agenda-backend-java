package br.com.exemplo.agenda.configuration;

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
@EnableMongoRepositories(basePackages = "br.com.exemplo.agenda")
@ComponentScan(basePackages = "br.com.exemplo")
public class MongoConfiguration extends AbstractMongoClientConfiguration implements InitializingBean {

    
    //public String mongoUri = "mongodb://localhost:27017";
    public String mongoUri = "mongodb+srv://cluster0.vfh7a.mongodb.net/agenda?retryWrites=true&w=majority";

    //public String userName = "";

    //public String password = "";
    @Value("${mongo.user}")
    public String userName;

    @Value("${mongo.password}")
    public String password;

    @Value("${mongo.database}")
    public String database;


    /*
    @Bean
    public MongoClient mongoClient() {
        final MongoClientSettings.Builder settingsBuilder = MongoClientSettings.builder().
                applyConnectionString(new ConnectionString(mongoUri));

        //if (! this.userName.isEmpty()) {
            settingsBuilder.credential(MongoCredential.createCredential(userName, database, password.toCharArray()));
        //}

        return MongoClients.create(settingsBuilder.build());
    }
    */
    
    
    @Bean
    public MongoClient mongoClient() {
        //System.setProperty("jdk.tsl.trustNameService", "true");
        //MongoClient mongoClient = MongoClients.create(mongoUri);

        MongoClient mongoClient = MongoClients.create("mongodb+srv://"+userName+":"+password+"@cluster0.vfh7a.mongodb.net/"+database+"?retryWrites=true");
        //MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoUri));   

       // final MongoClientSettings.Builder settingsBuilder = MongoClientSettings.builder().
         //       applyConnectionString(new ConnectionString(mongoUri));

        //if (! this.userName.isEmpty()) {
        //    settingsBuilder.credential(MongoCredential.createCredential(userName, database, password.toCharArray()));
       // }

        return mongoClient;
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

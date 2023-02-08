package com.siddhi;

import com.siddhi.dao.BookReviewEntityDAO;
import com.siddhi.entity.BookReviewEntity;
import com.siddhi.resources.BookReviewResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;

public class HelloDropwizardApplication extends Application<HelloDropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloDropwizardApplication().run(args); //is the first method to be called on startup
    }

    @Override
    public String getName() {

        return "HelloDropwizard";
    }
//
//    @Override
//    public void initialize(final Bootstrap<HelloDropwizardConfiguration> bootstrap) {
        // TODO: application initialization
//    }

    @Override
    public void run(final HelloDropwizardConfiguration helloDropwizardConfiguration,
                    final Environment environment) {
        // TODO: implement application
        BookReviewEntityDAO bookReviewEntityDAO = new BookReviewEntityDAO(hibernateBundle.getSessionFactory());
        // getSessionFactory - As the name implies, the SessionFactory produces Hibernate Sessions. Without a session,
        // a developer can’t perform any create, update, retrieve or delete operations, which pretty much neuters the database layer
        environment.jersey().register(new BookReviewResource(bookReviewEntityDAO));//register resource
    }
    HibernateBundle<HelloDropwizardConfiguration> hibernateBundle=new HibernateBundle <HelloDropwizardConfiguration>(BookReviewEntity.class) {
    @Override
//  PooledDataSourceFactory- Interface of a factory that produces JDBC data sources backed by the connection pool
    public PooledDataSourceFactory getDataSourceFactory(HelloDropwizardConfiguration helloDropwizardConfiguration) {
        return helloDropwizardConfiguration.getDataSourceFactory();
    }
};


    @Override
    public void initialize(Bootstrap<HelloDropwizardConfiguration> bootstrap){

        bootstrap.addBundle(hibernateBundle);
    }

};

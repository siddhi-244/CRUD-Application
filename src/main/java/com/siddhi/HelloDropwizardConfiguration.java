package com.siddhi;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class HelloDropwizardConfiguration extends Configuration {
    // TODO: implement service configuration
    private DataSourceFactory dataSourceFactory;
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        if(Objects.isNull(dataSourceFactory))
            dataSourceFactory=new DataSourceFactory();
        return dataSourceFactory;
    }
    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }
};

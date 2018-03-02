package com.andyatkinson.helloworld;

import com.andyatkinson.helloworld.resources.ExampleFilter;
import io.dropwizard.Configuration;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ExampleBundle<T extends Configuration> implements ConfiguredBundle<T> {

    @Override
    public void run(T configuration, Environment environment) {

        // hook up ExampleFilter
        environment.jersey().register(new ExampleFilter());
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) {
    }
}

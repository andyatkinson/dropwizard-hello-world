# Hello World Dropwizard

## How to start the HelloWorld application

1. Run `mvn clean install`  and `mvn package` to build the "fat JAR"
1. Start application with `foreman start`
1. To check that your application is running enter url `http://localhost:5000`

Or Run/Debug from IntelliJ as an Application, default port is 8080, admin port is 8081 if using that option. Note that the `simple` config option doesn't support the admin connector stuff, and doesn't work on Heroku.


## Deploying to Heroku

1. `git push heroku master`

Visit `https://hello-world-dropwizard.herokuapp.com/hello-world?name=andy`


### Dropwizard Config Docs

  [Dropwizard Configuration](https://github.com/dropwizard/dropwizard/blob/master/docs/source/manual/configuration.rst)


### Dropwizard Bundles Intro presentation

  [Slides: Dropwizard Bundles](https://speakerdeck.com/andyatkinson/dropwizard-bundles)

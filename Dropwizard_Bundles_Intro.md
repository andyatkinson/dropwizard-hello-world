<!-- $theme: default -->

# Dropwizard Bundles

#### Definition

> A reusable bundle of functionality, used to define blocks of application behavior.

---

# How is it implemented?

Dropwizard defines a [Bundle](https://github.com/dropwizard/dropwizard/blob/master/dropwizard-core/src/main/java/io/dropwizard/Bundle.java) Interface (or `ConfiguredBundle`) with `initialize()` and `run()` methods.

The [Bootstrap](https://github.com/dropwizard/dropwizard/blob/master/dropwizard-core/src/main/java/io/dropwizard/setup/Bootstrap.java) class defines `addBundle()` which is used in the Dropwizard Application file to add the bundle.

---

# Dropwizard Internals

Dropwizard has core code, but is made up of many bundles!

Third-party bundles can also be found on github. In this presentation we'll start a bundle with a couple of classes.

E.g. Assets Bundle

---

# What can bundles do?

A Bundle is just a Java class, so there is limited functionality. It is mainly about creating a way to share code between Dropwizard apps.

Bundles do have access to the application config files via the application `Configuration` object in the `run()` method.

---

## Let's make a Bundle!

```
public class ExampleBundle<T extends Configuration>
	implements ConfiguredBundle<T> {

    @Override
    public void run(T configuration, Environment environment) {
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) {
    }
}
```

---

## How do I use `ExampleBundle`?

In your `Application` file, use the `addBundle()` method.

```
@Override
public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {

  // add the bundle
  bootstrap.addBundle(new ExampleBundle<>());
}
```

---

## More interesting

Cool cool, but let's make ExampleBundle do something more interesting.

#### Jersey filters

We can create a Jersey [Filter](https://jersey.github.io/documentation/latest/filters-and-interceptors.html) class, package it with our bundle, and work with HTTP requests. We could share this bundle with other Dropwizard apps!

```
public void run(T configuration, Environment environment) {

    environment.jersey().register(new ExampleFilter());
}
```

---

## Working with the request and response

Now that we have a Filter in place, we can work with cookies and headers here. We could read a custom header like `X-API-Version`.

In this example we'll add a custom response header `X-Powered-By`.

```
public class ExampleFilter
  implements ContainerResponseFilter {

public void filter(
  ContainerRequestContext requestContext,
  ContainerResponseContext responseContext
) throws IOException {

  responseContext.getHeaders().
  	add("X-Powered-By", "Jersey :)");
  }
}
```
---

# DEMO

---

## Dropwizard Bundles

https://github.com/dropwizard-bundles

* `dropwizard-redirect-bundle`
A simple bundle for Dropwizard that allows for HTTP redirects

* `dropwizard-version-bundle`
A Dropwizard bundle that exposes the version of your application via the admin port.

* `dropwizard-api-key-bundle`
A Dropwizard bundle that allows your service to be protected by API keys.


---

# That's it!

andyatkinson.com
andyatkinson@gmail.com

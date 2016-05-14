# circuit-breaker-playground

Just playing around and testing Netflix/Hystrix

## What?

Two deployables:

- api
- app

The `app` calls the `api`through Hystrix. And that's it.

Right now I'm playing with fallback and caching only. Nothing fancy.

## Running

Package:

```console
$ mvn clean install
```

Start the API:

```console
$ java -jar api/target/api-1.0-SNAPSHOT-swarm.jar
```

Start the App:

```console
$ java -jar app/target/app-1.0-SNAPSHOT-swarm.jar
```

## Notes

Right now, I'm just deploying the Hystrix Dashboard war together with Wildfly.

But, in the so called "real world", I would need to monitor streams for several servers,
not just only one.

To do that, apparently I should use Netflix/Turbine, which has also AWS server discovery
based on Eureka.

Also useful: https://github.com/ContaAzul/turbine-ec2

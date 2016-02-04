# circuit-breaker-playground

Just playing around and testing Netflix/Hystrix

## What?

Two deployables:

- api
- app

The `app` calls the `api`through Hystrix. And that's it.

Right now I'm playing with fallback and caching only. Nothing fancy.

> Tested on Wildfly 10

# circuit-breaker-playground

Just playing around and testing Netflix/Hystrix

## What?

Two deployables:

- api
- app

The `app` calls the `api`through Hystrix. And that's it.

Right now I'm playing with fallback and caching only. Nothing fancy.

> Tested on Wildfly 10

## Notes

Right now, I'm just deploying the Hystrix Dashboard war together with Wildfly.

But, in the so called "real world", I would need to monitor streams for several servers,
not just only one.

To do that, apparently I should use Netflix/Turbine, which has also AWS server discovery
based on Eureka.

Also useful: https://github.com/ContaAzul/turbine-ec2

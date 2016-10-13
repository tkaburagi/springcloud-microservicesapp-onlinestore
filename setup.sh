#!/bin/bash
cf create-service p-mysql 512mb mysql
cf create-service p-redis shared-vm session-replication
cf create-service p-config-server standard config-server
cf create-service p-service-registry standard service-registry
cf create-service p-circuit-breaker-dashboard standard circuit-breaker

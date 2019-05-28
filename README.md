# s4-extension-demo

This is a sample project generated using the [SAP Cloud SDK](https://blogs.sap.com/2017/05/10/first-steps-with-sap-s4hana-cloud-sdk/) maven archetype:
```
mvn archetype:generate -DarchetypeGroupId=com.sap.cloud.s4hana.archetypes -DarchetypeArtifactId=scp-cf-spring -DarchetypeVersion=RELEASE
```
Some steps required for getting things to run are described below:

## Configure Cloud Foundry Environment

The application requires an instance of the xsUAA service to enable authentication & authorization. 
Name the service `myxsuaa` and it will be bound automatically when pushed to Cloud Foundry, as configured in the `manifest.yml`

```
cf create-service xsuaa application my-xsuaa -c ./xs-security.json
```


## Set Up CI infrastructure

```
> ./cx-server start
```

Pulls Jenkins docker image and starts the instance for you. See  `server.cfg` for configuration options
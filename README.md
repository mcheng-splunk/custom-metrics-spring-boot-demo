
# This example demostrate how to send custom metrics using micrometer to Splunk Observability Cloud.



## Build the application
* ./gradlew build  


## To run

* Update the SPLUNK_TOKEN and SPLUNK_REALM field start-docker.sh file.
* Execute the start-docker.sh script
* Update the otel.resource.attributes and otel.service.name accordingly
* Execute the start.sh script

## Notes

* The pre-downloaded splunk-otel-java.jar binary version is  v1.5
* The application has Dsplunk.profiler.enabled turned ON
* v1.5 has some issue with Spring boot v2.5.6. Use Spring boot v2.3.4.RELEASE for the gradle build.
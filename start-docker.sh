docker run -d --rm --name collector -v "$(pwd)/collector.yaml":/etc/otel/config.yaml -p 4317:4317 -p 9943:9943 -e SPLUNK_TOKEN=<TOKEN> -e SPLUNK_REALM=us0 otel/opentelemetry-collector-contrib:0.36.0

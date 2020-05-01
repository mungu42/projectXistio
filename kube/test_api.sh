export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}')
export INGRESS_HOST=$(minikube ip)

curl -H api-type:google http://$INGRESS_HOST:$INGRESS_PORT/getAllStocks/AZ35ESNS50ESUG75
curl -H api-type:yahoo  http://$INGRESS_HOST:$INGRESS_PORT/getAllStocks/AZ35ESNS50ESUG75



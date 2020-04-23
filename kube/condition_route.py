import yaml
with open('routegateway.yml') as file:
    route_list = yaml.full_load(file)
inp = "google-api"
if route_list.http.match.header == inp :
    route_list['http']['match']['host'] == "google"
else:
    route_list['http']['match']['host'] == "yahoo"
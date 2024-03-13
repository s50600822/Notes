Check suitable version
```bash
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm search repo ingress-nginx --versions
```


Install
```bash
CHART_VERSION="4.10.0"
APP_VERSION="1.10.0"

helm template ingress-nginx ingress-nginx \
--repo https://kubernetes.github.io/ingress-nginx \
--version ${CHART_VERSION} \
--namespace ingress-nginx \
> ./nginx-ingress.${APP_VERSION}.yaml

kubectl apply -f ./nginx-ingress.${APP_VERSION}.yaml

kubectl -n ingress-nginx get pods

```


Should now see
```bash
kubectl -n ingress-nginx get pods

NAME                                        READY   STATUS              RESTARTS   AGE
ingress-nginx-admission-create-47sz6        0/1     Completed           0          44s
ingress-nginx-admission-patch-5862j         0/1     Completed           1          44s
ingress-nginx-controller-55474d95c5-6w42r   0/1     ContainerCreating   0          44s
```


deploy services

```bash
k apply -f ing-svc-a.yaml

# quick check by portforwarding
kubectl port-forward svc/service-a 8080:80

Forwarding from 127.0.0.1:8080 -> 80
Forwarding from [::1]:8080 -> 80
Handling connection for 8080
```



update `/etc/hosts` to point to local - required sudo
```bash
127.0.0.1 kubernetes.docker.internal
127.0.0.1 public.service-a.com
127.0.0.1 public.service-b.com
```

test the ingress
```bash
curl -ik https://public.service-a.com/path-a.html

HTTP/2 200
date: Wed, 13 Mar 2024 17:28:46 GMT
content-type: text/html
content-length: 28
last-modified: Wed, 13 Mar 2024 15:00:04 GMT
etag: "65f1bf74-1c"
accept-ranges: bytes
strict-transport-security: max-age=31536000; includeSubDomains

"/path-a.html" on service-a
```


Tailing ingress logs
```bash
k logs -f -n ingress-nginx ingress-nginx-controller-55474d95c5-6w42r

192.168.65.3 - - [13/Mar/2024:15:14:16 +0000] "GET /path-a.html HTTP/2.0" 200 28 "-" "curl/8.4.0" 44 0.001 [default-service-a-80] [] 10.1.0.62:80 28 0.001 200 099a66ec2835412b7cbfebdf37282d4b
```


- deploy more service
- route by domain
- SSL termination
- extra configs - via ConfigMap - https://kubernetes.github.io/ingress-nginx/user-guide/nginx-configuration/configmap
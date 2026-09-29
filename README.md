# Hotel Service Portal

## Experiment 10 — End-to-End DevOps Pipeline

A simple Java Servlet/JSP web application for submitting hotel service requests.

### Services
- Room Booking
- Room Service
- Housekeeping
- Restaurant Reservation

### Technology Stack
- HTML/CSS/JSP
- Java 21
- Jakarta Servlet 6.0
- Apache Tomcat 10.1
- Maven
- Git/GitHub
- Jenkins
- Docker
- Kubernetes/Minikube
- Nagios Core

### Pipeline
GitHub → Jenkins → Maven → Docker → Kubernetes → Hotel Service Portal → Nagios

## Build

```bash
mvn clean package
```

Generated WAR:

```text
target/hotel-service-portal.war
```

## Docker

```bash
docker build -t hotel-service-portal:1.1 .
docker run -d --name hotel-app -p 8081:8080 hotel-service-portal:1.1
```

Open `http://localhost:8081`.

## Kubernetes / Minikube

```bash
minikube start
eval $(minikube docker-env)
docker build -t hotel-service-portal:1.1 .
kubectl apply -f deployment.yaml
kubectl apply -f service.yaml
kubectl get pods
kubectl get service
minikube service hotel-service --url
```

Expected: two hotel pods in `Running` state and service port `30080`.

## Jenkins

Create a Jenkins job named `Hotel-CI`.

SCM: Git  
Branch: `*/main`  
Maven goal: `clean package`

Expected result:

```text
BUILD SUCCESS
Finished: SUCCESS
```

## Nagios

Monitor the HTTP endpoint using Nagios `check_http`.

Example service:

```text
define service {
    use                     generic-service
    host_name               hotel-server
    service_description     Hotel Service Portal
    check_command           check_http!-p 30080
}
```

Validate:

```bash
nagios -v /usr/local/nagios/etc/nagios.cfg
```

Expected:

```text
Total Warnings: 0
Total Errors: 0
```

## Application Flow

1. Open the Hotel Service Portal.
2. Select a service.
3. Enter customer name.
4. Enter contact number.
5. Submit.
6. The Java Servlet processes the request.
7. A confirmation page displays `Request Submitted Successfully!`.

## Viva

**GitHub:** Stores and versions source code.

**Jenkins:** Automates continuous integration and Maven builds.

**Maven:** Compiles the Java application and packages it as a WAR.

**Docker:** Packages the application and Tomcat runtime into a container.

**Kubernetes:** Deploys and manages two replicas of the application.

**Nagios:** Monitors application availability over HTTP.

**End-to-end DevOps pipeline:** Automates the software lifecycle from source code management through build, containerization, deployment and monitoring.

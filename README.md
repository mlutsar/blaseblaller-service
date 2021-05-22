# blaseblaller-service

A Spring Boot application for getting Blaseball data, processing it and exposing REST endpoints through which to get it.

Needs blaseblaller-api (https://github.com/mlutsar/blaseblaller-api) to work. As of right now the process is simple: download blaseblaller-api, build it with "mvn package", add the resulting .jar in this project.
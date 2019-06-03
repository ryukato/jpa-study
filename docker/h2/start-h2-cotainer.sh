#!/usr/bin/env bash
dir=$(pwd)
root_pass="test"
database="test"
docker run -d -p 1521:1521 -p 8082:81 -v $dir:/opt/h2-data --name=H2DB oscarfonts/h2
#!/usr/bin/env bash
dir=$(pwd)
root_pass="test"
database="test"
docker run --name mysql-5.7.26 -v $dir/conf/:/etc/mysql/conf.d \
-e MYSQL_ROOT_PASSWORD=$root_pass \
-e MYSQL_DATABASE=$database \
-p 3306:3306 \
-d mysql:5.7.26

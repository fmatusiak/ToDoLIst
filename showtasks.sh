#!/usr/bin/env bash

start_run_crud(){
./runcrud.sh
}

run_webrowser(){
/usr/bin/firefox "$1"
}

error(){
echo "Error compilation"
end
}

if start_run_crud ;then
run_webrowser "http://localhost:8080/crud/v1/task/getTasks"
else
error
fi

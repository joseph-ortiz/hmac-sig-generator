#! /bin/bash
# builds and runs the dockerfile as sig-gen 
docker build -t sig-gen . && docker run sig-gen

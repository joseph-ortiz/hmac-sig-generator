# Signature Generator

## About
This java class will generate a HMAC256 encoded string.

## Quick-Start
- Docker is installed

1. Update the secret key and body in the class file. 

2. Build the docker image

`
$ docker build -t sig-gen 
`

NOTE: if you make changes to the java file, you will need to rebuild the image by executing step 2.

3. Run the docker image.

`
$ docker run sig-gen 
`

4. The hmac256 encoded string and the request body before encryption will be printed to the console.

FROM java:7
COPY . /usr/
WORKDIR /usr/
RUN javac SignatureGenerator.java
CMD ["java", "SignatureGenerator"]

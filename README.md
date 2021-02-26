# **cardservice**
basic cardservice application that provides basic money transfer and adding
or deleting card for specific user

used mysql as database


### **how to run**

just use docker-compose :
`docker-compose up`

### **customizing**

if you want to change and customize it , after customization 
just build both projects using command :
`mvn package -Dmaven.test.skip=true` 

you can use docker-compose after that

### **notes**

this project doesn't have any payment provider to connect to. I handled this with exception handling


# Page Number Reducer (Printer)

Getting Started
=====================
# Required:
##### 1. Git (2.39.1)
##### 2. Java (11.0.12)
##### 3. Maven (3.9.2)
##### 4. Docker (20.10.17)

# Run commands:
##### git clone https://github.com/AlexeyKatomachin/PageNumbersReducer.git
##### mvn clean install
##### docker build --tag=printer:latest .
##### docker run -p8080:8080 printer:latest

# You can get API info:
##### http://localhost:8080/swagger-ui.html

# You can use API:
##### http://localhost:8080/printer/reducedPageNumbers?rawPageNumbers=1,3,32,5,11,7,6,19,2,21,4,8,22,23,33





# ABAS ERP

#### 1. Clone the repository:
    'git clone https://github.com/omerkincal/abas-erp.git'
    
#### 2. Ensure that MySQL are installed on your machine. 
**Do not forget to enter the password and username of your mysql server in the application.yml file.**
**Run the sql queries required to add the dummy data from inside the test folder.**
#### 3. If Maven is installed: 
**Open a terminal in the project directory and run:**
   'mvn spring-boot:run'
**Access the application through the browser at http://localhost:8080 after starting.**
#### 4. If Maven is not installed:
**Import the project into your preferred IDE (IntelliJ IDEA, Eclipse, etc.).**
**Run the main application file to start the application.
Access the application through the browser at http://localhost:8080 after starting.**

### API Endpoints

**Get**
**http://localhost:8080/orders/{orderId}**
**http://localhost:8080/products**
**Post**
**http://localhost:8080/products**

### Samples
![image](https://github.com/omerkincal/abas-erp/assets/96655512/9b865c0e-b9d6-4b28-a155-b6bf5462c608)

**   In this get request we are receiving products by orderId.**

![image](https://github.com/omerkincal/abas-erp/assets/96655512/2403810c-8f9f-42d9-bd98-286b50ecabc9)

**   In this post request we are sending product request to backend and receiving product response with it's unique id.**



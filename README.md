# irrigation

Irrigation Service
The Irrigation Service is a Spring Boot application that manages irrigation-related tasks and alerts. It provides APIs for managing plots, time slots, and sending alerts.

Prerequisites
Make sure you have the following installed on your machine:

Java Development Kit (JDK) 17 or later
PostgreSQL database server
Git
Getting Started
Clone the repository:

bash
Copy code
git clone https://github.com/asalah94/irrigation.git
Configure the database:

Open the application.yml file located in the src/main/resources directory.
Update the datasource section with your PostgreSQL database configuration, including the url, username, and password.
Save the changes.



Build the application:

cd irrigation-service
./gradlew build


Run the application:

./gradlew bootRun
The application will start running on http://localhost:8089/irrigation.

API Documentation
The API documentation is generated using Springdoc and can be accessed at http://localhost:8089/irrigation/swagger-ui.html.

Usage
You can use tools like Postman to interact with the API endpoints. Refer to the API documentation for details on the available endpoints and their usage.

Configuration
Additional configuration options can be found in the application.yml file. You can modify these options according to your requirements.

Troubleshooting
If you encounter any issues or errors, please check the following:

Ensure that the PostgreSQL database server is running and accessible.
Verify that the database connection details in the application.yml file are correct.
Check the application logs for any error messages or stack traces.


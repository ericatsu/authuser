# User Authentication and Email Expiration 

## AuthUser

AuthUser is a Spring Boot application that provides user registration and verification functionalities. It allows users to register, receive verification tokens via email, and activate their accounts to gain access to the application.

### Prerequisites
Before running the AuthUser application, ensure you have the following prerequisites installed on your system:

- Java 8 or higher
- Spring Boot 2.5.x
- MySQL or any other compatible relational database
- SMTP server configuration for sending verification emails
- Gradle or Maven (for building the application)
- Create and Update users, send email for verification and expiration

### Installation

1. Clone the repository from GitHub:
   $ git clone https://github.com/ericatsu/authuser.git

2. cd AuthUser
   $ cd authuser
   
Database

 $ cd C:\Program Files\MySQL\MySQL Server 8.0\bin
 $ mysql -u root -p
 $ create database registration_db;

## Features

- User Registration: Users can register with their first name, last name, email, and password.
- Email Verification: A verification token is sent via email upon registration, which the user can use to activate their account.
- Unique Email Validation: Prevents registration with an email that is already registered.
- Token Expiration: Verification tokens are valid for a specific duration to ensure security.
- User List Endpoint: Provides an API endpoint to fetch a list of all registered users.
  
## Contact
For any inquiries or issues related to the AuthUser application, please contact:

Email: ericatsu29@gmail.com
Twitter: https://twitter.com/ericKAatsu
LinkedIn: [LinkedIn](https://www.linkedin.com/in/eric-atsu-4065681b4/)

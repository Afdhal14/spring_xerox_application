# PrintHub – Online Print Order & Management System

PrintHub is a web-based application designed to streamline and digitize the print and photocopy ordering process. This system was developed to solve real-world challenges faced by students on campus, such as long queues, unclear order statuses, and communication issues with print service providers.

## Features

- **User Registration & Authentication**  
  Secure registration and login for students and sellers using JWT-based authentication.

- **Print Order Placement**  
  Users can place print orders by uploading documents (PDF supported), selecting print options, and submitting orders online.

- **Order Management & Tracking**  
  Users can track the status of their orders in real-time. Sellers can view and manage orders through a dedicated dashboard.

- **Automated Cost Calculation**  
  The system automatically calculates print costs based on document parameters and selected print options.

- **Secure File Handling**  
  Uploaded documents are securely stored in the database for easy access by sellers without physical file transfer.

## Technology Stack

- Backend: Java, Spring Boot, Spring Data JPA  
- Database: MySQL  
- Authentication: JWT (JSON Web Tokens)  
- Build Tool: Maven

## Getting Started

### Prerequisites

- Java 11 or higher  
- Maven  
- MySQL Server

### Setup Instructions

1. **Clone the repository**  
   ```bash
   git clone https://github.com/Afdhal14/spring_xerox_application.git
   cd spring_xerox_application


# Space News Application

## Overview

Space News Application is a modern platform that provides the latest news and articles about space. Based on a microservices architecture and integrating a chatbot assistant, this application offers a rich and interactive user experience for astronomy and space exploration enthusiasts.

## Table of Contents

- [Description](#description)
- [Features](#features)
- [Project Architecture](#project-architecture)
- [Microservices](#microservices)
- [API Gateway](#api-gateway)
- [Discovery Service (Eureka)](#discovery-service-eureka)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Contributors](#contributors)
- [License](#license)

## Description

The Space News application stands out for its modular and scalable design, allowing efficient feature management and easy extensibility. Leveraging modern technologies such as Spring Boot, Spring Cloud, PostgreSQL, and Docker, the application delivers optimal performance and simplified maintenance.

## Features

- User management and authentication (Login Microservice)
- Display of articles about space (Articles Microservice)
- Homepage with the latest news (Home Microservice)
- Community for discussions and interactions (Community Microservice)
- Chatbot assistant to answer user questions

## Project Architecture

The application is designed using a microservices architecture. The different microservices communicate with each other via an API Gateway (Spring Cloud Gateway) and are registered in the Eureka discovery service.

![Architecture Diagram](./docs/architecture-diagram.png)  <!-- Make sure to add an architecture diagram in the docs folder -->

## Microservices

### 1. Login Service
- **Description:** This service handles user registration, login, and management.
- **Features:**
  - Registration of a new user with information such as name, email, and password.
  - User authentication during login.
  - Management of user sessions and authentication tokens (JWT).

### 2. Articles Service
- **Description:** This service manages the management of articles related to space.
- **Features:**
  - Addition, deletion, and modification of articles by administrators.
  - Display of available articles for users.

### 3. Home Service
- **Description:** This service is responsible for displaying the latest news and articles on the homepage.
- **Features:**
  - Aggregation of the latest news and articles from various sources.
  - Display of news and articles on the homepage in an attractive and user-friendly manner.

### 4. Community Service
- **Description:** This service provides a platform for discussion and content sharing for users.
- **Features:**
  - Ability for users to publish their own blogs on space-related topics.
  - Viewing blogs published by other users.
  - Interaction with blogs by leaving comments and reactions.
  - Blog management by users, including editing and deleting their own blogs.

### Chatbot Assistant
- **Description:** This service provides a chatbot interface to answer user questions and provide assistance.
- **Features:**
  - Automatic response to common questions about space.
  - Personalized assistance based on user queries.
  - Integration with SAP Conversational AI for smooth interaction.

## API Gateway

- **Description:** Utilizes Spring Cloud Gateway to manage requests and route them to the appropriate microservices.
- **Port:** 8080

## Discovery Service (Eureka)

- **Description:** Eureka is used as a discovery and registration service for microservices. It allows dynamic discovery of microservice instances in a distributed environment.
- **Port:** 8761

## Installation

### Prerequisites

- Java 17
- Maven 3.8+
- Docker (optional for running services in containers)

### Installation Steps

1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-username/space-news-app.git
   cd space-news-app

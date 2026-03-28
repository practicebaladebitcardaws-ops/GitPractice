# Dockerized Python Login App

## Run with Docker
docker build -t login_app .
docker run -p 5000:5000 login_app

## Or with docker-compose
docker-compose up --build

## API Endpoint
POST /login
{
  "username": "admin",
  "password": "admin123"
}

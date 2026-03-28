FROM python:3.12-slim
ARG app
WORKDIR /$ARG
COPY . .
EXPOSE 5000
CMD ["python" , "main.py"]

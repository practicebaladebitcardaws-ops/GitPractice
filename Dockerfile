FROM python:3.12-slim
ARG app
WORKDIR /$ARG
RUN python -m venv myflask && \
source myflask/bin/activate   # Linux/macOS
COPY . .
EXPOSE 5000
CMD ["python" , "./app/main.py"]

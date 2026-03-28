from flask import Flask, request, jsonify
from auth.login import authenticate_user

app = Flask(__name__)

@app.route("/", methods=["GET"])
def home():
    return jsonify({"message": "Login API is running"})

@app.route("/login", methods=["POST"])
def login():
    data = request.json
    username = data.get("username")
    password = data.get("password")

    if authenticate_user(username, password):
        return jsonify({"status": "success", "message": "Login successful"})
    return jsonify({"status": "error", "message": "Invalid credentials"}), 401

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)

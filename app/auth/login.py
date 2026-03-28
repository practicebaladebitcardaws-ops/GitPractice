users = {
    "admin": "admin123",
    "user": "user123"
}

def authenticate_user(username, password):
    return username in users and users[username] == password

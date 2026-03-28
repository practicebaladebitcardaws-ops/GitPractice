require("dotenv").config();
const express = require("express");
const session = require("express-session");
const fs = require("fs").promises;
const path = require("path");

const PORT = process.env.PORT || 3000;
const SESSION_SECRET = process.env.SESSION_SECRET;

const app = express();

// Session storage (in memory / simple file)
const SESSIONS_FILE = path.join(__dirname, "sessions", "sessions.json");

// Sample in‑memory user (no DB)
const users = [
  { id: 1, username: "admin", password: "password123" },
  { id: 2, username: "alice",  password: "alice123" },
];

// Middleware
app.use(express.urlencoded({ extended: true }));
app.use(express.static("public")); // serve HTML/CSS/JS

app.use(
  session({
    secret: SESSION_SECRET,
    resave: false,
    saveUninitialized: false,
    cookie: { maxAge: 60 * 60 * 1000 }, // 1 hour
  })
);

// Logged‑in helper
function isLoggedIn(req, res, next) {
  if (req.session.user) {
    return next();
  }
  res.redirect("/login");
}

// ROOT route
app.get("/", (req, res) => {
  if (req.session.user) {
    return res.redirect("/dashboard");
  }
  res.sendFile(path.join(__dirname, "public", "index.html"));
});

// LOGIN view
app.get("/login", (req, res) => {
  if (req.session.user) {
    return res.redirect("/dashboard");
  }
  res.sendFile(path.join(__dirname, "public", "login.html"));
});

// LOGIN POST
app.post("/login", (req, res) => {
  const { username, password } = req.body;
  const user = users.find(
    u => u.username === username && u.password === password
  );
  if (user) {
    req.session.user = { id: user.id, username: user.username };
    res.redirect("/dashboard");
  } else {
    res.redirect("/login?error=invalid");
  }
});

// DASHBOARD (protected)
app.get("/dashboard", isLoggedIn, (req, res) => {
  res.sendFile(path.join(__dirname, "public", "dashboard.html"));
});

// LOGOUT
app.get("/logout", (req, res) => {
  req.session.destroy(err => {
    if (err) {
      console.error("Session destroy error:", err);
    }
    res.redirect("/");
  });
});

app.listen(PORT, () => {
  console.log(`Login server running on http://localhost:${PORT}`);
});
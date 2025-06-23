// JavaScript Code with SQL Injection Vulnerability
const express = require('express');
const app = express();
const mysql = require('mysql');
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'password',
  database: 'test'
});

app.get('/user', (req, res) => {
  const userId = req.query.id;
  connection.query(`SELECT * FROM users WHERE id = ${userId}`, (error, results) => {
    if (error) throw error;
    res.send(results);
  });
});

app.listen(3000, () => {
  console.log('Server is running on port 3000');
});

// JavaScript Code with Command Injection Vulnerability
const { exec } = require('child_process');
app.get('/exec', (req, res) => {
  const command = req.query.cmd;
  exec(command, (error, stdout, stderr) => {
    if (error) {
      res.send(`Error: ${error.message}`);
      return;
    }
    res.send(`Output: ${stdout}`);
  });
});

// JavaScript Code with Hardcoded Credentials
const hardcodedUser = 'admin';
const hardcodedPassword = 'password';
console.log(`Hardcoded credentials: ${hardcodedUser}, ${hardcodedPassword}`);

// JavaScript Code with Insecure Randomness
const crypto = require('crypto');
const insecureRandom = Math.random().toString(36).substring(2);
console.log(`Insecure random value: ${insecureRandom}`);

// JavaScript Code with Insecure Deserialization
const vm = require('vm');
app.get('/deserialize', (req, res) => {
  const code = req.query.code;
  vm.runInNewContext(code);
  res.send('Code executed');
});

// JavaScript Code with Deprecated API Usage
const fs = require('fs');
fs.exists('somefile.txt', (exists) => {
  console.log(`File exists: ${exists}`);
});

// JavaScript Code with Insecure Cookie Handling
app.get('/setcookie', (req, res) => {
  res.cookie('session', '12345', { httpOnly: false, secure: false });
  res.send('Cookie is set');
});

// JavaScript Code with Missing Input Validation
app.get('/greet', (req, res) => {
  const name = req.query.name;
  res.send(`Hello, ${name}!`);
});

// JavaScript Code with Exposure of Sensitive Data in Logs
app.post('/login', (req, res) => {
  const username = req.body.username;
  const password = req.body.password;
  console.log(`Login attempt: ${username}, ${password}`);
  res.send('Login attempt logged');
});

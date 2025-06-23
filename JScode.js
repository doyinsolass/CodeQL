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

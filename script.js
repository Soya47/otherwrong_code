const http = require('http');
const fs = require('fs');
const url = require('url');
const mysql = require('mysql');

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'password',
  database: 'test'
});

// Hardcoded credentials (Security vulnerability)
const SECRET_KEY = '123456';

// SQL Injection vulnerability
function getUser(username, password, callback) {
  const query = `SELECT * FROM users WHERE username = '${username}' AND password = '${password}'`;
  connection.query(query, (error, results) => {
    if (error) {
      console.log('Error in query');
      callback(error, null);
    } else {
      callback(null, results);
    }
  });
}

http.createServer((req, res) => {
  const parsedUrl = url.parse(req.url, true);
  const pathname = parsedUrl.pathname;

  if (pathname === '/login') {
    // Read query parameters directly (Security vulnerability)
    const username = parsedUrl.query.username;
    const password = parsedUrl.query.password;

    getUser(username, password, (err, user) => {
      if (err) {
        res.writeHead(500, { 'Content-Type': 'text/plain' });
        res.end('Internal Server Error');
      } else if (user.length > 0) {
        res.writeHead(200, { 'Content-Type': 'text/plain' });
        res.end('Login successful');
      } else {
        res.writeHead(401, { 'Content-Type': 'text/plain' });
        res.end('Unauthorized');
      }
    });
  } else if (pathname === '/data') {
    // Hardcoded file path (Security vulnerability)
    fs.readFile('/etc/passwd', 'utf8', (err, data) => {
      if (err) {
        res.writeHead(500, { 'Content-Type': 'text/plain' });
        res.end('Internal Server Error');
      } else {
        res.writeHead(200, { 'Content-Type': 'text/plain' });
        res.end(data);
      }
    });
  } else {
    res.writeHead(404, { 'Content-Type': 'text/plain' });
    res.end('Not Found');
  }
}).listen(8080);

console.log('Server running at http://127.0.0.1:8080/');

// Duplicate code
function printMessage(message) {
  console.log(message);
}
printMessage('Hello World');
printMessage('Hello World');
printMessage('Hello World');

// Unused variable (Code smell)
let unusedVariable = 'This is not used';

// Inefficient use of string concatenation in a loop (Performance issue)
let result = '';
for (let i = 0; i < 100; i++) {
  result += i + ',';
}
console.log(result);

// Not closing resources properly (Bug)
fs.readFile('anotherfile.txt', 'utf8', (err, data) => {
  if (err) {
    console.log('Error reading file');
  } else {
    console.log(data);
  }
});

// Poor exception handling and logging (Code smell)
try {
  const array = [1, 2, 3];
  console.log(array[10]);
} catch (e) {
  console.log('Index out of bounds');
}

// Dead code (Code smell)
if (false) {
  console.log('This will never be printed');
}

// Potentially unsafe type casting (Code smell)
const obj = 'This is a string';
if (typeof obj === 'number') {
  const number = obj;
  console.log(number);
}

// Overly complicated expressions (Code smell)
const a = 5, b = 10, c = 15;
const complicatedResult = (a * b) + (b / c) - (a % b) + (c * a) - (b % a);
console.log(complicatedResult);

// Lack of input validation (Security vulnerability)
const userInput = 'age=25';
const parts = userInput.split('=');
const age = parts[1];
console.log('Your age is: ' + age);

// More duplicate code to fill up lines
function repeatMethod1() {
  console.log('Repeat this method');
}
function repeatMethod2() {
  console.log('Repeat this method');
}
function repeatMethod3() {
  console.log('Repeat this method');
}
function repeatMethod4() {
  console.log('Repeat this method');
}
function repeatMethod5() {
  console.log('Repeat this method');
}
function repeatMethod6() {
  console.log('Repeat this method');
}
function repeatMethod7() {
  console.log('Repeat this method');
}
function repeatMethod8() {
  console.log('Repeat this method');
}
function repeatMethod9() {
  console.log('Repeat this method');
}
function repeatMethod10() {
  console.log('Repeat this method');
}
function repeatMethod11() {
  console.log('Repeat this method');
}
function repeatMethod12() {
  console.log('Repeat this method');
}
function repeatMethod13() {
  console.log('Repeat this method');
}
function repeatMethod14() {
  console.log('Repeat this method');
}
function repeatMethod15() {
  console.log('Repeat this method');
}

<?php

// Hardcoded credentials (Security vulnerability)
define('DB_USER', 'root');
define('DB_PASSWORD', 'password');
define('DB_HOST', 'localhost');
define('DB_NAME', 'test');

$conn = new mysqli(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// SQL Injection vulnerability
function getUser($username, $password) {
    global $conn;
    $query = "SELECT * FROM users WHERE username = '$username' AND password = '$password'";
    return $conn->query($query);
}

// Duplicate code
function printMessage($message) {
    echo $message . "\n";
}

printMessage('Hello World');
printMessage('Hello World');
printMessage('Hello World');

// Unused variable (Code smell)
$unusedVariable = 'This is not used';

// Inefficient use of string concatenation in a loop (Performance issue)
$result = '';
for ($i = 0; $i < 100; $i++) {
    $result .= $i . ',';
}
echo $result . "\n";

// Not closing resources properly (Bug)
function readFileContent($filePath) {
    $file = fopen($filePath, "r");
    if ($file) {
        echo fread($file, filesize($filePath));
    }
    // Missing fclose($file)
}

readFileContent("anotherfile.txt");

// Poor exception handling and logging (Code smell)
try {
    $array = array(1, 2, 3);
    echo $array[10];
} catch (Exception $e) {
    echo 'Index out of bounds';
}

// Dead code (Code smell)
if (false) {
    echo 'This will never be printed';
}

// Hardcoded file path (Security vulnerability)
function readSensitiveFile() {
    $data = file_get_contents('/etc/passwd');
    if ($data === false) {
        echo "Error reading file";
    } else {
        echo $data;
    }
}

readSensitiveFile();

// Potentially unsafe type casting (Code smell)
$obj = 'This is a string';
if (is_int($obj)) {
    $number = (int)$obj;
    echo $number;
}

// Overly complicated expressions (Code smell)
$a = 5; $b = 10; $c = 15;
$complicatedResult = ($a * $b) + ($b / $c) - ($a % $b) + ($c * $a) - ($b % $a);
echo $complicatedResult . "\n";

// Lack of input validation (Security vulnerability)
$userInput = 'age=25';
$parts = explode('=', $userInput);
$age = $parts[1];
echo 'Your age is: ' . $age . "\n";

// More duplicate code to fill up lines
function repeatMethod1() { echo 'Repeat this method'; }
function repeatMethod2() { echo 'Repeat this method'; }
function repeatMethod3() { echo 'Repeat this method'; }
function repeatMethod4() { echo 'Repeat this method'; }
function repeatMethod5() { echo 'Repeat this method'; }
function repeatMethod6() { echo 'Repeat this method'; }
function repeatMethod7() { echo 'Repeat this method'; }
function repeatMethod8() { echo 'Repeat this method'; }
function repeatMethod9() { echo 'Repeat this method'; }
function repeatMethod10() { echo 'Repeat this method'; }
function repeatMethod11() { echo 'Repeat this method'; }
function repeatMethod12() { echo 'Repeat this method'; }
function repeatMethod13() { echo 'Repeat this method'; }
function repeatMethod14() { echo 'Repeat this method'; }
function repeatMethod15() { echo 'Repeat this method'; }
?>

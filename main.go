package main

import (
	"database/sql"
	"fmt"
	"io/ioutil"
	"net/http"
	"os"

	_ "github.com/go-sql-driver/mysql"
)

// Hardcoded credentials (Security vulnerability)
const SECRET_KEY = "123456"

func getUser(db *sql.DB, username, password string) (*sql.Rows, error) {
	// SQL Injection vulnerability
	query := fmt.Sprintf("SELECT * FROM users WHERE username='%s' AND password='%s'", username, password)
	return db.Query(query)
}

func handler(w http.ResponseWriter, r *http.Request) {
	db, err := sql.Open("mysql", "root:password@tcp(localhost:3306)/test")
	if err != nil {
		http.Error(w, "Internal Server Error", http.StatusInternalServerError)
		return
	}
	defer db.Close()

	if r.URL.Path == "/login" {
		// Read query parameters directly (Security vulnerability)
		username := r.URL.Query().Get("username")
		password := r.URL.Query().Get("password")

		rows, err := getUser(db, username, password)
		if err != nil {
			http.Error(w, "Internal Server Error", http.StatusInternalServerError)
			return
		}
		defer rows.Close()

		if rows.Next() {
			fmt.Fprintln(w, "Login successful")
		} else {
			http.Error(w, "Unauthorized", http.StatusUnauthorized)
		}
	} else if r.URL.Path == "/data" {
		// Hardcoded file path (Security vulnerability)
		data, err := ioutil.ReadFile("/etc/passwd")
		if err != nil {
			http.Error(w, "Internal Server Error", http.StatusInternalServerError)
			return
		}
		w.Write(data)
	} else {
		http.Error(w, "Not Found", http.StatusNotFound)
	}
}

func main() {
	http.HandleFunc("/", handler)
	http.ListenAndServe(":8080", nil)
}

// Duplicate code
func printMessage(message string) {
	fmt.Println(message)
}

func main2() {
	printMessage("Hello World")
	printMessage("Hello World")
	printMessage("Hello World")
}

// Unused variable (Code smell)
var unusedVariable = "This is not used"

// Inefficient use of string concatenation in a loop (Performance issue)
func inefficientStringConcat() {
	var result string
	for i := 0; i < 100; i++ {
		result += fmt.Sprintf("%d,", i)
	}
	fmt.Println(result)
}

// Not closing resources properly (Bug)
func readFile() {
	file, err := os.Open("anotherfile.txt")
	if err != nil {
		fmt.Println("Error reading file")
		return
	}
	defer file.Close()
	data, err := ioutil.ReadAll(file)
	if err != nil {
		fmt.Println("Error reading file")
		return
	}
	fmt.Println(string(data))
}

// Poor exception handling and logging (Code smell)
func accessArray() {
	defer func() {
		if r := recover(); r != nil {
			fmt.Println("Index out of bounds")
		}
	}()
	var array [3]int
	fmt.Println(array[10])
}

// Dead code (Code smell)
func deadCode() {
	if false {
		fmt.Println("This will never be printed")
	}
}

// Overly complicated expressions (Code smell)
func complicatedExpressions() {
	a, b, c := 5, 10, 15
	complicatedResult := (a * b) + (b / c) - (a % b) + (c * a) - (b % a)
	fmt.Println(complicatedResult)
}

// Lack of input validation (Security vulnerability)
func lackOfInputValidation() {
	userInput := "age=25"
	parts := make([]string, 2)
	copy(parts, []string{"age", "25"})
	age := parts[1]
	fmt.Println("Your age is: " + age)
}

// More duplicate code to fill up lines
func repeatMethod1() {
	fmt.Println("Repeat this method")
}

func repeatMethod2() {
	fmt.Println("Repeat this method")
}

func repeatMethod3() {
	fmt.Println("Repeat this method")
}

func repeatMethod4() {
	fmt.Println("Repeat this method")
}

func repeatMethod5() {
	fmt.Println("Repeat this method")
}

func repeatMethod6() {
	fmt.Println("Repeat this method")
}

func repeatMethod7() {
	fmt.Println("Repeat this method")
}

func repeatMethod8() {
	fmt.Println("Repeat this method")
}

func repeatMethod9() {
	fmt.Println("Repeat this method")
}

func repeatMethod10() {
	fmt.Println("Repeat this method")
}

func repeatMethod11() {
	fmt.Println("Repeat this method")
}

func repeatMethod12() {
	fmt.Println("Repeat this method")
}

func repeatMethod13() {
	fmt.Println("Repeat this method")
}

func repeatMethod14() {
	fmt.Println("Repeat this method")
}

func repeatMethod15() {
	fmt.Println("Repeat this method")
}

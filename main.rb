require 'sinatra'
require 'mysql2'

# Hardcoded credentials (Security vulnerability)
DB_HOST = 'localhost'
DB_USER = 'root'
DB_PASSWORD = 'password'
DB_NAME = 'test'

# SQL Injection vulnerability
def get_user(username, password)
  client = Mysql2::Client.new(host: DB_HOST, username: DB_USER, password: DB_PASSWORD, database: DB_NAME)
  query = "SELECT * FROM users WHERE username = '#{username}' AND password = '#{password}'"
  result = client.query(query)
  result.count > 0
end

get '/login' do
  # Read query parameters directly (Security vulnerability)
  username = params['username']
  password = params['password']

  if get_user(username, password)
    'Login successful'
  else
    'Unauthorized'
  end
end

get '/data' do
  # Hardcoded file path (Security vulnerability)
  File.read('/etc/passwd')
end

# Duplicate code
def print_message(message)
  puts message
end

print_message('Hello World')
print_message('Hello World')
print_message('Hello World')

# Unused variable (Code smell)
unused_variable = 'This is not used'

# Inefficient use of string concatenation in a loop (Performance issue)
result = ''
100.times do |i|
  result += "#{i},"
end
puts result

# Not closing resources properly (Bug)
begin
  file = File.open('anotherfile.txt', 'r')
  puts file.read
ensure
  # Missing file.close()
end

# Poor exception handling and logging (Code smell)
begin
  array = [1, 2, 3]
  puts array[10]
rescue StandardError => e
  puts 'Index out of bounds'
end

# Dead code (Code smell)
if false
  puts 'This will never be printed'
end

# Potentially unsafe type casting (Code smell)
obj = 'This is a string'
if obj.is_a? Integer
  number = obj.to_i
  puts number
end

# Overly complicated expressions (Code smell)
a = 5
b = 10
c = 15
complicated_result = (a * b) + (b / c) - (a % b) + (c * a) - (b % a)
puts complicated_result

# Lack of input validation (Security vulnerability)
user_input = 'age=25'
parts = user_input.split('=')
age = parts[1]
puts "Your age is: #{age}"

# More duplicate code to fill up lines
def repeat_method
  puts 'Repeat this method'
end

15.times { repeat_method }

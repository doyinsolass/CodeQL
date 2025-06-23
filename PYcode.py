// Python Code with Hardcoded Credentials
import mysql.connector

def get_user(user_id):
    connection = mysql.connector.connect(
        host='localhost',
        user='root',
        password='password',
        database='test'
    )
    cursor = connection.cursor()
    cursor.execute(f"SELECT * FROM users WHERE id = {user_id}")
    result = cursor.fetchall()
    connection.close()
    return result

# Python Code with Use of Insecure Functions
import os

def execute_command(command):
    os.system(command)

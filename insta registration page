from flask import Flask, render_template_string, request, redirect, url_for

app = Flask(__name__)

# HTML template for the registration page
registration_html = """
<!DOCTYPE html>
<html>
<head>
    <title>Instagram Registration</title>
    <style>
        body { 
            font-family: Arial, sans-serif; 
            background-color: #fafafa; 
            display: flex; 
            justify-content: center; 
            align-items: center; 
            height: 100vh; 
        }
        .container {
            background: white; 
            padding: 30px 40px; 
            border-radius: 8px; 
            box-shadow: 0 4px 12px rgba(0,0,0,0.08); 
            width: 330px;
        }
        h2 {
            text-align: center;
            font-family: 'Billabong', cursive;
            font-size: 2.5em;
            margin-bottom: 20px;
            color: #262626;
            letter-spacing: 2px;
        }
        form input {
            width: 100%; 
            padding: 10px 12px; 
            margin: 8px 0; 
            border: 1px solid #dbdbdb; 
            border-radius: 4px;
            background: #fafafa;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #3897f0;
            color: white;
            border: none;
            border-radius: 4px;
            font-weight: bold;
            margin-top: 12px;
            cursor: pointer;
        }
        button:hover {
            background-color: #2878c7;
        }
        .msg {
            margin-top: 10px;
            color: green;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Instagram</h2>
        <form method="POST">
            <input type="text" name="username" placeholder="Username" required>
            <input type="email" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Sign Up</button>
        </form>
        {% if message %}
        <div class="msg">{{ message }}</div>
        {% endif %}
    </div>
</body>
</html>
"""

@app.route('/', methods=['GET', 'POST'])
def register():
    message = ""
    if request.method == 'POST':
        username = request.form.get('username')
        email = request.form.get('email')
        password = request.form.get('password')
        # In a real app, you'd save these details to a database
        message = f"Thanks for registering, {username}!"
    return render_template_string(registration_html, message=message)

if __name__ == "__main__":
    app.run(debug=True)

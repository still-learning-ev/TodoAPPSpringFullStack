<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css
"
	rel="stylesheet">
<title>Login Page</title>
</head>
<body>
	<div class="container">
		<pre>${errorMessage}</pre>
		<h1>Welcome to login page</h1>
		

		<form method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Name</label> 
				<input type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="name"/>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" class="form-control"
					id="exampleInputPassword1" name="password"/>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>
<script type="text/javascript"
		src="webjars/bootstrap/5.2.3/js/bootstrap.min.js
"></script>
	<script type="text/javascript"
		src="webjars/jquery/3.6.3/jquery.min.js
"></script>
</body>
</html>
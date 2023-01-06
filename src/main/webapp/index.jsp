<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style.css" />
<title>This is a title</title>
</head>
<body>

	<h1>Hello World</h1>
	<h2>Hello World</h2>
	<h3>Hello World</h3>
	<h4>Hello World</h4>
	<h5>Hello World</h5>
	<h6>Hello World</h6>
	
	<p>
				<p><strong>Pellentesque habitant morbi tristique</strong> senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. <em>Aenean ultricies mi vitae est.</em> Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, <code>commodo vitae</code>, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. <a href="#">Donec non enim</a> in turpis pulvinar facilisis. Ut felis.</p>

				<!-- <h2>Header Level 2</h2>

				<ol>
				   <li>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</li>
				   <li>Aliquam tincidunt mauris eu risus.</li>
				</ol>

				<blockquote><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue. Ut a est eget ligula molestie gravida. Curabitur massa. Donec eleifend, libero at sagittis mollis, tellus est malesuada tellus, at luctus turpis elit sit amet quam. Vivamus pretium ornare est.</p></blockquote>

				<h3>Header Level 3</h3>

				<ul>
				   <li>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</li>
				   <li>Aliquam tincidunt mauris eu risus.</li>
				</ul>

				<pre><code>
				#header h1 a {
				  display: block;
				  width: 300px;
				  height: 80px;
				}
				</code></pre> -->
				
				<pre>
				some random Quote
									This is something that should be displayed as it is.
					Next line starts here.
					Another line here                  . Here
				
				</pre>
				<p>
				<i>Paragraph</i>
					The temperatue 10<sup>o</sup>C. H<sub>2</sub>0 
					This is something that should be displayed as it is.
					Next line starts here.
					Another line here                  . Here
				
				</p>
				
				<ul>
					<li>Apple</li>
					<li>Ball</li>
					<li>Cat</li>
				</ul>
				
				<ol>
					<li>Apple</li>
					<li>Ball</li>
					<li>Cat</li>
				</ol>
	
	</p>
	
	
	<a href="style.css" title="Loads Css File">Style</a>
	<a href="https://google.com" title="Forwards to Google Search">Google</a>
	<hr />
	<video src="https://www.youtube.com/watch?v=HDC-L0Zuu_A" type="video/mp4" ></video>
	<video src="https://www.youtube.com/watch?v=HDC-L0Zuu_A" ></video>
	
	<img src="https://picsum.photos/id/237/200/300" />
	<iframe src="https://google.com" height="500" width="500"></iframe>
	
	<table border="1">
		<tr>
			<th>SN</th>
			<th>Name</th>
			<th>Roll</th>
		</tr>
		<tr>
			<td>1</td>
			<td>Dipak</td>
			<td>10</td>
		</tr>
		<tr>
			<td>2</td>
			<td>Dipak</td>
			<td>10</td>
		</tr>
		<tr>
			<td>3</td>
			<td>Dipak</td>
			<td>10</td>
		</tr>
		<tr>
			<td>4</td>
			<td>Dipak</td>
			<td>10</td>
		</tr>
	</table>
	
	<form action="something">
	<label for="username">Username::</label>
		<input type="text" name="username" placeholder="Enter Username" > <br/>
		
		<label for="password">Password::</label>
		<input type="password" name="password"  placeholder="Enter Password">

		
		<%
		for(int i=0; i<5; i++) {
		out.print("Hello World");
%>
		
			<input type="submit" value="Submit" name="Submit">
		
		<% } %>
		<button>Submit</button>
	
	
	</form>
	
	
</body>
<footer>
	This is a footer
</footer>
</html>
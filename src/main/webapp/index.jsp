<html>
<head>
<title>REST Web Service</title>
</head>
<body>
    <h2>Jersey RESTful Web Service</h2>
    <hr>
    <pre>
    	<b>Q: How to access any resource in this web service?</b>
    	A: <i>http://[server-name/ip]:[server-port]/restjersey/webapi/[resource-name]</i> 
    	
    	<b>Q: What are the resource names?</b>
    	A: <i>Resource Names: student</i>
    
    	<b>Student REST URLs</b>
    	
    		Get All Student					: 	<i>http://[server-name/ip]:[server-port]/restjersey/webapi/students</i>
    		Get One Student					: 	<i>http://[server-name/ip]:[server-port]/restjersey/webapi/student/[UID]</i>
    		Create/Update A Student Record	:  	<i>http://[server-name/ip]:[server-port]/restjersey/webapi/student/</i>
    		Delete a Student Record			:  	<i>http://[server-name/ip]:[server-port]/restjersey/webapi/student/[UID]</i>
    	
    	<b>Student Table</b>
    		 Columns:
    			uId			varchar(20)		NOT NULL	PRIMARY KEY
    			firstName	varchar(30)		NOT NULL
    			middleName	varchar(30)				
    			lastName	varchar(30)		NOT NULL
    			gender		varchar(1)		NOT NULL
    			deptId		varchar(10)		NOT NULL
    			level		varchar(1)		NOT NULL
    			degId		varchar(10)		NOT NULL
    	
    </pre>
    
</body>
</html>

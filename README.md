Week-1 Blog Application


Lab 1 | Sign Up and Sign In

Objective: 
To understand the basic step of all web applications i.e Sign Up and Sign In. Whether you're posting posts with Facebook, or  uploading tweets in Twitter or, searching products in Amazon, or buying clothes in Myntra, you must create an acccount first and then sign in to the system to work in the system.

Let us try and complete these labs today.


Requirements:
Fork this repo
Clone this repo

Setting up the Environment:
Open Eclipse -> Click File -> Import -> From the Import Dialog box -> Select General -> Existing Project into Workspace.

Common Errors and Bug Fixes.
Right Click on the project -> Click build path and then click configure build path -> Select the libraries tab and see if JRE system library is throwing an error.

If it is throwing error. Kindly click on the jar and select remove. Once it is removed, click add library -> JRE System Library -> Click next -> then see if workspace default JRE [jre1.8.X_XXX] is selected and click finish.

Right click on the application -> select properties -> Select Targeted Runtimes -> Check if server is configured to Apache Tomcat v9.0 or Apache Tomcat v9.5.

If there is no server present in the Targeted Runtimes window, click New -> Now select Apache folder -> from the list of Apache Tomcat server select Apache Tomcat v9.0 or v9.5 and then select tomcat installation directory. Select the location of your tomcat server directory and click finish.

Database Configuration:
Go to src->com.prograd.blogapp.utils -> Click JDBC utils and change the jdbcPassword according to your mysql server password.

Voila! you are ready to go.

Click on the project and select Run on Server. If everything is right then your application starts smoothly.


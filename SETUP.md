# Setup your Environment
1. Remember to add the mysql connector to your referenced Library

2. Add the JUnit Testing Library to your referenced Library
  - To add the JUnit Testing Library to your referenced Library, go to the Testing Tab and Click the Enable JUnit Testing which will download the JUnit Testing Library
  N/B: You don't have to write tests if you do not know how to write tests but if you are interested in learning how to write tests, check Youtube and then you can write tests for your class

3. Create a db.properties file to store your jdbc credentials
> db.properties
> ```properties
>driverClassName = com.mysql.cj.jdbc.Driver
>jdbc:mysql://localhost:3306/financetracker
>username = your_username_here
>password = your_password_here
>```

>Load your credentials in your code like this:
>```java
>Properties mySql = new Properties();
>try (FileReader in = new FileReader("db.properties")) {
>    mySql.load(in);
>} catch (IOException e) {
>    System.out.println("Error loading db.properties from classpath." + e);
>}
>String username = mySql.getProperty("username");
>String password = mySql.getProperty("password");        
>String url = mySql.getProperty("url");
>// Connection Implementation
>```

4. Make sure you run the sql files in the `db` directory to have the most recent database changes

# synack-lounge
Crud App using **_basic_** functionality to include Java Servlets, JSP, JSTL, JPA, and Java Mail. No Frameworks.

This app is intended to focus on the fundamental technology that is used under big frameworks suchs as Spring, ThymLeaf, and Hibernate. 


## Initial Instructions

In order to run this app you will need to have the following installed:
  - MySql
  - Maven

Once you have cloned the reposityory to your local device, you must open the project and update the following files:
  - com.aviles.util.MailUtil.java
    - In this class you will find lines 38 and 39 where you must enter in your gmail credentials to access Gmail server when using Java Mail functionality within the app.
        ```
        String email = "YOUR GMAIL USERNAME";
        String password = "YOUR GMAIL PASSWORD";
        ```
  - resources/META-INF/persistence.xml
    - Here you will need to update the Mysql user and password that will be able to access your local MySql server 
        ```
        <properties>
                <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
                <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/final-project?useSSL=false" />
                <property name="javax.persistence.jdbc.user" value="USERNAME" />
                <property name="javax.persistence.jdbc.password" value="PASSWORD" />
            </properties>
        ```
Lastly, prior to running the app you will need to download, open, and run the finalproject.sql in the root directory of this folder to build out the same database structure that is being used in the app.

SONAR
=====


Sonar is a tool which can present results of tests on browser. In other worlds it is web application
which presents results of tests (mainly JUnit tests and coverage).



INSTALLING AND RUNNING
----------------------

To install and run Sonar you have to just:
- go to Sonar download page and downolad package with Sonar: http://www.sonarqube.org/downloads/
- unpack package;
- go to folder "bin/<your_system>" and run file StartSonar.bat/StartSonar.sh (for instance: "bin/windows-x86-64/StartSonar.bat"



USAGE
----

To use Sonar you have to:
- run Maven command: 		mvn clean install sonar:sonar
- type in browser: 			http://localhost:9000/



SONAR AND JS
------------

To check js by using Sonar you have to add Java Script plugin to Sonar. To do it you have to:
- log in to Sonar (default credentials: admin/admin);
- go to 'Settings -> Update Center' and add JavaScript plugin;
- restart Sonar;
- in code you have to define: <sonar.language>js</sonar.language>	
- in code you can also define source and exclude from checking external js libraries.



SONAR AND MODULES
-----------------

In Sonar there is also possibility to use modules. Project can be devided for parts 
(for instance: java and js). Results will be presented together but user can also
see them separatly by using 'Tools -> Components".
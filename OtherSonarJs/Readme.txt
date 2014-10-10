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
OTHERXMLEDITOR


This project is Java standalone project (Java Swing). It enables working with xml files:
- create new file;
- import file;
- edit xml (create, update, delete, read);
- validate xml by xsd file;
- save xml to file.



---



BUILD PROJECT

To building project you have to go to location <project_home>, run Maven console
and use Maven command:

mvn clean install



---



RUN PROJECT


To run project you have to first build project and then 
go to location <project_home>/target and:

- double click on file "OtherXmlEditor.jar"

or

- in console type command: "java -jar OtherXmlEditor.jar"



---



XML TEMPLATE

Xml template is created by using Csv and Velocity.

1. Csv
Csv (ang. Coma Separated Values) is file with values which are
separated by coma. These values are stored in rows. First
row is header with names of these values. 

2. Velocity
Velocity is a tool which enables creating some file basing
on template. Template file has extension *.vm.

3. Usage
To use xml template you have to have csv file with header
and values. For instance header can look like this: "name",
"surname".
In Velocity template you can use $valuesList which contains 
$values. $values is single row from csv file. You can
get some value from this row using name of header. For 
instance: $values.get("name")  
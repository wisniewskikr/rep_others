MAVEN ASSEMBLY PLUGIN

You can use maven assembly plugin for create package file
(for instance *.zip file). You can create this file
using Maven.

Maven assembly plugin works in such way that you indicate
in POM file to assembly descriptor (*.xml file). In this
descriptor you organizes your package. You indicate here
what should be included and what should be excluded from
package. You indicate also location of elements inside
package.

If you want to create such file you just call Maven command:
mvn clean install
and package file witll be created near Maven *.jar or *.war file.
MAVEN-RELEASE-PLUGIN



You can use this plugin when you want to do automatically
release your SNAPSHOT project to SVN. This version will
be increased to next SNAPSHOT version by maven-release-plugin. 
For instance from 0.0.1-SNAPSHOT to 0.0.2-SHAPSHOT. All changes
will be commited and new tag will be created.
	You can also get previous version without SNAPSHOT from
SVN.
	To use this plagin you have to fulfull two conditions:
- version has to have SNAPSHOT;
- there can not be any not commited change in project
- there can not be any Snapshot in project dependencies. You can
skip this by settitn parameter: allowTimestampedSnapshots=false	

In other ways it is the same as:
- create tag of project;
- increase version;
- check in version;
- check out tag from repository and build.

So this plugin is basically very useful for increasing version 
and tag description in repository.

 
Maven-realease-plugin is used mainly with two commends:
1. Mvn release:prepare -Dusername= -Dpassword=
2. Mvn release:perform -Dusername= -Dpassword=



Ad 1\ Mvn release:prepare -Dusername= -Dpassword=
Here you are asked about version, which should be commited
to SVN and about version of next SNAPSHOT. Mainly you should
accept default answers. Then new tag will be created in
SVN and version of SNAPSHOT will be increased.
	After all new files with suffix .backup will be
created. They are used in next stage.



Ad 2\ Mvn release:perform -Dusername= -Dpassword=
Here you can automatically get from SVN previous version
of project without SNAPSHOT. For instance if you have now
0.0.2-SNAPSHOT after this command you get package (jar, war etc.)
with version 0.0.1.
	Here <distributionManagement> is necessery which points,
where package should be build.



ATTENTION!!!
<distributionManagement> has to exists from beginning, from
stage release:prepere. It can not be add only in stage
release:perform. You will still get message that there is no
<distributionManagement>. 

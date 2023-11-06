# CECS343GroupProject: Restaurant Automation

## Installing Apache Server
### Windows
1. Download from https://www.apachehaus.com/cgi-bin/download.plx
2. Place somewhere on your pc (Directly in C:/ is probably best)
3. Edit ```conf/httpd.conf``` file in your apache install (not the one in this project) and change the path in ```Define SRVROOT "..."``` to where you installed apache
   
## Running the Apache Server
### Windows
1. Navigate to ```frontend/```
2. Run the ```run.bat``` file in your terminal
### Other
1. Navigate to ```frontend/```
2. Execute the ```run``` script.\
   Note: there may be permissions issues when running apache in user folder, so it might be better to locate your apache install and manually copy the files from ```frontend/htdocs/``` into the ```htdocs``` folder in your apache install.


## Building and Running the Java Backend
1. Navigate to ```backend/```
2. Use the gradlew script to build
   ```
   ./gradlew build
   ```
4. Run with
   ```
   ./gradlew bootRun
   ```
If you use an IDE you can set up your ide to use gradle tasks instead of using the command line

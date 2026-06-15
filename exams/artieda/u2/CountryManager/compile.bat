@echo off
echo Compiling Java source files...
if not exist bin mkdir bin
javac -d bin src/ec/edu/espe/countrymanager/model/*.java src/ec/edu/espe/countrymanager/view/*.java src/ec/edu/espe/countrymanager/controller/*.java src/ec/edu/espe/countrymanager/main/*.java
echo Compilation finished.
pause

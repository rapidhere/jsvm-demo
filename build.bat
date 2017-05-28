@echo off

java -jar jsvm.jar -c js\Server.js --package ranttu.rapid.jsvmdemo.js -o lib\ranttu\rapid\jsvmdemo\js
java -jar jsvm.jar -c js\Client.js --package ranttu.rapid.jsvmdemo.js -o lib\ranttu\rapid\jsvmdemo\js

javac -cp ".\lib;.\jsvm.jar;"  -d .\output .\java\ranttu\rapid\jsvmdemo\Logger.java .\java\ranttu\rapid\jsvmdemo\SimpleServerSocket.java .\java\ranttu\rapid\jsvmdemo\AsyncCalculator.java .\java\ranttu\rapid\jsvmdemo\RequestSender.java

xcopy .\lib .\output /E /H /Y
xcopy .\jsvm.jar .\output /Y
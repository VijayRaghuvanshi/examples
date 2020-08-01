
rmdir /S /Q  jre

"%JAVA_HOME%\bin\jlink.exe" ^
	--module-path "%JAVA_HOME%\jmods";out ^
	--add-modules learning.java.nine.jokeapp ^
	--launcher JOKER=learning.java.nine.jokeapp/learning.java.nine.jokeapp.Main ^
	--output jre
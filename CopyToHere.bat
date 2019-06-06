@echo off
setlocal EnableDelayedExpansion
git pull origin master
set DIR="%D:\workspace\HackerRank\%"
for /r %DIR% %%i in (*.java) do (
	set str=%%~pdi
	set str=!str:~24!
	set str=!str:~0,-5!
	copy %%i .\Solutions\!str!.java
)
git add .
git commit -m "Auto Update@%date% %time%"
git push origin master
pause
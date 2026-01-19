@echo off
setlocal
powershell -NoProfile -ExecutionPolicy Bypass -File "%~dp0build_jar.ps1"
endlocal

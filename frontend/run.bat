@echo off
httpd -c "DocumentRoot %~dp0\htdocs" -c "Include %~dp0\conf\httpd.conf"
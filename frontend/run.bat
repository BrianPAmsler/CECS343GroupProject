@echo off
httpd -c "ServerName 127.0.0.1" -c "DocumentRoot %~dp0\htdocs" -c "Include %~dp0\conf\httpd.conf"
# Apache configuration

## Windows deploy CAN'T NOT USE Virtualenv 

[Windows_mod_wsgi Download Link](https://www.lfd.uci.edu/~gohlke/pythonlibs/#mod_wsgi) 

```
..\108-2_androidstudio_final\flask> python
Python 3.7.8 (tags/v3.7.8:4b47a5b6ba, Jun 28 2020, 08:53:46)

..\108-2_androidstudio_final\flask> httpd -v
Server version: Apache/2.4.43 (Win64)
Apache Lounge VC15 Server built:   Apr 22 2020 11:11:00
```

Download mod_wsgi-4.7.1-cp37-cp37m-win_amd64.whl

Download .whl File move to /var/www/108-2_androidstudio_final/flask

```
..\108-2_androidstudio_final\flask> pip install mod_wsgi-4.7.1-cp37-cp37m-win_amd64.whl

mod_wsgi-express module-config
LoadFile "c:/users/user/appdata/local/programs/python/python37/python37.dll"
LoadModule wsgi_module "c:/users/user/appdata/local/programs/python/python37/lib/site-packages/mod_wsgi/server/mod_wsgi.cp37-win_amd64.pyd"
WSGIPythonHome "c:/users/user/appdata/local/programs/python/python37"

```
##


## httpd.conf

```
# /etc/httpd/conf/httpd.conf
# ... 加入以下
LoadModule wsgi_module modules/mod_wsgi.so

<VirtualHost *:80>
    DocumentRoot "/var/www/108-2_androidstudio_final/flask"
    WSGIScriptAlias / "/var/www/108-2_androidstudio_final/flask/wsgi.py"
    ServerName funar.net
    <Directory /var/www/108-2_androidstudio_final/flask>
        AllowOverride all
        Require all granted
    </Directory>
</VirtualHost>
```

## 02-wsgi.conf

```
mod_wsgi-express install-module > /etc/httpd/conf.modules.d/02-wsgi.conf
LoadModule wsgi_module /...path.../venv/lib/python3.6/site-packages/mod_wsgi/server/mod_wsgi-py36.cpython-36m-x86_64-linux-gnu.so 
```


## Back to README

[Click me to Main README](/README.md)
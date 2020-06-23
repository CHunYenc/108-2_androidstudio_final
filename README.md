# 108-2_androidstudio_final

### 環境

| Tools          | Version |
| -------------- | ------- |
| CentOS         | 7       |
| httpd (Apache) | 2.4.6   |
| Python         | 3.6.8   |

### 
### Python 環境建置

```
# 108-2_androidstudio_final/config.py
import os
'''

flask shell
import os
os.urandom(24)
產生後替代 SECRET_KEY 
'''

class Config(object):
    DEBUG = True
    TESTING = False
    JSON_AS_ASCII = False
    # 格式 mysql://username:password@localhost:port/databasename
    SECRET_KEY = 'This is a Key HAHA'


class ProductionConfig(Config):
    SQLALCHEMY_DATABASE_URI = 'mysql://root:Android_0620@localhost:3306/db_ad'
    SQLALCHEMY_TRACK_MODIFICATIONS = False
    pass


class DevelopmentConfig(Config):
    SQLALCHEMY_DATABASE_URI = 'mysql://root:@localhost:3306/db_ad'
    SQLALCHEMY_TRACK_MODIFICATIONS = False
    DEBUG = True


class TestingConfig(Config):
    TESTING = True


```

### Apache 首次設定

##### httpd.conf
```
# /etc/httpd/conf/httpd.conf
# ... 加入以下
LoadModule wsgi_module modules/mod_wsgi.so

<VirtualHost *:80>
    DocumentRoot "/var/www/final"
    WSGIScriptAlias / "/var/www/final/wsgi.py"
    ServerName funar.net
    <Directory /var/www/final>
        AllowOverride all
        Require all granted
    </Directory>
</VirtualHost>
```
##### 00-wsgi.conf
```
# /etc/httpd/conf.modules.d/00-wsgi.conf
LoadModule wsgi_module /...路徑.../venv/lib/python3.6/site-packages/mod_wsgi/server/mod_wsgi-py36.cpython-36m-x86_64-linux-gnu.so 
```


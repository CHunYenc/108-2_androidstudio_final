# Python configuration

- [Python configuration](#python-configuration)
  - [Windows](#windows)
  - [Linux](#linux)
  - [Flask run](#flask-run)
  - [Flask configuration](#flask-configuration)
  - [Back to README](#back-to-readme)

## Windows

```
..\108-2_androidstudio_final\flask> pip install virtualenv
..\108-2_androidstudio_final\flask> virtualenv venv
..\108-2_androidstudio_final\flask> venv\Scripts\activate

(venv) \flask> pip install -r requirements.txt
```

## Linux
```
$ sudo su
# python3 -m venv venv
# source venv/bin/activate
(venv) # pip install -r requirements.txt
```

## Flask run

```

# db migrate 建立 / 初始化
flask db init
flask db migrate
flask db upgrade

# flask run

python run.py

# or flask run 
# or py run.py 
# or python3 run.py

# change Flask_ENV default production to development
# Linux
export FLASK_ENV=development
# Windows
set FLASK_ENV=development
```

## Flask configuration

```
# 108-2_androidstudio_final/flask/config.py

# ==== generate SECRET_KEY ====
# $ flask shell
# >>> import os
# >>> import base64
# >>> a = os.urandom(24)
# >>> base64.b64encode(a)

class Config(object):
    DEBUG = False
    TESTING = False
    JSON_AS_ASCII = False
    # 格式 mysql://username:password@localhost:port/databasename
    SECRET_KEY = 'This is a Key HAHA'


class ProductionConfig(Config):
    SQLALCHEMY_DATABASE_URI = 'mysql://root:password@localhost:3306/db_a'
    SQLALCHEMY_TRACK_MODIFICATIONS = False

class DevelopmentConfig(Config):
    SQLALCHEMY_DATABASE_URI = 'mysql://root:password@localhost:3306/db_b'
    SQLALCHEMY_TRACK_MODIFICATIONS = False
    DEBUG = True


class TestingConfig(Config):
    TESTING = True


```

## Back to README

[Click me to Main README](/README.md)
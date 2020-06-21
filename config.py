import os

'''

flask shell
import os
os.urandom(24)

'''


class Config(object):
    DEBUG = True
    TESTING = False
    JSON_AS_ASCII = False
    # 格式 mysql://username:password@localhost:port/databasename
    SECRET_KEY = '7afa4a3fa50c30cd5de8ad3dc34ace40fe6dddcc895cb7c9'


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

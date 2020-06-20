from app import db
import MySQLdb
import datetime
import time


class Users(db.Model):
    u_id = db.Column(db.String(9), primary_key=True)
    u_pwd = db.Column(db.String(10), nullable=False)
    u_birthday = db.Column(db.String(8), nullable=False)
    u_gender = db.Column(db.Boolean, nullable=False)


# class u_data(db.Model):

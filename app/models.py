from app import db
import MySQLdb
import datetime
import time


class Users(db.Model):
    u_id = db.Column(db.String(9), primary_key=True)
    u_password = db.Column(db.String(10), nullable=False)
    u_gender = db.Column(db.Boolean, nullable=False)

# class u_data(db.Model):

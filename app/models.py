from app import db
import MySQLdb
from datetime import datetime


class Users(db.Model):
    u_id = db.Column(db.String(9), primary_key=True)
    u_password = db.Column(db.String(10), nullable=False)
    u_gender = db.Column(db.Boolean, nullable=False)
    u_data = db.relationship('data', backref='users', lazy=True)
# a = Users(u_id="b10600000",u_password="123",u_gender=1)


class data(db.Model):
    d_id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    d_bmi = db.Column(db.Float, nullable=False)
    d_climb = db.Column(db.Float, nullable=False)
    d_sfmax = db.Column(db.Float, nullable=False)
    d_sitemax = db.Column(db.Float, nullable=False)
    d_sljmax = db.Column(db.Float, nullable=False)
    d_ctime = db.Column(db.DateTime, default=datetime.now)
    u_id = db.Column(db.String(9), db.ForeignKey('users.u_id'), nullable=False)
# d = data(d_bmi=1,d_climb=2, d_sfmax=3, d_sitemax=4, d_sljmax=5, u_id="b10610020")
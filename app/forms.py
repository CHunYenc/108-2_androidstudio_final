from flask_wtf import FlaskForm
from wtforms import StringField , PasswordField , BooleanField
from wtforms.validators import email_validator,DataRequired

class LoginForm(FlaskForm):
    email = StringField('電子信箱：',validators=[DataRequired()])
    password = PasswordField('密碼：',validators=[DataRequired()])
    remember_me = BooleanField('記住我 (公用電腦請勿打勾)')
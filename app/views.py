from app import db, app
from flask import request, redirect, flash, Blueprint, jsonify
# from app.models import User
# from .forms import LoginForm


def mess(mess):
    data = {
        'mess': mess,
    }
    return jsonify(data)


@app.route('/')
def index():
    return "<h1>成功<h1>"


@app.errorhandler(404)
def page_not_found(e):
    return mess("Not Page!!!!"), 404


@app.errorhandler(500)
def internal_server_error(e):
    return mess('連線失敗'), 500

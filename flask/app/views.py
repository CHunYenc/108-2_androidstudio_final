from flask import request, redirect, flash, Blueprint, jsonify
from app import app


def su_mess(mess):
    data = {
        'success': 1,
        'mess': mess,
    }
    return jsonify(data)


def er_mess(mess):
    data = {
        'success': 0,
        'mess': mess,
    }
    return jsonify(data)


@app.route('/')
def index():
    return "<h1>Success<h1>"


@app.errorhandler(404)
def page_not_found(e):
    return er_mess("Not Page!!!!"), 404


@app.errorhandler(500)
def internal_server_error(e):
    return er_mess('Connect Error!!!'), 500

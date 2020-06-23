from flask import jsonify, request
from . import api
from .. import db
from ..views import su_mess, er_mess
from ..models import Users


# 使用者資料登入
@api.route("/login", methods=["GET", "POST"])
def login():
    if request.method == "POST":
        u_id = request.values["u_id"]
        u_password = request.values["u_password"]
        if u_id == "":
            return er_mess("沒有輸入學號。"), 400
        elif u_password == "":
            return er_mess("沒有輸入密碼。"), 400
        else:
            user = Users.query.filter_by(u_id=u_id).first()
            if user.u_password == u_password:
                return su_mess('登入成功'), 200
            else:
                return er_mess('登入失敗'), 400
    else:
        return er_mess("使用不正確的連接方式。"), 400


# 使用者資料上傳
@api.route("/register", methods=["GET", "POST"])
def register():
    if request.method == "POST":
        u_id = request.values["u_id"]
        u_password = request.values["u_password"]
        u_gender = request.values["u_gender"]

        if u_id == "":
            return er_mess("沒有輸入學號。"), 400
        elif u_password == "":
            return er_mess("沒有輸入密碼。"), 400
        elif u_gender == "":
            return er_mess("沒有選擇性別。"), 400
        else:
            if Users.query.filter_by(u_id=u_id).first():
                return er_mess('已經註冊過。'), 400
            else:
                user = Users(u_id=u_id,
                             u_password=u_password,
                             u_gender=bool(u_gender))
                db.session.add(user)
                db.session.commit()
                return su_mess("成功收到資料"), 201
    else:
        return er_mess('使用不正確的傳輸方式。'), 400

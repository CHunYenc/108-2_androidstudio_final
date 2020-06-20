from flask import jsonify, request
# from . import api, error_mess, success_mess, select_email, U_data
# from ..models import School, User
from .. import db

# # 使用者資料登入
# @api.route("/login", methods=["GET", "POST"])
# def login():
#     if request.method == "POST":
#         # print(request.values)
#         # print(success_mess('API Success'))
#         # 如果隨機 POST 沒帶 email 不給過 直接跳至 except
#         try:
#             # if post's email == "" ,  如果 post 時 email == ""
#             if request.values["email"] == "":
#                 return jsonify(error_mess("沒有輸入電子信箱"))
#         # 如果上面有錯
#         except:
#             return jsonify(error_mess('沒有偵測到電子信箱。'))
#         email = request.values["email"]
#         # {'status': 1, 'mess': 'API Success'}
#         if select_email(email) == False:
#             return jsonify(success_mess('此信箱尚未使用過'))
#         else:
#             print(U_data)
#             return jsonify(U_data)
#         return jsonify(error_mess())
#     # test ok!
#     else:
#         return jsonify(error_mess("使用不正確的連接方式。"))

# # 使用者資料上傳
# @api.route("/register", methods=["GET", "POST"])
# def register():
#     if request.method == "POST":
#         class user():
#             def __init__(self, *args, **kwargs):
#                 email = "",
#                 school_Name = "",
#                 real_Name = "",
#                 game_Name = ""
#         user.email = request.values["email"]
#         user.school_Name = request.values["school_name"]
#         user.real_Name = request.values["real_Name"]
#         user.game_Name = request.values["game_Name"]
#         print("資料:", user.email, user.school_Name,
#               user.real_Name, user.game_Name)
#         try:
#             if user.email == "":
#                 return jsonify(error_mess('請輸入電子信箱'))
#             elif user.school_Name == "":
#                 return jsonify(error_mess('請選擇學校'))
#             elif user.real_Name == "":
#                 return jsonify(error_mess('請輸入真實姓名'))
#             elif user.game_Name == "":
#                 return jsonify(error_mess('請輸入遊戲名稱'))
#             pass
#         except:
#             return jsonify(error_mess('ERROR'))
#             print(select_email(user.email))
#         if select_email(user.email) == False:
#             # print(select_email)
#             school = School.query.filter_by(
#                 S_name=user.school_Name).first()
#             # print(school.S_id)
#             user = User(U_email=user.email, U_name=user.real_Name,
#                         U_gname=user.game_Name, U_school=school.S_id)
#             db.session.add(user)
#             db.session.commit()
#             return jsonify(success_mess('資料儲存完成！'))
#         else:
#             return jsonify(error_mess('已經註冊過。'))
#     else:
#         return jsonify(error_mess('使用不正確的傳輸方式。'))

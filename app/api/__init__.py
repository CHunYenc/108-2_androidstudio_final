
from flask import Blueprint

api = Blueprint('api', __name__)

data = {}

U_data = {}

# 動作失敗，錯誤訊息


def error_mess(mess='error'):
    data['status'] = 0
    data['mess'] = mess
    return data

# 動作成功，成功訊息

def success_mess(mess):
    data['status'] = 1
    data['mess'] = mess
    return data

# # 搜尋 email


# def select_email(email):
#     select_email = User.query.filter_by(U_email=email).first()

#     if select_email == None:
#         return False
#     else:
#         U_data['U_email'] = select_email.U_email
#         U_data['U_name'] = select_email.U_name
#         U_data['U_gname'] = select_email.U_gname
#         U_data['U_identity'] = select_email.U_identity
#         U_data['U_school'] = select_email.school.S_name
#         return U_data

#     def get_user(select_email):
#         return select_email


from . import users


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


from . import users , h_data

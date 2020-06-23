from flask import jsonify, request
from . import api
from .. import db
from ..views import su_mess, er_mess
from ..models import data, Users


# 使用者資料登入
@api.route("/postdata", methods=["GET", "POST"])
def postdata():
    if request.method == "POST":
        d_bmi = request.values["d_bmi"]
        d_climb = request.values["d_climb"]
        d_sfmax = request.values["d_sfmax"]
        d_sitemax = request.values["d_sitemax"]
        d_sljmax = request.values["d_sljmax"]
        u_id = request.values["u_id"]

        if d_bmi == "":
            return er_mess("d_bmi is null"), 400
        elif d_climb == "":
            return er_mess("d_climb is null"), 400
        elif d_sfmax == "":
            return er_mess("d_sfmax is null"), 400
        elif d_sitemax == "":
            return er_mess("d_sitemax is null"), 400
        elif u_id == "":
            return er_mess("u_id is null"), 400
        else:
            if Users.query.filter_by(u_id=u_id).first() != None:
                u_data = data(d_bmi=d_bmi,
                              d_climb=d_climb,
                              d_sfmax=d_sfmax,
                              d_sitemax=d_sitemax,
                              d_sljmax=d_sljmax,
                              u_id=u_id)
                db.session.add(u_data)
                db.session.commit()
                return su_mess('User Upload Success ~'), 201
            else:
                return er_mess('Not search User !!!'), 400
    else:
        return er_mess("使用不正確的連接方式。"), 400


@api.route('/getdata/', methods=['GET'])
@api.route('/getdata/<string:u_id>', methods=['GET'])
def getdata(u_id):
    # page = page
    # data = User.query.all()
    u_data = data.query.filter_by(u_id=u_id)
    #u_data = data.query.filter_by(u_id='b10610020').order_by(data.d_ctime).paginate(page=5, per_page=5, error_out=False)
    a = []
    for i in u_data:
        d_row = {
            "d_id": i.d_id,
            "d_bmi": i.d_bmi,
            "d_climb": i.d_climb,
            "d_sfmax": i.d_sfmax,
            "d_sitemax": i.d_sitemax,
            "d_sljmax": i.d_sljmax,
            "d_ctime": i.d_ctime,
            "u_id": i.u_id,
        }
        a.append(d_row)
    print(a)
    x = {"data": a}

    return jsonify(x), 200

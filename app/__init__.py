from flask import Flask , Blueprint
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

app = Flask(__name__)
if app.config["ENV"] == "production":
    app.config.from_object("config.ProductionConfig")
else:
    app.config.from_object("config.DevelopmentConfig")

print(f'ENV is set to: {app.config["ENV"]}')


# Models 關於資料庫
db = SQLAlchemy(app)
Migrate = Migrate(app,db)

# Views And Router
from .api import api as api_blueprint
# # API
app.register_blueprint(api_blueprint , url_prefix='/api')
# # Access
from . import views

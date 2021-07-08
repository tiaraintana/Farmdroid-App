from os.path import dirname, join
from com.chaquo.python import Python
import requests
import base64
import io

def main(data):
    # decoded data
    decoded_data = base64.b64decode(data)

    # save image from base64 decoded
    files_dir = str(Python.getPlatform().getApplication().getFilesDir())
    filename = join(dirname(files_dir), "predict.jpg")
    with open(filename, 'wb') as f:
        f.write(decoded_data)

    API_ENDPOINT = "https://getprediction-3xwvbpl3ka-as.a.run.app"

    resp = requests.post(url = API_ENDPOINT, files={'file': open(filename, 'rb')})
    return resp.text

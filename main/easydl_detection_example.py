# -*- coding: utf-8 -*-

import time
import base64
import requests
from datetime import datetime
print(datetime.now())

start = time.time()
# 获取access_token
# client_id 为官网获取的AK， client_secret 为官网获取的SK
appid = "【appid】"
client_id = "【client_id】"
client_secret = "【client_secret】"
print("appid:" + appid)
print("client_id:" + client_id)
print("client_secret:" + client_secret)

token_url = "https://aip.baidubce.com/oauth/2.0/token"
host = f"{token_url}?grant_type=client_credentials&client_id={client_id}&client_secret={client_secret}"

response = requests.get(host)
access_token = response.json().get("access_token")


# 调用物体检测接口  参数request_url：您的物体检测模型 URL
request_url = "您的物体检测模型 URL"
# 以二进制方式打开图文件
# 参数image：图像base64编码
# 下面图片路径请自行切换为自己环境的绝对路径
for i in range(3):
	img_path = "../img/image_"+ str(i) + ".jpg"
	with open(img_path, "rb") as f:
		image = base64.b64encode(f.read()).decode("UTF-8")

	body = {
		"image": image,
		"threshold":0.8,
	}
	headers = {"Content-Type": "application/json"}
	request_url = f"{request_url}?access_token={access_token}"
	response = requests.post(request_url, headers=headers, json=body)


	content = response.content.decode("UTF-8")

	# 打印调用结果
	# print(content)
	print("img_path: " + img_path + " has :" + str(len(eval(content)["results"])) + " mature strawberry.")
	end = time.time()
	# print(f"Running time: {(end-start):.2f} Seconds")
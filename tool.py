# -*- coding:utf-8 -*-
#处理批量文件
# fr = open('time_re', 'r')
# fw = open('time_re_bak', 'w')
# for line in fr:
#     start = 1
#     end = len(line) - 2
#     line = line.replace('(', '[', -1)
#     line = line.replace(')', ']', -1)
#     line = 'nr,' + line[start:end] + '\n'
#     fw.write(line)
# import re
# patternRaw = u'[零|一|二|三|四|五|六|七|八|九|十]+分[零|一|二|三|四|五|六|七|八|九|十]+秒?'
# pattern = re.compile(patternRaw)
# f = open('example.txt', 'r')
# for line in f:
#     result = re.findall(pattern, line)
#     print(result)
# from TimeNormalizer import TimeNormalizer # 引入包
# import json
# tn = TimeNormalizer()

# res = tn.parse(target='从明天到明年', timeBase='2013-02-28 16:30:29') # target为待分析语句，timeBase为基准时间默认是当前时间
# print(res)
# res = tn.parse(target='2013年二月二十八日下午四点三十分二十九秒', timeBase='2013-02-28 16:30:29') # target为待分析语句，timeBase为基准时间默认是当前时间
# print(res)
# res = tn.parse(target='我需要大概33天2分钟', timeBase='2013-02-28 16:30:29') # target为待分析语句，timeBase为基准时间默认是当前时间
# print(res)
# res = tn.parse(target='1月末') # target为待分析语句，timeBase为基准时间默认是当前时间
# res = tn.parse(target='明天')
# js = json.loads(res)
# print(js)
# print(res)
from cocoNLP.extractor import extractor
ex = extractor()
text = '急寻特朗普，男孩，于2018年11月27号11时在陕西省安康市汉滨区走失。丢失发型短发，...如有线索，请迅速与警方联系：18100065143，132-6156-2938，baizhantang@sina.com.cn 和yangyangfuture at gmail dot com'
times = ex.extract_time(text)
print(times)
dic = dict({0: 7, 1: 4, 2: 17, 3: 5, 4: 7, 5: 6, 6: 5, 7: 7, 8: 8, 9: 6, 10: 1, 11: 6})
# a = [ v for v in sorted(dic.values())]
a = sorted(dic.items(), key=lambda d: d[1])
dic = dict(a)

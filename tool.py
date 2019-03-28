fr = open('time_re', 'r')
fw = open('time_re_bak', 'w')
for line in fr:
    start = 1
    end = len(line) - 2
    line = line.replace('(', '[', -1)
    line = line.replace(')', ']', -1)
    line = 'nr,' + line[start:end] + '\n'
    fw.write(line)



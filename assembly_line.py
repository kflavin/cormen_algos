#!/usr/bin/python


def fastest_way(a, t, e, xt, n):
    # a = assembly times at each station
    # t = transfer times at each station to new line
    # e = entrance times onto each line
    # xt = exit times from each line
    # n = number of stations

    f = [ [0 for y in range(n)] for x in range(0, 2) ]
    l = [ [0 for y in range(n)] for x in range(0, 2) ]

    f[0][0] = e[0] + a[0][0]
    f[1][0] = e[1] + a[1][0]

    l[0][0] = 0
    l[1][0] = 1
    #import pdb
    #pdb.set_trace()

    for j in range(1, n):
        # calculate for line 1
        if (f[0][j-1] + a[0][j]) < (f[1][j-1] + t[1][j-1] + a[0][j]):
            f[0][j] = f[0][j-1] + a[0][j]
            l[0][j] = 1
        else:
            f[0][j] = f[1][j-1] + t[1][j-1] + a[0][j]
            l[0][j] = 2

        # calculate for line 2
        if (f[1][j-1] + a[1][j]) < (f[0][j-1] + t[0][j-1] + a[1][j]):
            f[1][j] = f[1][j-1] + a[1][j]
            l[1][j] = 2
        else:
            f[1][j] = f[0][j-1] + t[0][j-1] + a[1][j]
            l[1][j] = 1

    f_ = ""
    if f[0][n-1] + xt[0] < f[1][n-1] + xt[1]:
        f_ = f[0][n-1] + xt[0]
    else:
        f_ = f[1][n-1] + xt[1]

    print f
    print l
    print "f* =", f_


e = [2, 4]
x = [3, 2]
a = [
     [7, 9, 3, 4, 8, 4],
     [8, 5, 6, 4, 5, 7]
 ]
t = [
     [2, 3, 1, 3, 4],
     [2, 1, 2, 2, 1]
     ]
lines = 2
n = 6
fastest_way(a, t, e, x, n)

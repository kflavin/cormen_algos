package com.kyle;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello world");

        Integer[][] a = new Integer[][] { {7, 9, 3, 4, 8, 4}, {8, 5, 6, 4, 5, 7} };
        Integer[][] t = new Integer[][] { {0, 2, 3, 1, 3, 4}, {0, 2, 1, 2, 2, 1} };
        Integer[] e = new Integer[] { 2, 4 };
        Integer[] x = new Integer[] { 3, 2};
        int n = 6;

        fastestWay(a, t, e, x, n);


    }

    public static void fastestWay(Integer[][] a, Integer[][] t, Integer[] e, Integer[] x, Integer n) {
        System.out.println("Calculating fastest path through the assembly line");
        Integer[][] f = new Integer[2][6];
        Integer[][] l = new Integer[2][6];
        int f_;
        int l_;
        f[0][0] = e[0] + a[0][0];
        f[1][0] = e[1] + a[1][0];

        for (int j = 1; j < n; j++) {
            if (f[0][j-1] + a[0][j] < f[1][j-1] + t[1][j] + a[0][j]) {
                f[0][j] = f[0][j-1] + a[0][j];
                l[0][j] = 0;
            } else {
                f[0][j] = f[1][j-1] + t[1][j] + a[0][j];
                l[1][j] = 1;
            }

            if (f[1][j-1] + a[1][j] < f[0][j-1] + t[0][j] + a[1][j]) {
                f[1][j] = f[1][j-1] + a[1][j];
                l[1][j] = 1;
            } else {
                f[1][j] =f[0][j-1] + t[0][j] + a[1][j];
                l[1][j] = 0;
            }
        }

        if (f[0][n-1] + x[0] < f[1][n-1] + x[1]) {
            f_ = f[0][n-1] + x[0];
            l_ = 0;
        } else {
            f_ = f[1][n-1] + x[1];
            l_ = 1;
        }

        System.out.println("Fastest time through is " + f_ + ", through line " + l_);

        for (int i = 0; i<f.length; i++) {
            int j;
            for (j = 0; j<n; j++) {
                System.out.println("Line " + (i+1) + " Station " + (j+1) + " time " + f[i][j]);
            }
            System.out.println("Total time: " + (f[i][j-1] + x[i]));
        }

    }
}

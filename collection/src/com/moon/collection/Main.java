package com.moon.collection;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main (String [] args)
    {
        int [] arg = new int[]{1,2,3,4,5,6,7,8};

        int a = 8;
        int index = findIndex (arg, arg.length - 1, 0, a);

        System.err.println(index);

    }

    public static int findIndex (int [] arg, int high, int low, int target)
    {
       while (low <= high)
       {
           int mid = (low +high) >> 1;
           if (arg[mid] == target)
           {
                return mid;
           }
           else if (arg[mid] > target)
           {
               high = mid - 1;
           }
           else
           {
               low = mid + 1;
           }
       }
       return -1;
    }
}

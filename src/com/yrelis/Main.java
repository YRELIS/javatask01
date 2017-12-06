package com.yrelis;
import com.sun.management.OperatingSystemMXBean;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) {
        try
        {
            int used = Monitor.Used();
            int pamyt_polnay = Monitor.Total();
            int available = Monitor.Available();
            Monitor.getProcesses();
            System.out.println("------------------------- -------- ---------------- ----------- ------------");
            System.out.println(pamyt_polnay + " mb полной памяти.");
            System.out.println(used + " mb используемой.");
            System.out.println(available + " mb доступно.");
        }
        catch (Exception err)
        {
            err.printStackTrace();
        }
    }
}

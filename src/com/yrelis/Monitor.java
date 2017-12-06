package com.yrelis;
import com.sun.management.OperatingSystemMXBean;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

public class Monitor {

    static OperatingSystemMXBean tek =
            (com.sun.management.OperatingSystemMXBean)
                    ManagementFactory.getOperatingSystemMXBean();

    public static void getProcesses()
    {
        try
        {
            String line = "-";
            Process process = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(process.getInputStream(), "Cp866"));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public static int Available()
    {
        return (int)(tek.getFreePhysicalMemorySize() / 1048576);
    }

    public static int Total()
    {
        return (int)(tek.getTotalPhysicalMemorySize() / 1048576);
    }

    public static int Used() { return (int)((tek.getTotalPhysicalMemorySize() - tek.getFreePhysicalMemorySize()) / 1048576); }


}

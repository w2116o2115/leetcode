package design;

import java.io.*;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2020/12/24 20:52
 */
public class IpTable {
    private BitMap table;
    private long ipNum;


    private IpTable() {
    }

    public static IpTable getIpTable(String ipTableFile) {
        IpTable ipTable = new IpTable();
        ipTable.table = new BitMap(1L << 32);
        ipTable.ipNum = 0;

        try {
            File file = new File(ipTableFile);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);

            String line = "";
            while ((line = br.readLine()) != null) {
                long ip = ipToLong(line);
                ipTable.addIp(ip);
            }

            br.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ipTable;

    }

    public static long ipToLong(String ip) {
        String[] ip_bytes = ip.split("\\.");
        return  ((Integer.parseInt(ip_bytes[0]) << 24) |
                (Integer.parseInt(ip_bytes[1]) << 16) |
                (Integer.parseInt(ip_bytes[2]) <<  8) |
                (Integer.parseInt(ip_bytes[3]) <<  0)) & 0x0ffffffffL;
    }


    public void addIp(long ip) {
        if (!table.isSet(ip)) {
            ipNum++;
        }

        table.set(ip);
    }

    public void removeIp(long ip) {
        if (table.isSet(ip)) {
            ipNum--;
        }

        table.clear(ip);
    }

    public boolean hasIp(long ip) {
        return table.isSet(ip);
    }

    public long getValidIpNum() {
        return ipNum;
    }

    public static void main(String[] args) {
        IpTable ipTable = IpTable.getIpTable("ip.txt");
        System.out.println("ipTable has valid ip num: "  + ipTable.getValidIpNum());

        String ip = "192.168.128.10";
        if (ipTable.hasIp(IpTable.ipToLong(ip))) {
            System.out.println("ip table has ip: " + ip);
        }
    }

}
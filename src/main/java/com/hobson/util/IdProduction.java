package com.hobson.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.Objects;

/**
 * id生成器
 *
 * @author haibin.tang
 * @create 2020-01-20 1:53 PM
 **/
public class IdProduction {
    private static final String LOCAL_IP_SUFFIX = "01";
    private static final String LOCAL_IP = "127.0.0.1";
    private static final long MIN_RANDOM = 100000000000000008L;
    private static final long MAX_RANDOM = 999999999999999999L;
    private static final int TWO = 2;
    private static final int THREE = 3;

    public static String getCode() {
        return String.format("%s%s%s",
                CompressDateUtil.encode(LocalDateTime.now()),
                Math.round(Math.random() * (MAX_RANDOM - MIN_RANDOM) + MIN_RANDOM),
                getIpSuffix()
                );
    }

    private static String getIpSuffix() {
        final String ipv4 = getIPV4();
        if (Objects.equals(ipv4, LOCAL_IP)) {
            return LOCAL_IP_SUFFIX;
        }
        return fillZero(ipv4.split("\\.")[3]);
    }

    private static String fillZero(final String source) {
        if (source.length() < TWO) {
            return "00" + source;
        }
        if (source.length() < THREE) {
            return "0" + source;
        }
        return source;
    }

    private static String getIPV4() {
        try {
            Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                Enumeration addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ip = (InetAddress) addresses.nextElement();
                    if (ip != null && !Objects.equals(ip.getHostAddress(), LOCAL_IP) && ip instanceof Inet4Address) {
                        return ip.getHostAddress();
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return LOCAL_IP;
    }
}

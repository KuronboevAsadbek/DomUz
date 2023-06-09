package uz.DomUz.config;

import javax.servlet.http.HttpServletRequest;
import java.net.SocketException;

public interface NetworkServices {
    String getClientIPv4Address(HttpServletRequest request);
    String getClientMACAddress(String IPAddress) throws SocketException;
    String getClientHostAddress(HttpServletRequest httpServletRequest);
}

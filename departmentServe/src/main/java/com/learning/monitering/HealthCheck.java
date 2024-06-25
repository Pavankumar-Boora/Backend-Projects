package com.learning.monitering;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;
@Controller
public class HealthCheck implements HealthIndicator {

	@Override
	public Health health() {
		try {
			if (isServiceUp()) {
				return Health.up().withDetail("Empoyee service", "is working good").build();
			} else {
				return Health.down().withDetail("Empoyee service", "is Not working...").build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean isServiceUp() throws NumberFormatException, IOException {
		String address = "192.168.0.24";
		String port = "8080";
//		System.out.println("Address = " + address + " Port  = " + port);
		return isAddressReachable(address, Integer.parseInt(port), 3000);
	}

	private boolean isAddressReachable(String address, int port, int timeout) throws IOException {
		Socket isSocket = new Socket();
		try {
//			Connects this socket to the server with a specified timeout value
			isSocket.connect(new InetSocketAddress(address, port), timeout);
//			Return true if connection is success
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		} finally {
			isSocket.close();
			return false;
		}
	}

}

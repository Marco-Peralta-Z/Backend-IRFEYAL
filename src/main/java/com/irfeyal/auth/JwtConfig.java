package com.irfeyal.auth;

public class JwtConfig {
	public static final String LLLAVE_SECRETA = "irfeyal2022app";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpAIBAAKCAQEAtZWmBQtoeIXUzTkSCIecUzDHZIFbsXnuF0MR3wBReo3lvCZJ\r\n"
			+ "0pW+ab8lqZhtmmPSmxmmnzB9ajl36YQwLB9DLNFJ6TgEjp2Urcu+kfF8EKMqcvZG\r\n"
			+ "jC1nqOLxNGfrpFBMxFi27IafXDPIJ1Q0CPriGmYs3zwrAFbeTzZzFP2sO8PfFSGO\r\n"
			+ "pvCLBkc2eBMvpaDpa/jV2EqhmejihQBDzViFmJpT3tWPzHAQKQkgWTN+dlW1kUgB\r\n"
			+ "2THPTIohkqKlJNaJJNorME1dAtXxMSZjieC71HF0IKxOTZlIsOaKm2Ui/m15zv0f\r\n"
			+ "KdRYe0QSX2xZpTIQjKYBLSo/yIzuNgPie/C99wIDAQABAoIBAH/xhn3tcNni6nMD\r\n"
			+ "cEpkSuhu6T9Oyi29zN3FGzV2gvKIQsQUclWXvwfBcCcUSL3M8hrosvddcjDDd1Mp\r\n"
			+ "Gcws5ucQPDTAjK10KMtgUNGCRjluzj0ce87PO0fLR8r2IhmvnreGDrWPkX+k2LWl\r\n"
			+ "Zdih9WhGb/2G5oGhs5g6tFGo/49HnhJM/OjxxvjXOI9Id6+bF9SB/ExnCbR4JVHe\r\n"
			+ "ZVNAojbo4j4aZdlxcvdZXMQn35zUmhuqOhPe0NcKYbFNGFN3BTk/U2CAssshlF5D\r\n"
			+ "88ybhan544o2gh0RNs6SYfEf7kLVV+ZezAZT5kVfmlJzS+AlhPVCZMub3buKoO5X\r\n"
			+ "7DeYqukCgYEA6LmqQ2kg7oKjnvZYfz/7uJvpM0hU8Sbdep4tnoWooPIwSHQtKnu2\r\n"
			+ "3xp09gcsgP7AvTHhLPrT1VsM6B8YmSIojP67UvVuoSC79MRzC13vy7XgEfCLSuxE\r\n"
			+ "0A2s6+yw0bGu3lIdlw2kBY4WAaUhaKhQBZbtl0mRcye4xz2tBL6XgqUCgYEAx76o\r\n"
			+ "KBOzjHd/MamsPH8FV2aAP8BjpWXKOkI+OqxNpE9ssZg8bzTdHR3gyWY7MU9D/bLo\r\n"
			+ "Sch4Jo+xnC24gbnqCb20MvIM+rfzA+pOfVzKxyRMFnD7JvaUpHUo7g6WKYjotB2F\r\n"
			+ "IBbpUfArNkEETg5dv503QHtUUFZtgpamvUb+J2sCgYEAvhzV0yWxSkYcJcJ2PtVk\r\n"
			+ "68UptsPy5+Do8r7+402qmHfgK4AEWX0gwZaaT1VC7MmvZ560pQruO4+atpCYhpgZ\r\n"
			+ "6jw5iKaITkYwZN6KYJHHT3Fu7xjCoVzrRc62ITCErXhqMqGAHKJ/CC6vGX7tENLW\r\n"
			+ "NAq8Ymct05VyZAilK4gKuyUCgYAVTRrHs1opd7DjzfFlPjKGoJK6ubymrdVEIz5Z\r\n"
			+ "qXhaNnIj+lUvktalvUL0l2dmmcppasPk4nEVw6swOZv8kaQIx+dIq5GAx08uMrWO\r\n"
			+ "HvAtDozis8fE3vT5GNl1ka6n3Ubbtm40/tyA9XjWP1bDMDsFLTHwOXbDXoQtMf20\r\n"
			+ "H7cI4wKBgQCaTZT1n6AcEg1hVRyIVywY+XXMU0U7jcJ3GsqLe1lcT85+Yvr7p0Z0\r\n"
			+ "R0VIlqxwgv+WjgXzKYE5G7uMPNMaGxQfWBIR/lCRtrDeoF75GDwyS/aowShKoI4c\r\n"
			+ "6LAOso8kuk4/nP+0rR+AhYhsT57Uz6dlcQszIIecn3YAjEveZ6U03g==\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	public static final String RSA_PUBLICA =  "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtZWmBQtoeIXUzTkSCIec\r\n"
			+ "UzDHZIFbsXnuF0MR3wBReo3lvCZJ0pW+ab8lqZhtmmPSmxmmnzB9ajl36YQwLB9D\r\n"
			+ "LNFJ6TgEjp2Urcu+kfF8EKMqcvZGjC1nqOLxNGfrpFBMxFi27IafXDPIJ1Q0CPri\r\n"
			+ "GmYs3zwrAFbeTzZzFP2sO8PfFSGOpvCLBkc2eBMvpaDpa/jV2EqhmejihQBDzViF\r\n"
			+ "mJpT3tWPzHAQKQkgWTN+dlW1kUgB2THPTIohkqKlJNaJJNorME1dAtXxMSZjieC7\r\n"
			+ "1HF0IKxOTZlIsOaKm2Ui/m15zv0fKdRYe0QSX2xZpTIQjKYBLSo/yIzuNgPie/C9\r\n"
			+ "9wIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}

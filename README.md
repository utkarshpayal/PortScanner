# PortScanner

A simple command-line TCP port scanner written in Java. It checks a range of ports on a host and prints the ones that are open.

## How it works

`PortScanner.java` loops over every port from `<start port>` to `<end port>` (inclusive) and tries to open a TCP connection with `java.net.Socket`. If the connection succeeds the port is reported as open; if it throws an `IOException` the port is treated as closed. Ports are scanned sequentially, one at a time, with no custom timeout, so large ranges or filtered ports can take a while.

## Requirements

- Java Development Kit (JDK). The code uses only the standard library (`java.net`, `java.io`); there are no external dependencies or build tools.

## Build and run

```sh
javac PortScanner.java
java PortScanner <IP address> <start port> <end port>
```

If the number of arguments is not exactly three, the program prints the usage line and exits.

## Example

```sh
java PortScanner 127.0.0.1 20 100
```

Example output format:

```
Scanning ports on 127.0.0.1...
Port 22 is open
Port 80 is open
Port scan on 127.0.0.1 completed
```

(Which ports appear depends on the services running on the target host.)

## Disclaimer

Only scan hosts and networks you own or have explicit permission to test.

## License

No license file is included in this repository.

package moe.zaun.prismriver.minor.dto;

public class ServiceInfo {
    public double version;
    public String name;
    public String type;

    public ServiceInfo(double version, String name, String type) {
        this.version = version;
        this.name = name;
        this.type = type;
    }
}

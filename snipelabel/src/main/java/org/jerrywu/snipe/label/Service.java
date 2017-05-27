package org.jerrywu.snipe.label;

/**
 * Created by jerry on 17-5-27.
 */
public class Service {

    private String id;
    private String name;
    private String protocol;
    private String interfaceRef;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getInterfaceRef() {
        return interfaceRef;
    }

    public void setInterfaceRef(String interfaceRef) {
        this.interfaceRef = interfaceRef;
    }
}

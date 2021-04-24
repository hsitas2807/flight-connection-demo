package com.flights.services.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sdixit
 * @since 21-04-2021
 */
public class Connections {

    List<ConnectionData> connectionData;

    public List<ConnectionData> getConnectionData() {
        if(connectionData!=null)
        return connectionData;
        else
            return connectionData=new ArrayList<>();
    }

}

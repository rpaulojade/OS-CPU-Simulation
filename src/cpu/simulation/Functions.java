/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu.simulation;

import javax.swing.JTable;

/**
 *
 * @author Sioty
 */
public class Functions {
    private String processName;
    private int Priority;
    private int ETA;
    private String type;
    
    /**
     * @return the processName
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * @param processName the processName to set
     */
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    /**
     * @return the Priority
     */
    public int getPriority() {
        return Priority;
    }

    /**
     * @param Priority the Priority to set
     */
    public void setPriority(int Priority) {
        this.Priority = Priority;
    }

    /**
     * @return the ETA
     */
    public int getETA() {
        return ETA;
    }

    /**
     * @param ETA the ETA to set
     */
    public void setETA(int ETA) {
        this.ETA = ETA;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}

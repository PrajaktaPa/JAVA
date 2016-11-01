/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient.vitalSigns;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Prajakta
 */
public class VitalSignHistory {
    
    private TreeMap<Date, VitalSigns> vitalSignMap;
    
    public VitalSignHistory() {
        this.vitalSignMap = new TreeMap<Date, VitalSigns>();
    }

    public TreeMap<Date, VitalSigns> getVitalSignMap() {
        return vitalSignMap;
    }

    public void setVitalSignMap(TreeMap<Date, VitalSigns> vitalSignMap) {
        this.vitalSignMap = vitalSignMap;
    }
    
    
    public VitalSigns addVitalSign() {
        Date currentDate = new Date();
        VitalSigns vitalSign = new VitalSigns();
        vitalSignMap.put(currentDate,vitalSign);
        return vitalSign;
    }
    
    /*private Date timestamp;
    private List<VitalSigns> vitalSignList;

    public VitalSignHistory() {
        this.vitalSignList = new ArrayList<>();
    }
    
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<VitalSigns> getVitalSignList() {
        return vitalSignList;
    }

    public void setVitalSignList(List<VitalSigns> vitalSignList) {
        this.vitalSignList = vitalSignList;
    }

    public VitalSigns addVitalSign() {
        VitalSigns vitalSign = new VitalSigns();
        vitalSignList.add(vitalSign);
        return vitalSign;
    }

    public void deleteVitalSign(VitalSigns vitalSigns) {
        vitalSignList.remove(vitalSigns);
    }*/
}

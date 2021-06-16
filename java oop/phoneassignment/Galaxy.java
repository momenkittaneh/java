/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneassignment;

/**
 *
 * @author black
 */
public class Galaxy extends Phone implements Ringable {
    String versionNumber;
    int batteryPercentage;
    String carrier;
    String ringTone;
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
        this.versionNumber=versionNumber;
        this.batteryPercentage=batteryPercentage;
        this.carrier=carrier;
        this.ringTone=ringTone;
    }
    @Override
    public String ring() {
        String Ring = "Galaxy ";
        Ring.concat(this.versionNumber);
        Ring.concat(" says");
        Ring.concat(this.ringTone);
        return Ring;
    }
    @Override
    public String unlock() {
        String Unlock = "Unlocking via finger print";
        return Unlock;
    }
    @Override
    public void displayInfo() {
        System.out.println("Galaxy" + this.versionNumber + "from" + this.carrier);
        // your code here            
    }
}

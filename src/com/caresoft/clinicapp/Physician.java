package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

	public Physician(Integer id) {
		super(id);
	}
	
    private ArrayList<String> patientNotes;{
    }
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if (pin < 1000 || pin > 9999) {
			return false;
		}
		this.pin = pin;
		return true;
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if (this.id == confirmedAuthID) {
			return true;
		}
		return false;
	}

}

// https://stackoverflow.com/questions/53350028/how-to-limit-the-user-to-enter-4-digit-pin-in-java
// public boolean assignPIN(String pin) {
//	if (pin.length() != 4) {
//	    System.out.println("You have not entered a 4-digit pin");
//	} else {
//	    boolean allDigits = true;
//	    for (int i = 0 ; i < 4 ; i++) {
//	        if (!Character.isDigit(pin.charAt(i))) {
//	            allDigits = false;
//	            break;
//	        }
//	    }
//	    if (allDigits) {
//	        // pin is valid
//	    } else {
//	        System.out.println("Error use numbers not alphabets or characters"); 
//	    }
//	}
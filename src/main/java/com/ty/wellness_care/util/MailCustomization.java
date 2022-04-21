package com.ty.wellness_care.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dto.Medication;
import com.ty.wellness_care.dto.Prescription;
import com.ty.wellness_care.email.api.EmailSenderService;

@Service
public class MailCustomization {
	@Autowired
	EmailSenderService emailSenderService;

	public void sentMail(Prescription prescription) {
		if (prescription.getPatientMail() != null) {
			String to = prescription.getPatientMail();
			String subject = prescription.getPatientName() + " Medical Details";

			String medicine = "\n ";

			List<Medication> medications = prescription.getMedications();
			if (medications != null) {
				for (Medication medication : medications) {
					medicine += medication.getMedicationName() + "    " + medication.getCost() + "    "
							+ medication.getSuggestions() + "\n\n";
				}
			}

			String body = "\nPatient Medical Details\n\n**********************************************"
					+ "\nMEDICAL DETAILS\n**********************************************" + medicine
					+ "\n**********************************************" + "\nREPORT:\n\n" + prescription.getReport()
					+ "\n************************************************\n\n Total Charges: "
					+ prescription.getTotalCost();
			emailSenderService.sendEmail(to, body, subject);
		}
	}

}

import { Component, OnInit } from '@angular/core';
import {Patient} from "../patient";
import {PatientService} from "../patient.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.css']
})
export class CreatePatientComponent implements OnInit {

  patient: Patient = new Patient();
  submitted = false;

  constructor(private patientService : PatientService, private router: Router) { }

  ngOnInit() {
  }

  newPatient(): void {
    this.submitted = false;
    this.patient = new Patient();
  }


  savePatientMeds() {
    this.patientService.createPatientMeds(this.patient)
      .subscribe(data => console.log(data), error => console.log(error));
    this.patient = new Patient()
  }

  savePatient() {
    this.patientService.createPatient(this.patient)
      .subscribe(data => console.log(data), error => console.log(error));
    this.patient = new Patient();
    this.gotoList();
  }



  onSubmit() {
    this.submitted = true;
    this.savePatient();
    this.savePatientMeds()
  }

  gotoList() {
    this.router.navigate(['/patients'])
  }

}

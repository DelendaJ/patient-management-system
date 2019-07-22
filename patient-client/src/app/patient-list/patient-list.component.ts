import { Component, OnInit } from '@angular/core';
import {PatientService} from "../patient.service";
import {Observable} from "rxjs";
import {Patient} from "../patient";
import {Router} from "@angular/router";


@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {
  patients: Observable<Patient[]>;

  constructor(private patientService: PatientService, private router: Router) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.patients = this.patientService.getPatientList()
  }

  destroyPatient(id: number) {
    this.patientService.destoryPatient(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error))
  }

  destroyPatientMeds(id: number) {
    this.patientService.destroyPatientMeds(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error))
  }

  patientDetails(id: number) {
    this.router.navigate(['details', id])
  }
}

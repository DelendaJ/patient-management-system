import {Component, Input, OnInit} from '@angular/core';
import {Patient} from "../patient";
import {PatientService} from "../patient.service";
import {PatientListComponent} from "../patient-list/patient-list.component";
import {Observable} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {
  id: number;
  patient: Patient = new Patient();

  constructor(private route: ActivatedRoute, private router: Router,
              private patientService: PatientService) {
  }

  ngOnInit() {
    this.patient = new Patient();

    this.id = this.route.snapshot.params['id'];

    this.patientService.getPatient(this.id)
      .subscribe(data => {
        console.log(data);
        this.patient = data;
      }, error => console.log(error));

    this.patientService.getPatientMeds(this.id)
      .subscribe(data => {
        console.log(data);
        if (data instanceof Patient) {
          this.patient = data;
        }
      },error => console.log(error));
  }



/*  editPatient() {
    this.patientService.updatePatient(this.id, this.patient)
      .subscribe(data => console.log(data), error => console.log(error));
    this.patientdeets();
  }*/


  save(): void {
    this.patientService.updatePatient(this.id, this.patient)
      .subscribe(() => this.list());
    console.log('test', this.patient);
  }


  list() {
    this.router.navigate(['patients']);
  }


}

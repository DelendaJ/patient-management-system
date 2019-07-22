import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PatientListComponent} from "./patient-list/patient-list.component";
import {CreatePatientComponent} from "./create-patient/create-patient.component";
import {PatientDetailsComponent} from "./patient-details/patient-details.component";


const routes: Routes = [
  {path: '', redirectTo: 'patient', pathMatch: 'full'},
  {path: 'patients', component: PatientListComponent},
  {path: 'add', component: CreatePatientComponent},
  {path: 'details/:id', component: PatientDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

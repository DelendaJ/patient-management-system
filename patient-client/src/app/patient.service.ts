import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Patient} from "./patient";

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  private baseURL = 'http://localhost:8090/api/patients';



  constructor(private http: HttpClient) {
  }

  getPatientList(): Observable<any> {
    return this.http.get(`${this.baseURL}`)
  }

  getPatient(id: number): Observable<Object> {
    return this.http.get(`${this.baseURL}/${id}`);
  }

  createPatient(patient: Object): Observable<Object> {
    return this.http.post(`${this.baseURL}`, patient);
  }

  postMedications(patient: Object): Observable<Object> {
    return this.http.post(`${this.baseURL}`, patient)
  }

  updatePatient(id: number, value: any): Observable<object> {
    return this.http.put(`${this.baseURL}/${id}`, value);

  }

  destoryPatient(id: number): Observable<any> {
    return this.http.delete(`${this.baseURL}/${id}`, {responseType: "text"});
  }

  getPatientMeds(id: number) : Observable<Object> {
  return this.http.get(`${this.baseURL}/${id}/medications`);
  }

  createPatientMeds (patient: Object, id: number): Observable<Object> {
    return this.http.post(`${this.baseURL}/${id}/medications`, patient);
  }

}

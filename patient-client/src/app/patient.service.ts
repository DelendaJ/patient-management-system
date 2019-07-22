import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  private baseURL = 'http://localhost:8080/api/patients';
  private medsURL = this.baseURL + '/{id}/medications';


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

  updatePatient(id: number, value: any): Observable<object> {
    return this.http.put(`${this.baseURL}/${id}`, value);

  }

  destoryPatient(id: number): Observable<any> {
    return this.http.delete(`${this.baseURL}/${id}`, {responseType: "text"});
  }

  getPatientMeds(id: number) : Observable<Object> {
    return this.http.get(`${this.medsURL}`);
  }

  createPatientMeds (patient: Object): Observable<Object> {
    return this.http.post(`${this.medsURL}`, patient);
  }

  destroyPatientMeds (id: number): Observable<any> {
    return this.http.delete(`${this.medsURL}/${id}`, {responseType: "text"});
  }

}

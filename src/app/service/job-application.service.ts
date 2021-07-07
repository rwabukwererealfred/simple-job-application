import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../Model/User';

const API = 'http://localhost:8080/api/job/';

const OPTIONS = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class JobApplicationService {
  
  constructor(private http: HttpClient) { 
    
  }

  getJobList():Observable<any>{
    return this.http.get(API+"jobListed");
  }
  getJobDetails(jobId:number):Observable<any>{
    return this.http.get(API+"jobDetails/"+jobId);
  }

  aplyWithoutLogin(formData: FormData) {
    return this.http.post(API + 'applyWithoutLogin', formData, { observe: 'response' });
  }
  createNewAccount(user: User){
    return this.http.post(API+"createNewAccount", JSON.stringify(user), OPTIONS);
  }
  applicantsList():Observable<any>{
    return this.http.get(API+"applicants");
  }
  applicantDetails(id:number):Observable<any>{
    return this.http.get(API+"applicantDetails/"+id);
  }
  dropApplicationService(applicationId:number, comment:string){
    const data ={
      "comment":comment
    }
    return this.http.put(API+"dropApplication/"+applicationId, JSON.stringify(data), OPTIONS);
  }
  passApplicationService(applicationId:number){
    return this.http.put(API+"passApplication/"+applicationId, OPTIONS);
  }
  downloadFile(fileName:string): Observable<any>{
		return this.http.get(API+"download/"+fileName, { responseType: 'arraybuffer' as 'json'});
  }
  
}

import { Component, OnInit } from '@angular/core';
import { JobApplicationService } from 'src/app/service/job-application.service';


@Component({
  selector: 'app-job-listed',
  templateUrl: './job-listed.component.html',
  styleUrls: ['./job-listed.component.css']
})
export class JobListedComponent implements OnInit {

  public jobs:any;
  public filterTerm: any;

  constructor(private jobService: JobApplicationService) { }

  ngOnInit(): void {
    this.jobList();
  }
  

  jobList(){
    this.jobService.getJobList().subscribe(res=>{
      this.jobs = res;
    },error=>{
      console.log(error);
    })
  }
}

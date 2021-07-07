import { Component, OnInit } from '@angular/core';
import { JobApplicationService } from 'src/app/service/job-application.service';
import { Job } from 'src/app/Model/Job';
import { ActivatedRoute } from '@angular/router';
import { StorageTokenService } from 'src/app/service/storage-token.service';

@Component({
  selector: 'app-job-details',
  templateUrl: './job-details.component.html',
  styleUrls: ['./job-details.component.css']
})
export class JobDetailsComponent implements OnInit {

public jobInfo :Job = new Job();
public check : string = '';

  constructor(private jobService: JobApplicationService, private route: ActivatedRoute, private storage: StorageTokenService) { }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const missionId = Number(routeParams.get('jobId'));
    this.jobService.getJobDetails(missionId).subscribe(res=>{
        this.jobInfo = res;
    })
    if(this.storage.getUser() !== null){
        this.check = this.storage.getUser().user.status;
    }
  }

}

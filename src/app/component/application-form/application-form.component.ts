import { Component, OnInit } from '@angular/core';
import { JobApplicationService } from 'src/app/service/job-application.service';
import { ActivatedRoute } from '@angular/router';
import { Job } from 'src/app/Model/Job';
import { User } from 'src/app/Model/User';
import { StorageTokenService } from 'src/app/service/storage-token.service';

@Component({
  selector: 'app-application-form',
  templateUrl: './application-form.component.html',
  styleUrls: ['./application-form.component.css']
})
export class ApplicationFormComponent implements OnInit {
  public fail:boolean = false;
  public success:boolean = false;
  public failedmessage:string = '';
  public jobInfo :Job = new Job();
  public photoImage: any;
  public user:User = new User();
  public jobId :any;
  public check: boolean = false;

  constructor(private jobService: JobApplicationService, private route: ActivatedRoute, private storage: StorageTokenService) {
   
   }

   
  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
     this.jobId = Number(routeParams.get('jobId'));
    this.jobService.getJobDetails(this.jobId).subscribe(res=>{
        this.jobInfo = res;
    })

    if(this.storage.getUser() != null){
      this.user = this.storage.getUser().user;
      this.check =true;
    }
  }
  fileChangeEvent(event:any) {
    this.photoImage = event.target.files[0];
}
  apply(){
    const formData = new FormData();
    formData.append('cv', this.photoImage);
    formData.append('us', JSON.stringify(this.user));
    formData.append('jobId', this.jobId);

    this.jobService.aplyWithoutLogin(formData).subscribe(res=>{
      this.user = new User();
      this.fail = false;
      this.success =true;

    },error=>{
      console.log(error);
      this.fail = true;
      this.success = false;
      this.failedmessage = error.error.message;
    })
  }
  

}

import { Component, OnInit, Inject } from '@angular/core';
import { JobApplicationService } from 'src/app/service/job-application.service';
import { ActivatedRoute, Router } from '@angular/router';
import { JobApplication } from 'src/app/Model/JobApplication';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import * as fileSaver from 'file-saver';

@Component({
  selector: 'app-applicant-details',
  templateUrl: './applicant-details.component.html',
  styleUrls: ['./applicant-details.component.css']
})
export class ApplicantDetailsComponent implements OnInit {
  public jobApplication:any;
  public applicationId:any;
  public file :string = '';
 
  constructor(private jobService: JobApplicationService, private route: ActivatedRoute, private dialog: MatDialog) { }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    this.applicationId = Number(routeParams.get('id'));
    this.jobService.applicantDetails(this.applicationId).subscribe(res=>{
      this.jobApplication = res;
    },error=>{
      console.log(error);
    })
    
  }
  openApproveDiaolog(application:JobApplication){
    const dialogRef= this.dialog.open(confirmationDialog,{
       width:"800px",
       data:application
     });
  }
  openDropDiaolog(application:JobApplication){
    const dialogRef= this.dialog.open(droppedDialog,{
       width:"800px",
       data:application
     });
  }
  downloadCv(){
    console.log("result: "+this.jobApplication.cvFile);
    this.jobService.downloadFile(this.jobApplication.cvFile).subscribe(res=>{
      let file = new Blob([res], { type: 'application/pdf' });
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    },error=>{
      console.log(error);
    })
  }
  
  saveFile(data: any, filename?: string) {
    const blob = new Blob([data], {type: 'text/pdf; charset=utf-8'});
    fileSaver.saveAs(blob, filename);
  }
  


}
@Component({
  selector:'confirmationDialog',
  templateUrl:'./confirmationDialog.html'
  
})
export class confirmationDialog{
  public applicationId:any;
  public number:any;
  
  constructor(public dialogRef: MatDialogRef<confirmationDialog>,public jobService: JobApplicationService,private route: Router,
    @Inject(MAT_DIALOG_DATA) public data:any){
      this.applicationId = data;
    }

    passApplication(){
      this.jobService.passApplicationService(this.applicationId.id).subscribe(res=>{
        this.route.navigate(['/applicants'])
        this.dialogRef.close();
      },error=>{
        console.log(error);
      })
    }
}
@Component({
  selector:'droppedDialog',
  templateUrl:'./droppedDialog.html'
  
})
export class droppedDialog{
  public applicationId:any;
  public comment:string='';
  public failed:boolean=false;
  public message:string='';
  
  constructor(public dialogRef: MatDialogRef<droppedDialog>,public jobService: JobApplicationService,private route: Router,
    @Inject(MAT_DIALOG_DATA) public data:any){
      this.applicationId = data;
    }

    dropApplication(){
      if(this.comment.length <=0){
        this.failed = true;
        this.message = "Comment is required";
        console.log("result "+this.comment.length);
      }else{
      this.jobService.dropApplicationService(this.applicationId.id, this.comment).subscribe(res=>{
        this.route.navigate(['/applicants'])
        this.dialogRef.close();
        this.comment = '';
        this.failed = false;
      },error=>{
        this.failed = true;
        this.message = error.error.message;
        console.log(error);
      })
    }
  }
}
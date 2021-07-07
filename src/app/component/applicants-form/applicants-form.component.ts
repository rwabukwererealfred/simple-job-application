import { Component, OnInit, Inject } from '@angular/core';
import { JobApplicationService } from 'src/app/service/job-application.service';
import { Job } from 'src/app/Model/Job';
import { StorageTokenService } from 'src/app/service/storage-token.service';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { JobApplication } from 'src/app/Model/JobApplication';

@Component({
  selector: 'app-applicants-form',
  templateUrl: './applicants-form.component.html',
  styleUrls: ['./applicants-form.component.css']
})
export class ApplicantsFormComponent implements OnInit {
  page = 1;
  count = 0;
  
  tableSize = 10;
  tableSizes = [10,15,20];
  
  public filterTerm: any;

  public applicants:any;
  public job:Job =new Job();
  public check : boolean = false;
  constructor(private applicationService: JobApplicationService, private storage: StorageTokenService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.applicantsList();
    if(this.storage.getUser() !== null){
        this.check = true;
        
    }
    
  }
  applicantsList(){
    this.applicationService.applicantsList().subscribe(res=>{
      this.applicants = res;
    },error=>{
      console.log(error);
    })
  }
  openApproveDiaolog(application:JobApplication){
    const dialogRef= this.dialog.open(commentDialog,{
      
       data:application
     });
  }
  onTableDataChange($event: any){
    this.page = $event;
    this.applicantsList();
  }
  onTableSizeChange($event:any): void {
    this.tableSize = $event.target.value;
    this.page = 1;
    this.applicantsList();


  } 
  
}

@Component({
  selector:'commentDialog',
  templateUrl:'./commentDialog.html'
  
})
export class commentDialog{
  public applicationId:any;
  public number:any;
  
  constructor(public dialogRef: MatDialogRef<commentDialog>,public jobService: JobApplicationService,private route: Router,
    @Inject(MAT_DIALOG_DATA) public data:any){
      this.applicationId = data;
    }

    
}

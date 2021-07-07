import { Component, OnInit } from '@angular/core';
import { JobApplicationService } from 'src/app/service/job-application.service';
import { User } from 'src/app/Model/User';
import { StorageTokenService } from 'src/app/service/storage-token.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  public fail: boolean = false;
  public success: boolean = false;
  public failedMessage: string = '';
  public user: User = new User();
  public retype: string = '';
  constructor(private applicationService: JobApplicationService, private storage: StorageTokenService) { }

  ngOnInit(): void {
  }

  createAccount() {
    if (this.retype == this.user.password) {
      this.applicationService.createNewAccount(this.user).subscribe(res => {
        this.user = new User();
        this.success = true;
        this.fail = false;
      }, error => {
        this.fail = true;
        this.success = false;
        this.failedMessage = error.error.message;
        console.log(error);
      })
    } else {
      this.fail = true;
      this.success = false;
      this.failedMessage = 'Please retype well your password';
    }
  }
}

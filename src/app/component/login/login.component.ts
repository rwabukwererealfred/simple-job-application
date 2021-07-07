import { Component, OnInit } from '@angular/core';
import { StorageTokenService } from 'src/app/service/storage-token.service';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form:any={};
  public loginFail:boolean= false;
  public loginSuccessFull:boolean=false;
  
  public currentUser:any;
  public message:string='';
  constructor(private storage: StorageTokenService, private route:Router, private authentication: AuthenticationService) { }

  ngOnInit(): void {
    
  }
  submit(){
    
    this.authentication.login(this.form).subscribe(data =>{
      this.loginFail = false;
      this.loginSuccessFull = true;
      this.storage.saveToken(data.token);
      this.storage.saveUser(data); 
      this.currentUser = this.storage.getUser();
      console.log(this.currentUser.username);
     this.route.navigate(['/jobListed']);
    }, error=>{
      console.log(this.form);
      console.log(error);
      this.loginFail = true;
      this.loginSuccessFull = false;
      this.message = error.error.message;
    });
  }

}

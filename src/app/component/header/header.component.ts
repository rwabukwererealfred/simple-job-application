import { Component, OnInit } from '@angular/core';
import { StorageTokenService } from 'src/app/service/storage-token.service';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public page:boolean = false;
  constructor(private storage: StorageTokenService, private auth: AuthenticationService, private route: Router) { }

  ngOnInit(): void {
    if(this.storage.getToken() !== null){
      this.page = true;
  }else{
    this.page = false;
  }

}
logout(){
  this.storage.signout();
  this.route.navigate(['/jobListed']);

}
}

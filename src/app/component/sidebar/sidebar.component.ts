import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { StorageTokenService } from 'src/app/service/storage-token.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  public roles:string ='log';
  constructor(private storage: StorageTokenService) { }

  ngOnInit(): void {
    if(this.storage.getUser() !== null){
   this.roles = this.storage.getUser().user.status;
    }
  }

}

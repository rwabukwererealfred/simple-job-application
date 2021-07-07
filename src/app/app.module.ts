import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { SidebarComponent } from './component/sidebar/sidebar.component';
import { LoginComponent } from './component/login/login.component';
import { CreateAccountComponent } from './component/create-account/create-account.component';
import { MatTabsModule } from '@angular/material/tabs';
import { MatDialogModule, MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import { MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { JobListedComponent } from './component/job-listed/job-listed.component';
import { JobDetailsComponent } from './component/job-details/job-details.component';
import { ApplicationFormComponent } from './component/application-form/application-form.component';
import { ApplicantsFormComponent, commentDialog } from './component/applicants-form/applicants-form.component';
import { ApplicantDetailsComponent, confirmationDialog, droppedDialog } from './component/applicant-details/applicant-details.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { MatSortModule } from '@angular/material/sort';
import { NgxPaginationModule } from 'ngx-pagination';
import { authInterceptorProviders } from './service/auth.interceptor';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
    LoginComponent,
    CreateAccountComponent,
    JobListedComponent,
    JobDetailsComponent,
    ApplicationFormComponent,
    ApplicantsFormComponent,
    ApplicantDetailsComponent, confirmationDialog,droppedDialog, commentDialog
  ],
  entryComponents: [confirmationDialog, droppedDialog, commentDialog],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,MatFormFieldModule,
    FormsModule,MatButtonModule,MatTabsModule,
    HttpClientModule, MatTabsModule,MatDialogModule, MatInputModule
    ,MatPaginatorModule,Ng2SearchPipeModule,
    MatSortModule,NgxPaginationModule,ReactiveFormsModule
  ],
  providers: [
    authInterceptorProviders,
    { provide:MAT_DIALOG_DATA, useValue:{}},
    { provide:MatDialogRef, useValue:{}}  
  
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { CreateAccountComponent } from './component/create-account/create-account.component';
import { JobListedComponent } from './component/job-listed/job-listed.component';
import { JobDetailsComponent } from './component/job-details/job-details.component';
import { ApplicationFormComponent } from './component/application-form/application-form.component';
import { ApplicantsFormComponent } from './component/applicants-form/applicants-form.component';
import { ApplicantDetailsComponent } from './component/applicant-details/applicant-details.component';

const routes: Routes = [
  { path: '', pathMatch:'full', redirectTo:'jobListed'},
  { path: 'login', component:LoginComponent},
  { path: 'createAccount', component:CreateAccountComponent},
  { path: 'jobListed', component:JobListedComponent},
  { path: 'jobDetails/:jobId', component:JobDetailsComponent},
  { path: 'applicationForm/:jobId', component:ApplicationFormComponent},
  { path: 'applicants', component:ApplicantsFormComponent},
  { path: 'applicantDetail/:id', component:ApplicantDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

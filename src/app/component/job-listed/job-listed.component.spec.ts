import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobListedComponent } from './job-listed.component';

describe('JobListedComponent', () => {
  let component: JobListedComponent;
  let fixture: ComponentFixture<JobListedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JobListedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JobListedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplicantsFormComponent } from './applicants-form.component';

describe('ApplicantsFormComponent', () => {
  let component: ApplicantsFormComponent;
  let fixture: ComponentFixture<ApplicantsFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApplicantsFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplicantsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

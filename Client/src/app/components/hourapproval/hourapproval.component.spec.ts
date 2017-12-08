import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HourapprovalComponent } from './hourapproval.component';

describe('HourapprovalComponent', () => {
  let component: HourapprovalComponent;
  let fixture: ComponentFixture<HourapprovalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HourapprovalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HourapprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

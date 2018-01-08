import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingHourComponent } from './pending-hour.component';

describe('PendingHourComponent', () => {
  let component: PendingHourComponent;
  let fixture: ComponentFixture<PendingHourComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendingHourComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingHourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

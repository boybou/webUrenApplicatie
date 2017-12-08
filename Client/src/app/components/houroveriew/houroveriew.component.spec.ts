import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HouroveriewComponent } from './houroveriew.component';

describe('HouroveriewComponent', () => {
  let component: HouroveriewComponent;
  let fixture: ComponentFixture<HouroveriewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HouroveriewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HouroveriewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

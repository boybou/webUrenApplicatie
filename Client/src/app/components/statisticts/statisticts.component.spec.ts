import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StatistictsComponent } from './statisticts.component';

describe('StatistictsComponent', () => {
  let component: StatistictsComponent;
  let fixture: ComponentFixture<StatistictsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StatistictsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StatistictsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

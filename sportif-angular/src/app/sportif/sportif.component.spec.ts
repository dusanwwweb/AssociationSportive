import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SportifComponent } from './sportif.component';

describe('SportifComponent', () => {
  let component: SportifComponent;
  let fixture: ComponentFixture<SportifComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SportifComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SportifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

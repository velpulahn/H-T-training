import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HcoUserComponent } from './hco-user.component';

describe('HcoUserComponent', () => {
  let component: HcoUserComponent;
  let fixture: ComponentFixture<HcoUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HcoUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HcoUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

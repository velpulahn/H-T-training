import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountExecutiveComponent } from './account-executive.component';

describe('AccountExecutiveComponent', () => {
  let component: AccountExecutiveComponent;
  let fixture: ComponentFixture<AccountExecutiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AccountExecutiveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountExecutiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

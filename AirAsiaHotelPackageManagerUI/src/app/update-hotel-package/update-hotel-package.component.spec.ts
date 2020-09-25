import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateHotelPackageComponent } from './update-hotel-package.component';

describe('UpdateHotelPackageComponent', () => {
  let component: UpdateHotelPackageComponent;
  let fixture: ComponentFixture<UpdateHotelPackageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateHotelPackageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateHotelPackageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelPackageDetailsComponent } from './hotel-package-details.component';

describe('HotelPackageDetailsComponent', () => {
  let component: HotelPackageDetailsComponent;
  let fixture: ComponentFixture<HotelPackageDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HotelPackageDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelPackageDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

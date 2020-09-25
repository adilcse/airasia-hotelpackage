import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelPackageListComponent } from './hotel-package-list.component';

describe('HotelPackageListComponent', () => {
  let component: HotelPackageListComponent;
  let fixture: ComponentFixture<HotelPackageListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HotelPackageListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelPackageListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

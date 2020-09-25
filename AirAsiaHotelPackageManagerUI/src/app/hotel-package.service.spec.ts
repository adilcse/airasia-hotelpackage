import { TestBed } from '@angular/core/testing';

import { HotelPackageService } from './hotel-package.service';

describe('HotelPackageService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HotelPackageService = TestBed.get(HotelPackageService);
    expect(service).toBeTruthy();
  });
});

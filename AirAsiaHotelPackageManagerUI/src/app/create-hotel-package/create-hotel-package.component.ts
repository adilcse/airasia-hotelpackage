import { Component, OnInit } from '@angular/core';
import { HotelPackage } from '../hotel-package';
import { HotelPackageService } from '../hotel-package.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-hotel-package',
  templateUrl: './create-hotel-package.component.html',
  styleUrls: ['./create-hotel-package.component.css']
})
export class CreateHotelPackageComponent implements OnInit {

  hotelPackage: HotelPackage = new HotelPackage();
  submitted = false;

  constructor(private hotelPackageService: HotelPackageService, private router: Router) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.hotelPackage = new HotelPackage();
  }

  save() {
    this.hotelPackageService.createHotelPackage(this.hotelPackage)
      .subscribe(data => console.log(data), error => console.log(error));
    this.hotelPackage = new HotelPackage();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/hotelpackages']);
  }

}

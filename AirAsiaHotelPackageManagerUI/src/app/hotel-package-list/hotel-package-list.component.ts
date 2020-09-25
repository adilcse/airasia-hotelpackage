import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HotelPackageService } from '../hotel-package.service';
import { Router } from '@angular/router';
import { HotelPackage } from './../hotel-package';
import * as moment from 'moment';

@Component({
  selector: 'app-hotel-package-list',
  templateUrl: './hotel-package-list.component.html',
  styleUrls: ['./hotel-package-list.component.css']
})
export class HotelPackageListComponent implements OnInit {

  hotelPackages: Observable<HotelPackage[]>;
  moment: any = moment;

  constructor(private hotelPackageService: HotelPackageService, private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.hotelPackages = this.hotelPackageService.getHotelPackagesList();
  }

  deleteHotelPackage(id: number) {
    this.hotelPackageService.deleteHotelPackage(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  hotelPackageDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateHotelPackage(id: number){
    this.router.navigate(['update', id]);
  }

}

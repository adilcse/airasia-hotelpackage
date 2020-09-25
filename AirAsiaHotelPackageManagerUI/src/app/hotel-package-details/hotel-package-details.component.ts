import { Component, OnInit } from '@angular/core';
import { HotelPackageService } from '../hotel-package.service';
import { HotelPackage } from '../hotel-package';
import { ActivatedRoute, Router } from '@angular/router';
import * as moment from 'moment';

@Component({
  selector: 'app-hotel-package-details',
  templateUrl: './hotel-package-details.component.html',
  styleUrls: ['./hotel-package-details.component.css']
})
export class HotelPackageDetailsComponent implements OnInit {

  id: number;
  hotelPackage: HotelPackage;
  moment: any = moment;

  constructor(private route: ActivatedRoute, private router: Router, private hotelPackageService: HotelPackageService) { }

  ngOnInit() {
    this.hotelPackage = new HotelPackage();

    this.id = this.route.snapshot.params['id'];

    this.hotelPackageService.getHotelPackage(this.id)
      .subscribe(data => {
        console.log(data)
        this.hotelPackage = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['hotelpackages']);
  }

}

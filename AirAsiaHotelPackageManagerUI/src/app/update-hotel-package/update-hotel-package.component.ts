import { Component, OnInit } from '@angular/core';
import { HotelPackage } from '../hotel-package';
import { HotelPackageService } from '../hotel-package.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-hotel-package',
  templateUrl: './update-hotel-package.component.html',
  styleUrls: ['./update-hotel-package.component.css']
})
export class UpdateHotelPackageComponent implements OnInit {

  hotelPackage: HotelPackage = new HotelPackage();
  id: number;

  constructor(private route: ActivatedRoute, private hotelPackageService: HotelPackageService, private router: Router) { }

  ngOnInit() {
    this.hotelPackage = new HotelPackage();

    this.id = this.route.snapshot.params['id'];

    this.hotelPackageService.getHotelPackage(this.id)
      .subscribe(data => {
        console.log(data);
        this.hotelPackage = data;
      }, error => console.log(error));
  }

  updateHotelPackage() {
    this.hotelPackageService.updateHotelPackage(this.id, this.hotelPackage)
      .subscribe(data => console.log(data), error => console.log(error));
    this.hotelPackage = new HotelPackage();
    this.gotoList();
  }

  onSubmit() {
    this.updateHotelPackage();
  }

  gotoList() {
    this.router.navigate(['/hotelPackages']);
  }

}

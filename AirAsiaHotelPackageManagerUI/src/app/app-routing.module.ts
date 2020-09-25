import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateHotelPackageComponent } from './create-hotel-package/create-hotel-package.component';
import { HotelPackageListComponent } from './hotel-package-list/hotel-package-list.component';
import { UpdateHotelPackageComponent } from './update-hotel-package/update-hotel-package.component';
import { HotelPackageDetailsComponent } from './hotel-package-details/hotel-package-details.component';


const routes: Routes = [
  { path: '', redirectTo: 'hotelpackages', pathMatch: 'full' },
  { path: 'hotelpackages', component: HotelPackageListComponent },
  { path: 'add', component: CreateHotelPackageComponent },
  { path: 'update/:id', component: UpdateHotelPackageComponent },
  { path: 'details/:id', component: HotelPackageDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateHotelPackageComponent } from './create-hotel-package/create-hotel-package.component';
import { HotelPackageDetailsComponent } from './hotel-package-details/hotel-package-details.component';
import { HotelPackageListComponent } from './hotel-package-list/hotel-package-list.component';
import { UpdateHotelPackageComponent } from './update-hotel-package/update-hotel-package.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    CreateHotelPackageComponent,
    HotelPackageDetailsComponent,
    HotelPackageListComponent,
    UpdateHotelPackageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

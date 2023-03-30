import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { AccueilComponent } from './accueil/accueil.component';
import { FournisseurComponent } from './fournisseur/fournisseur.component';
import { FournisseurService } from './fournisseur/fournisseur.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule }from '@angular/common/http';
import { ProduitComponent } from './produit/produit.component';
import { ProduitService } from './produit/produit.service';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    AccueilComponent,
    FournisseurComponent,
    ProduitComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [FournisseurService, ProduitService],
  bootstrap: [AppComponent]
})
export class AppModule { }
